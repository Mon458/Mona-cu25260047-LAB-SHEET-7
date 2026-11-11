class Buffer {
    int data;
    boolean available = false;

    synchronized void produce(int value)
            throws InterruptedException {

        while (available)
            wait();

        data = value;
        available = true;

        System.out.println("Produced: " + value);
        notifyAll();
    }

    synchronized void consume()
            throws InterruptedException {

        while (!available)
            wait();

        System.out.println("Consumed: " + data);
        available = false;

        notifyAll();
    }
}

public class Q13 {
    public static void main(String[] args) {
        Buffer b = new Buffer();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++)
                    b.produce(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 10; i++)
                    b.consume();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}
