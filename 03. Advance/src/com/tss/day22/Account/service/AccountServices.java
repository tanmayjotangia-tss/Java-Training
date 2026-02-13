package com.tss.day22.Account.service;

import com.tss.day22.Account.model.Account;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class AccountServices {
    static void main() {
        List<Account> accountList = new ArrayList<>();
        accountList.add(new Account(1, "Tanmay",25));
        accountList.add(new Account(2, "Divyaraj",200000));
        accountList.add(new Account(3, "Smit",1000));
        accountList.add(new Account(4, "Darshit",3000));
        accountList.add(new Account(5, "Dhrumil",2524));

        System.out.println("Account details with minimum balance");
        Optional<Account> minBalanceAccount = accountList.stream()
                .min(Comparator.comparing(Account::getBalance));

        System.out.println(minBalanceAccount.get());


        System.out.println("Account details with maximum balance");
        Optional<Account> maxBalanceAccount = accountList.stream()
                .max(Comparator.comparing(Account::getBalance));

        System.out.println(maxBalanceAccount);

        System.out.println("Names greater than 6 characters");
        accountList.stream()
                .filter(account -> account.getName().length() >= 6)
                .forEach(System.out::println);

//        double totalBalance = accountList.stream()
//                .mapToDouble(account -> account.getBalance())
//                .sum();

//        double totalBalance = accountList.stream()
//                        .map(Account::getBalance)
//                                .reduce(0.0,Double::sum);

        double totalBalance = accountList.stream()
                        .map(Account::getBalance)
                                .reduce(0.0,(a,b) -> a+b);

        System.out.println("Total balance of all accounts: " + totalBalance);

    }
}
