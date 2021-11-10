package threads;


import activeObject.CompletionFuture;
import activeObject.Proxy;

public class Consumer extends Client {

    public Consumer(int id, Proxy proxy, int maxPortion) {
        super(id, proxy, maxPortion);
    }

    public void consume() throws InterruptedException {
        int amount = random.nextInt(maxPortion) + 1;
        CompletionFuture future =  proxy.consume(amount);
        // TODO dodatkowe zadanie
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
                e.printStackTrace();
            }
        }
    }
}
