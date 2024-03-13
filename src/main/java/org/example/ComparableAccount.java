package org.example;

import java.util.Date;

public class ComparableAccount extends Account
        implements Comparable<ComparableAccount>, Cloneable {

    public ComparableAccount(int id, double balance) { super(id, balance); }

    @Override
    public String toString() {
        String output = String.format("Account ID: %d  Balance: %.2f  Date created: %s",
                getId(), getBalance(), getDateCreated().toString());
        return output;
    }

    @Override
    public int compareTo(ComparableAccount other) {
        double thisBal = this.getBalance();
        double otherBal = other.getBalance();

        if (thisBal == otherBal) return 0;
        else if (thisBal > otherBal) return 1;
        else return -1;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // this "super" is Cloneable interface
        ComparableAccount clonedAccount = (ComparableAccount)super.clone();
        // Need to create a different Date object with the same value and add this to cloned account
        clonedAccount.dateCreated = (Date)this.getDateCreated().clone();

        return clonedAccount;
    }
}
