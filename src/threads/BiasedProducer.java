package threads;

import activeObject.Proxy;

public class BiasedProducer extends Producer{
    protected final int amount;

    public BiasedProducer(int id, Proxy proxy, int amount) {
        super(id, proxy, 0);
        this.amount = amount;
    }

    @Override
    public void produce() {
        proxy.produce(amount);
        accessCounter++;
    }
}
