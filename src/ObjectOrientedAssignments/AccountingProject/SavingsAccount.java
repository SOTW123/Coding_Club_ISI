package ObjectOrientedAssignments.AccountingProject;

public class SavingsAccount extends BankAccount {
    SavingsAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }
    SavingsAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }
    @Override
    public int withdraw(int amountToWithdraw) {
        int remaining = getBalance() - amountToWithdraw;
        if(remaining < 150) {
            remaining -= 2;
            return remaining;
        }
        else if((remaining-2) < 0) {
            return getBalance();
        }
        return remaining;
    }
}
