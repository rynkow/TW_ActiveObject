package activeObject;

import java.util.LinkedList;
import java.util.concurrent.LinkedBlockingQueue;

public class ActivationQueue {
    protected LinkedList<MethodRequest> priorityQueue;
    protected LinkedBlockingQueue<MethodRequest> queue;

    protected ActivationQueue(){
        queue = new LinkedBlockingQueue<>();
        priorityQueue = new LinkedList<>();
    }

    protected void enqueue(MethodRequest methodRequest) throws InterruptedException {
        queue.put(methodRequest);
    }

    protected MethodRequest dequeue() throws InterruptedException {
        if (!priorityQueue.isEmpty() && priorityQueue.peek().guard())
            return priorityQueue.poll();

        while(true){
            MethodRequest head = queue.take();
            MethodRequest priorityRequest = priorityQueue.peek();
            if (!head.getClass().isInstance(priorityRequest) && head.guard())
                return head;

            priorityQueue.add(head);
        }
    }

}
