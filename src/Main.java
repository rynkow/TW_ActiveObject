import activeObject.Proxy;
import threads.Consumer;
import threads.Producer;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        int noOfProducers = 10;
        int noOfConsumers = 10;
        int bufferCapacity = 10;

        Proxy proxy = new Proxy(bufferCapacity);

        List<Producer> producers = new ArrayList<>();
        List<Consumer> consumers = new ArrayList<>();

        for (int i = 0; i < noOfProducers; i++)
            producers.add(new Producer(i, proxy, bufferCapacity / 2));
        for (int i = 0; i < noOfConsumers; i++)
            consumers.add(new Consumer(i, proxy, bufferCapacity / 2));

        for (Producer producer : producers)
            producer.start();
        for (Consumer consumer : consumers)
            consumer.start();
    }
}
