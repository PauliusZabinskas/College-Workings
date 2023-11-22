package org.example;

import java.util.Collection;
import java.util.Random;

/**
 * Paulius Zabinskas - 20120267
 */
public class RandomTransactionGenerator extends Thread{

    private final Bank bank;
    private final Random random = new Random();
    private final float transactionUpTo = 10000.0f;

    public RandomTransactionGenerator(Bank bank){
        this.bank = bank;
    }

    /**
     * while the thread is not interrupted run
     * randomTransactions with a sleep until
     */
    public void run(){
        while (!Thread.currentThread().isInterrupted()) {
            try {
                randomTransactions();
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); // Preserve interruption status
                break;
            }
        }

        try {
            insertEndOfStreamSignal();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * used to create a transaction between -10000 and 10000.
     * then and transaction to the account
     * @throws InterruptedException
     */
    public void randomTransactions() throws InterruptedException {
        float amount = random.nextFloat() * transactionUpTo;
        if (random.nextBoolean()) {
            amount *= -1;
        }

        int accountNumber = getRandomAccountNumber();
        Transaction transaction = new Transaction(accountNumber, amount);
        bank.addTransaction(transaction);
    }

    /**
     * Utility
     * @return random account number
     * from bank account collection
     */
    private int getRandomAccountNumber() {
        Collection<Integer> accountIds = bank.getAccountIDs();
        int index = random.nextInt(accountIds.size());
        return (Integer) accountIds.toArray()[index];
    }

    /**
     * Poison pill
     * @throws InterruptedException
     * used to terminate thread
     */
    private void insertEndOfStreamSignal() throws InterruptedException {
        Transaction endOfStream = new Transaction(-1, 0);
        bank.addTransaction(endOfStream);
    }
}
