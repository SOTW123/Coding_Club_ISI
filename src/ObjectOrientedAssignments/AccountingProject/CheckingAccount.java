package ObjectOrientedAssignments.AccountingProject;

import javax.management.ConstructorParameters;

public class CheckingAccount extends BankAccount {
    CheckingAccount(String accountHolderName, String accountNumber) {
        super(accountHolderName, accountNumber);
    }
    CheckingAccount(String accountHolderName, String accountNumber, int balance) {
        super(accountHolderName, accountNumber, balance);
    }

    @Override
    public int withdraw(int amountToWithdraw) {
        if(getBalance() < 0 && (getBalance()-amountToWithdraw) > -100) {
            return getBalance() - amountToWithdraw - 10;
        }
        else if(getBalance() < 0 && ((getBalance()-amountToWithdraw) <= -100)) {
            return getBalance();
        }
        return getBalance() - amountToWithdraw;
    }


}
