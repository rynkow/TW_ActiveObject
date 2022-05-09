package activeObject;

import task.Task;

public class Proxy {
    protected final Scheduler scheduler;
    protected final Servant servant;

    public Proxy(int bufferCapacity, Task task) {
        this.scheduler = new Scheduler();
        this.servant = new Servant(bufferCapacity, task);
        this.scheduler.start();
    }

    public CompletionFuture produce(int amount) throws InterruptedException {
        CompletionFuture future = new CompletionFuture();
        scheduler.enqueue(new ProduceRequest(servant, amount, future));
        return future;
    }

    public CompletionFuture consume(int amount) throws InterruptedException {
        CompletionFuture future = new CompletionFuture();
        scheduler.enqueue(new ConsumeRequest(servant, amount, future));
        return future;
    }

    public void interruptScheduler(){
        scheduler.interrupt();
    }

    public void stopScheduler(){
        scheduler.stop();
    }
}
