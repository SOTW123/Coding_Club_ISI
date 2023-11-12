package ObjectOrientedAssignments.AccountingProject;

public class Main {
    public static void main(String[] args) {
        /*
        ObjectOrientedAssignments.Polymorphism.BankAccount checkingAccount = new CheckingAccount("Bernice", "CHK:1234");
        ObjectOrientedAssignments.Polymorphism.BankAccount savingsAccount = new SavingsAccount("Bernice", "SAV:9876");

        int amountToDeposit = 2;
        int newBalance = checkingAccount.deposit(amountToDeposit);
        System.out.println(newBalance);
        */
        BankAccount checkingAccount = new CheckingAccount("Bernice", "CHK:1234", 500);
        BankAccount savingsAccount = new SavingsAccount("Bernice", "SAV:9876", 200);

        checkingAccount.transferFunds(savingsAccount,100);

        System.out.println(checkingAccount.getBalance());
        System.out.println(savingsAccount.getBalance());

        /*
            x name = new y();
            name has access to x's methods and y's override methods
            constructor of y is called
                given that x is parent and y is child
                    if x and y are siblings, will result in error
         */
    }
}
