package ObjectOrientedAssignments.AccountingProject;

public class CreditCardAccount implements Accountable {
    private String accountHolderName;
    private String cardNumber;
    private int debt;
    private int balance;

    CreditCardAccount(String accountHolderName, String cardNumber) {
        this.accountHolderName = accountHolderName;
        this.cardNumber = cardNumber;
        this.debt = 0;
        this.balance = 0;
    }

    // getters
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public String getCardNumber() {
        return cardNumber;
    }
    public int getDebt() {
        return debt;
    }
    @Override
    public int getBalance() {
        return -this.debt;
    }

    //methods
    public int pay(int amountToPay) {
        if(amountToPay > 0) {
            this.debt -= amountToPay;
            return this.debt;
        }
        return this.debt;
    }
    public int charge(int amountToCharge) {
        if(amountToCharge > 0) {
            this.debt += amountToCharge;
            return this.debt;
        }
        return this.debt;
    }
}
