package basic;

class MessagePrinter implements Runnable {
    private String message;

    public MessagePrinter(String message) {
        this.message = message;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + ": " + message);
    }
}

public class Multiple {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MessagePrinter("Welcome To Java 1"));
        Thread t2 = new Thread(new MessagePrinter("Welcome To Java 2"));

        t1.start();
        t2.start();
    }
}

