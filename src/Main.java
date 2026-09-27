//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        System.out.println("Hello and welcome to my Account!");

        Account savings = new SavingsAccount("SAV001", 5000, "Srini", 3.5);
        Account checking = new Checkingaccount("CHK001", 3000, "Srini", 5, 10,12.5);
        Account credit = new CreditAccount("CC001", 500,"Srini", 5000, 2000,1.5,200);

        // Test Savings Account
        System.out.println("--- SAVINGS ACCOUNT ---");
        System.out.println(savings);
        savings.deposit(1000);
        savings.withdraw(500);
        System.out.println("Balance: " + savings.getBalance());
        ((SavingsAccount) savings).addInterest();
        System.out.println("Balance after interest: " + savings.getBalance());

        // Test Checking Account
        System.out.println("\n--- CHECKING ACCOUNT ---");
        System.out.println(checking);
        checking.deposit(500);
        checking.withdraw(200);
        checking.withdraw(300);
        checking.withdraw(400);
        checking.withdraw(500);
        checking.withdraw(600);  // Should fail - transaction limit
        ((Checkingaccount) checking).deductMonthlyFee();
        System.out.println("Balance after deductmonthlyfee: " + checking.getBalance());

        // Test Credit Card
        System.out.println("\n--- CREDIT CARD ---");
        System.out.println(credit);
        credit.withdraw(300);   // Use own money
        credit.withdraw(2000);  // Borrow
        credit.withdraw(2000);  // Borrow more
        ((CreditAccount) credit).applyInterest();
        ((CreditAccount) credit).payBill(1000);
        System.out.println(credit);

        // Polymorphism in action!
        System.out.println("\n--- POLYMORPHISM DEMO ---");
        Account[] accounts = {savings, checking, credit};

        System.out.println("\nAll accounts after 1000 deposit:");
        for (Account acc : accounts) {
            acc.deposit(1000);
            System.out.println(acc);
        }
    }
}