class BankAccount {
    int balance = 10000;
    Object lock = new Object();

    void withdraw(int amount) {
        synchronized (lock) {
            if (balance >= amount) {
                balance = balance - amount;
            }
        }
    }
}

public class Q12 {
    public static void main(String[] args)
            throws InterruptedException {

        BankAccount b = new BankAccount();

        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++)
                b.withdraw(1);
        });

        Thread t2 = new Thread(() -> {
            for (int i = 1; i <= 1000; i++)
                b.withdraw(1);
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final Balance: " + b.balance);
    }
}
