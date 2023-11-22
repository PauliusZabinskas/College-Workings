package org.example;

import org.joda.money.Money;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.

/**
 * Paulius Zabinskas - 20120267
 */

public class Main {
    public static void main(String[] args) throws NegativeBalanceException, InterruptedException {


        Bank bank = new Bank();

        // Create and add three accounts to the bank
        bank.addAccount(new Account(12345, Money.parse("EUR 10000")));
        bank.addAccount(new Account(12346, Money.parse("EUR 10000")));
        bank.addAccount(new Account(12347, Money.parse("EUR 10000")));

        // Create transactions
        bank.addTransaction(new Transaction(12345, 1000));
        bank.addTransaction(new Transaction(12345, -100));


        // Create threads
        TransactionProcessor tp1 = new TransactionProcessor("TP1", bank);
        TransactionProcessor tp2 = new TransactionProcessor("TP2", bank);
        RandomTransactionGenerator rtg = new RandomTransactionGenerator(bank);

        // ExecutorService to manage threads
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.execute(tp1);
        executor.execute(tp2);
        executor.execute(rtg);

        // Shutdown RandomTransactionGenerator
        try {
            Thread.sleep(10000);
            rtg.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }




        bank.printAllAccounts();
    }


}