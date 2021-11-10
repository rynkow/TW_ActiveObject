package threads;

import activeObject.CompletionFuture;
import activeObject.Proxy;

public class Producer extends Client {

    public Producer(int id, Proxy proxy, int maxPortion) {
        super(id, proxy, maxPortion);
    }

    public void produce() throws InterruptedException {
        int amount = random.nextInt(maxPortion) + 1;
        CompletionFuture future = proxy.produce(amount);
        // TODO dodatkowe zadanie
        future.waitUntilCompletion();
        accessCounter++;
    }

    @Override
    public void run() {
        while (!interrupted()){
            try {
                produce();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

}
