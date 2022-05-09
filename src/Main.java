import activeObject.Proxy;
import task.SinusTask;
import task.Task;
import threads.Consumer;
import threads.Producer;

import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        int noOfProducers = 4;
        int noOfConsumers = 4;
        int bufferCapacity = 10;
        int servantSinusIterations = 1000000;
        int clientSinusIterations = 10000000;
        int testingTime = 2000;
        int testingIterations = 50;

        Task servantTask = new SinusTask(servantSinusIterations);

        Task clientTask = new SinusTask(clientSinusIterations);

        for (int j = 0; j < testingIterations; j++) {
            System.gc();
            Proxy proxy = new Proxy(bufferCapacity, servantTask);

            List<Producer> producers = new ArrayList<>();
            List<Consumer> consumers = new ArrayList<>();

            for (int i = 0; i < noOfProducers; i++)
                producers.add(new Producer(i, proxy, bufferCapacity / 2, clientTask));
            for (int i = 0; i < noOfConsumers; i++)
                consumers.add(new Consumer(i, proxy, bufferCapacity / 2, clientTask));

            for (Producer producer : producers)
                producer.start();
            for (Consumer consumer : consumers)
                consumer.start();
        }
    }
}


