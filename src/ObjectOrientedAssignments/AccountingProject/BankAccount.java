package ObjectOrientedAssignments.AccountingProject;

public class BankAccount implements Accountable {
    // instance variablese + constructor
    private String accountHolderName;
    private String accountNumber;
    private int balance;

    BankAccount(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0;
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
        if(amountToDeposit > 0) {balance += amountToDeposit; return balance;}
        return balance;
    }
    public int withdraw(int amountToWithdraw) {
        if(amountToWithdraw > 0) {balance -= amountToWithdraw; return balance;}
        return balance;
    }
    // part 2
    public int transferFunds(BankAccount destinationAccount, int transferAmount) {
        this.balance -= transferAmount;
        this.withdraw(transferAmount);
        destinationAccount.deposit(transferAmount);
        return this.balance;
    }
}
