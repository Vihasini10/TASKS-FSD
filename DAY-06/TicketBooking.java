package basic;
class TicketCounter {
    private int seats = 5;

    public synchronized void bookTicket(String user) {
        if (seats > 0) {
            System.out.println(user + " booking...");
            try {
                Thread.sleep(500); // simulate delay
            } catch (InterruptedException e) {}
            System.out.println(user + " booked successfully!");
            seats--;
            System.out.println("Seats left: " + seats);
        } else {
            System.out.println("Sorry " + user + ", no seats left.");
        }
    }
}

class User extends Thread {
    TicketCounter counter;
    String name;

    User(TicketCounter counter, String name) {
        this.counter = counter;
        this.name = name;
    }

    public void run() {
        counter.bookTicket(name);
    }
}

public class TicketBooking {
    public static void main(String[] args) {
        TicketCounter counter = new TicketCounter();
        User u1 = new User(counter, "Nisha");
        User u2 = new User(counter, "Dhanu");
        User u3 = new User(counter, "Angel");

        u1.start();
        u2.start();
        u3.start();
    }
}
