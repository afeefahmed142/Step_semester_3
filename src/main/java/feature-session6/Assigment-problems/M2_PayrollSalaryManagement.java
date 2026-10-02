public class M2_PayrollSalaryManagement {
    static class PayrollAccount {
        private double basicSalary;
        private double bonus;

        public PayrollAccount(double openingSalary) {
            if (openingSalary < 0) {
                System.out.println("Warning: negative salary; starting at Rs 0.0");
                basicSalary = 0;
            } else {
                basicSalary = openingSalary;
            }
        }

        public void creditBonus(double amount) {
            if (amount <= 0) {
                System.out.println("Bonus rejected: amount must be positive");
                return;
            }
            bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }

        public void deductTax(double percent) {
            if (percent < 0 || percent > 100) {
                System.out.println("Tax rejected: percent must be between 0 and 100");
                return;
            }
            basicSalary -= basicSalary * percent / 100.0;
            System.out.println("Tax deducted: " + percent + "%");
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.println("Net salary: Rs " + account.getNetSalary());
    }
}