public class Checkingaccount extends Account{

    private int transactionLimit;  // Max transactions per month
    private int transactionsUsed;  // Transactions used this month
    private double monthlyFee;
    public Checkingaccount(String accountNumber, double accountBalance, String accountHolder,
            int transactionLimit, int transactionsUsed, double monthlyFee) {
        super(accountNumber,accountBalance,accountHolder);
        this.transactionLimit = transactionLimit;
        this.transactionsUsed = 0;
        this.monthlyFee = monthlyFee;
    }

    @Override
    public void withdraw(double amount) {
        if (transactionsUsed >= transactionLimit) {
            System.out.println("You have reached the maximum transaction limit of " + transactionLimit);
        }
        if (amount > getBalance()){
            System.out.println("You have not enough balance to withdraw " + amount);
        }
        super.withdraw(amount);
        transactionsUsed++;
    }

    @Override
    public void deposit(double amount) {
        super.deposit(amount);
    }
    public void deductMonthlyFee() {
        super.withdraw(monthlyFee);
        System.out.println("You have deducted the monthly fees");
    }

    public int resettransactions() {
        transactionsUsed = 0;
        return transactionsUsed;
    }

    @Override
    public String toString() {
        return super.toString() + ", transactionLimit=" + transactionLimit +
                ", transactionsUsed=" + transactionsUsed + ", monthlyFee=" + monthlyFee;
    }
}
