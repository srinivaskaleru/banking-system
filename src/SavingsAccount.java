public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount( String accountNumber, double balance, String accountHolder,
                           double interestRate) {
        super(accountNumber, balance, accountHolder);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double Interestrate = getBalance() * interestRate/100;
        super.deposit(Interestrate);
        System.out.println("Interest added: $" + Interestrate);
    }

    // Getter for interest rate
    public double getInterestRate() {
        return interestRate/100;
    }

    // Override toString() to include interest rate
    @Override
    public String toString() {
        return super.toString() + ", interestRate=" + interestRate + "%";
    }


}

