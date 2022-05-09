package threads;


import activeObject.CompletionFuture;
import activeObject.Proxy;
import task.Task;

public class Consumer extends Client {

    public Consumer(int id, Proxy proxy, int maxPortion, Task task) {
        super(id, proxy, maxPortion, task);
    }

    public void consume() throws InterruptedException {
        int amount = random.nextInt(maxPortion) + 1;
        CompletionFuture future =  proxy.consume(amount);
        task.run();
        future.waitUntilCompletion();
        accessCounter++;
    }

    @Override
    public void run() {
        while (!interrupted()){
            try {
                consume();
            }
            catch (InterruptedException e){
                //
            }
        }
    }
}
