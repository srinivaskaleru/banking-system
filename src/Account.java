

public class Account {
    private String accountNumber;
    private double balance;
    private String accountHolder;

    public Account(String accountNumber, double balance, String accountHolder) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.accountHolder = accountHolder;
    }

   public void deposit(double amount){
        this.balance += amount;
   }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds!");
        }
            else{
                balance = balance - amount;
        }
    }
    public String toString(){
        return "Account{ " + "account number = "
        + accountNumber + ", balance = "
                + balance + ", accountHolder = "
                + accountHolder + "}";
    }
}
