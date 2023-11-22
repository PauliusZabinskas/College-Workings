package org.example;

import org.joda.money.CurrencyUnit;
import org.joda.money.Money;

import java.math.RoundingMode;
import java.util.Random;

/**
 * Paulius Zabinskas - 20120267
 */
public class TransactionProcessor extends Thread {
    private String name;

    private Bank bank;
    private int depositsCount = 0;
    private int withdrawalsCount = 0;
    private final Random random = new Random();
    Transaction transaction;


    private boolean stoped = false;

    /**
     *
     * @param name
     * @param bank
     */
    public TransactionProcessor(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
    }

    /**
     *
     */
    @Override
    public void run() {
        try{
            transaction = bank.getNextTransaction();
            while (!stoped) {
                /**
                 * while not stopped loop over all transactions,
                 * make thread to sleep for 1 sec,
                 * and poll next transaction
                 */
                if (transaction != null){
                    processTransaction(transaction);
                    Thread.sleep(random.nextInt(1000));
                } else {
                    stoped = true;
                    break;
                }
                transaction = bank.getNextTransaction();

            }
        } catch (InterruptedException e) {
            // Log the interruption and allow the thread to exit
            System.out.println(name + " interrupted.");
            return;
        }
        finally {
            System.out.println(name + ": processed " + depositsCount + " deposits and " + withdrawalsCount + " withdraws");
        }
    }

    /**
     *
     * @param transaction
     * @throws InterruptedException
     * this function pulls account from transaction details
     * gets the amount transacted.
     * if BLOCK is used to determine if transaction is a "withdrawal / deposit"
     * incrementing either, and changes balance in the account data using defined methods.
     */
    private void processTransaction(Transaction transaction) throws InterruptedException {
        try {
            Account account = bank.getAccount(transaction.getAccountNumber());

            // Ensure amount is rounded to two decimal places
            double roundedAmount = Math.round(transaction.getAmount() * 100.0) / 100.0;
            Money amount = Money.of(CurrencyUnit.EUR, roundedAmount);

            if (amount.isPositive()) {
                account.makeDeposit(amount);
                System.out.println(name + " is processing a deposit of " + amount + " to account " + account.getAccountNumber());
                depositsCount++;
            } else {
                account.makeWithdrawal(amount.negated());
                System.out.println(name + " is processing a withdrawal of " + amount.negated() + " from account " + account.getAccountNumber());
                withdrawalsCount++;
            }
        } catch (InsufficientFundsException e) {
            System.err.println("Transaction failed: " + e.getMessage());
        }
}



    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public int getDepositsCount() {
        return depositsCount;
    }

    public void setDepositsCount(int depositsCount) {
        this.depositsCount = depositsCount;
    }

    public int getWithdrawalsCount() {
        return withdrawalsCount;
    }

    public void setWithdrawalsCount(int withdrawalsCount) {
        this.withdrawalsCount = withdrawalsCount;
    }

    public Random getRandom() {
        return random;
    }
}

