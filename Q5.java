import java.util.Random;

class Q5Thread extends Thread {

    Q5Thread(String name) {
        super(name);
    }

    public void run() {
        try {
            Random r = new Random();
            int time = r.nextInt(501);

            Thread.sleep(time);

            System.out.println(getName() + " is working");

        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class Q5 {
    public static void main(String[] args) {

        Q5Thread t1 = new Q5Thread("Reader");
        Q5Thread t2 = new Q5Thread("Writer");
        Q5Thread t3 = new Q5Thread("Logger");

        t1.start();
        t2.start();
        t3.start();
    }
}
