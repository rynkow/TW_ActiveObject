package threads;

import activeObject.Proxy;

public class BiasedConsumer extends Consumer{
    protected final int amount;

    public BiasedConsumer(int id, Proxy proxy, int amount) {
        super(id, proxy, 0);
        this.amount = amount;
    }

    @Override
    public void consume() {
        proxy.consume(amount);
        accessCounter++;
    }
}
