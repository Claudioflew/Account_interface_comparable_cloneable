// Student name: Koichi Nakata (ID: knakata595)

package org.example;

import java.util.ArrayList;
import java.util.Collections;

public class Assignment8_Part2 {
    public static final int NUM_OF_ACCOUNTS = 5;

    public static void main(String[] args) {
        ArrayList<ComparableAccount> accounts = new ArrayList<>();

        for (int i = 0; i < NUM_OF_ACCOUNTS; i++) {
            accounts.add(new ComparableAccount(1000 + i, 1000));
            accounts.get(i).deposit(500);
            accounts.get(i).withdraw(100 + 100 * i);
        }

        ArrayList<ComparableAccount> clonedAccounts = new ArrayList<>();

        for (ComparableAccount account : accounts) {
            try {
                // clone() returns Object type, therefore, needs to be downcast
                ComparableAccount cloned = (ComparableAccount)account.clone();
                clonedAccounts.add(cloned);
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Clone Array from elements");
        for (ComparableAccount cloned : clonedAccounts) {
            System.out.println(cloned);
        }


        System.out.println("\nChecking if the cloned ComparableAccount object is at the same memory location..");
        for (int i = 0; i < NUM_OF_ACCOUNTS; i++) {
            System.out.printf("CloneArray.dateCreated == OriginalArray[%d].dateCreated: %B\n", i,
                    accounts.get(i).getDateCreated() == clonedAccounts.get(i).getDateCreated());
        }

        System.out.println("\nChecking if the cloned ComparableAccount object has a Date object with the same value..");
        for (int i = 0; i < NUM_OF_ACCOUNTS; i++) {
            System.out.printf("CloneArray.dateCreated.compareTo(OriginalArray[%d].dateCreated): %d\n", i,
                    accounts.get(i).getDateCreated().compareTo(clonedAccounts.get(i).getDateCreated()));
        }

        System.out.println("\nBefore Sorting..");
        for (ComparableAccount account : accounts) {
            System.out.println(account);
        }

        Collections.sort(accounts);
        System.out.println("\nAfter Sorting..");
        for (ComparableAccount account : accounts) {
            System.out.println(account);
        }

        for (ComparableAccount cloned : clonedAccounts) cloned.withdraw(500);
        System.out.println("\nAfter withdrawing $500 from cloned accounts..");
        System.out.println("Original accounts:");
        for (ComparableAccount account : accounts) System.out.println(account);
        System.out.println("Cloned accounts:");
        for (ComparableAccount cloned : clonedAccounts) System.out.println(cloned);
    }
}