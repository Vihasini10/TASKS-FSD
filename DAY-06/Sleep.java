package basic;

class Worker extends Thread {
    private String task;

    Worker(String task) {
        this.task = task;
    }

    public void run() {
        try {
            System.out.println(task + " started.");
            Thread.sleep(1000); 
            System.out.println(task + " completed.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Sleep {
    public static void main(String[] args) {
        Worker w1 = new Worker("Task 1");
        Worker w2 = new Worker("Task 2");

        w1.start();
        try {
            w1.join(); 
        } catch (InterruptedException e) { }

        w2.start();
    }
}

