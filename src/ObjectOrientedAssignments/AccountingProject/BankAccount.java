package ObjectOrientedAssignments.AccountingProject;

public class BankAccount {
    // instance variablese + constructor
    private String accountHolderName;
    private String accountNumber;
    private int balance;

    BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        balance = 0;
    }
    BankAccount(String accountHolderName, String accountNumber, int balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    // getters
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public int getBalance() {
        return balance;
    }

    // methods
    public int deposit(int amountToDeposit) {
        if(amountToDeposit > 0) return balance + amountToDeposit;
        return balance;
    }
    public int withdraw(int amountToWithdraw) {
        if(amountToWithdraw > 0) return balance - amountToWithdraw;
        return balance;
    }
}
