package ObjectOrientedAssignments.AccountingProject;

import java.util.*;

public class BankCustomer extends CreditCardAccount {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Accountable> accounts = new ArrayList<>();

    BankCustomer(String accountHolderName, String cardNumber) {
        super(accountHolderName, cardNumber);
    }

    // getters

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    // methods
    public Accountable[] getAccounts() {
        Accountable[] arrAccounts = new Accountable[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {
            arrAccounts[i] = accounts.get(i);
        }
        return arrAccounts;
    }
    public void addAccount(Accountable newAccount) {
        accounts.add(newAccount);
    }
    public boolean isVip() {
        int sum = getBalance() - getDebt();
        return sum >= 25000;
    }
}
