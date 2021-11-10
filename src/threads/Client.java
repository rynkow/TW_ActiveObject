package threads;

import activeObject.Proxy;

import java.util.Random;

public abstract class Client extends Thread{
    protected final int id;
    protected final Proxy proxy;
    protected final int maxPortion;
    protected final Random random;
    protected int accessCounter;

    public Client(int id, Proxy proxy, int maxPortion) {
        this.id = id;
        this.proxy = proxy;
        this.maxPortion = maxPortion;
        this.random = new Random(id);
    }

    public int getAccessCounter() {
        return accessCounter;
    }


}
