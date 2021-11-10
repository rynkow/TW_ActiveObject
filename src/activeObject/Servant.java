package activeObject;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

public class Servant {
    protected int buffer;
    protected final int bufferCapacity;

    protected Servant(int bufferCapacity) {
        this.bufferCapacity = bufferCapacity;
        this.buffer = 0;
    }

    protected void produce(int amount, CompletionFuture future){
        buffer += amount;
        // TODO wykonaj intensywne zadanie
        System.out.println("wyprodukowano " + amount + " el w buforze " + buffer);
        future.complete();
    }

    protected void consume(int amount, CompletionFuture future){
        buffer -= amount;
        // TODO wykonaj intensywne zadanie
        System.out.println("skonsumowano " + amount + " el w buforze " + buffer);
        future.complete();
    }

    protected int freeSpace(){
        return bufferCapacity-buffer;
    }

    protected int elementsInBuffer(){
        return buffer;
    }

    protected boolean isEmpty(){
        return buffer == 0;
    }

    protected boolean isFull(){
        return buffer == bufferCapacity;
    }
}
