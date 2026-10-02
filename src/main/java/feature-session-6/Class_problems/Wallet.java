class Wallet{
    private double balance;

    public Wallet(double balance) {
        if (balance < 0) {
            System.out.println("Warning: Negative balance not allowed");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected");
        } else {
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Deduct rejected: invalid amount");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class Main {
    public static void main(String[] args) {
        Wallet w = new Wallet(500);

        w.topUp(200);
        w.deduct(1000);
    }
}