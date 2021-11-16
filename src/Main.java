import activeObject.Proxy;
import activeObject.Task;
import threads.Consumer;
import threads.Producer;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Task servant_task = new Task() {
            @Override
            public void run() {
                double a = Math.sin(12.65);
            }
        };

        Task producer_task = new Task() {
            @Override
            public void run() {
                double a = Math.sin(83.55);
            }
        };

        Task consumer_task = new Task() {
            @Override
            public void run() {
                double a = Math.sin(42.64);
            }
        };

        int noOfProducers = 10;
        int noOfConsumers = 10;
        int bufferCapacity = 10;

        Proxy proxy = new Proxy(bufferCapacity, servant_task);

        List<Producer> producers = new ArrayList<>();
        List<Consumer> consumers = new ArrayList<>();

        for (int i = 0; i < noOfProducers; i++)
            producers.add(new Producer(i, proxy, bufferCapacity / 2, producer_task));
        for (int i = 0; i < noOfConsumers; i++)
            consumers.add(new Consumer(i, proxy, bufferCapacity / 2, consumer_task));

        for (Producer producer : producers)
            producer.start();
        for (Consumer consumer : consumers)
            consumer.start();
    }
}
