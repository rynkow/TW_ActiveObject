package task;

public class SinusTask extends Task{
    private final int iterations;

    public SinusTask(int iterations) {
        this.iterations = iterations;
    }

    @Override
    public void run() {
        double a = Math.sin(12.65);
        for (int i = 0; i < iterations; i++)
            a = Math.sin(12.65 * a);
    }
}
