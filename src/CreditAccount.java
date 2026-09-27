public class CreditAccount extends Account
{
    private double creditLimit;    // How much can borrow
    private double creditUsed;     // How much already borrowed
    private double interestRate;   // Interest on borrowed amount
    private double dueAmount;      // Amount due

    public CreditAccount(String accountNumber,
                         double balance, String accountHolder,double creditLimit, double creditUsed, double interestRate,
                         double dueAmount)
    {
        super(accountNumber,balance,accountHolder);
        this.creditLimit = creditLimit;
        this.creditUsed = 0;
        this.interestRate = interestRate;
        this.dueAmount = 0;

    }

public double getCreditLimit()
    {
        return creditLimit;
    }

    @Override
    public void withdraw(double amount) {
       if (amount <= getBalance())
       {
           super.withdraw(amount);
       }
       //borrow money from credit
       else if(amount+creditUsed < creditLimit)
       {
       creditUsed += amount;
       dueAmount += amount;
       super.withdraw(amount);
           System.out.println("Amount borrowed: " + amount + " (Credit used: " + creditUsed + ")");
       }
       else {
           System.out.println("Credit limit exceeded");
       }
    }

    public  void payBill(double amount)
    {
        if (amount > dueAmount){
            System.out.println("Payment exceeds due amount!");
            return;
        }
        dueAmount += amount;
        creditUsed += amount;
        super.deposit(amount);
        System.out.println("Payment of " + amount + " received. Due: " + dueAmount);
    }
    public void applyInterest(){
        double interest = creditUsed * interestRate / 100;
        dueAmount += interest;
        System.out.println("interest applied: " + interest);
    }

    @Override
    public String toString() {
        return super.toString() + ", creditLimit=" + creditLimit +
                ", creditUsed=" + creditUsed + ", dueAmount=" + dueAmount;
    }
}
