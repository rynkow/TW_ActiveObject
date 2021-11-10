package activeObject;

public class Proxy {
    protected final Scheduler scheduler;
    protected final Servant servant;

    public Proxy(int bufferCapacity) {
        this.scheduler = new Scheduler();
        this.servant = new Servant(bufferCapacity);
        this.scheduler.start();
    }

    public CompletionFuture produce(int amount){
        CompletionFuture future = new CompletionFuture();
        scheduler.enqueue(new ProduceRequest(servant, amount, future));
        return future;
    }

    public CompletionFuture consume(int amount){
        CompletionFuture future = new CompletionFuture();
        scheduler.enqueue(new ConsumeRequest(servant, amount, future));
        return future;
    }
}
