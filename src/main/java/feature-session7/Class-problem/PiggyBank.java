public class PiggyBank {
    static class PiggyBank {
        private double savings;
        private final String id;

        PiggyBank(String id) {
            this.id = id;
            this.savings = 0;
        }

        void deposit(double amount) {
            if (amount > 0) savings += amount;
        }

        void withdraw(double amount) {
            if (amount <= 0 || amount > savings) {
                System.out.println("Withdrawal rejected");
                return;
            }
            savings -= amount;
        }

        double getSavings() {
            return savings;
        }
    }

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        System.out.println("Savings: " + pb.getSavings());
        pb.withdraw(30);
        System.out.println("Savings: " + pb.getSavings());
        pb.withdraw(500);
        System.out.println("Savings: " + pb.getSavings());
    }
}