package activeObject;

public class Scheduler extends Thread{
    protected ActivationQueue queue;

    protected Scheduler(){
        queue = new ActivationQueue();
    }

    protected void enqueue(MethodRequest request) throws InterruptedException {
        queue.enqueue(request);
    }

    @Override
    public void run() {
        while (!interrupted()) {
            try {
                MethodRequest methodRequest = queue.dequeue();
                methodRequest.call();
            } catch (Exception e) {
                //
            }
        }
    }
}
