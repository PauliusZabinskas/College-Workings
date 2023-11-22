package org.example;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Paulius Zabinskas - 20120267
 */
public class Bank {
    private Map<Integer, Account> collectionAccounts;
    private LinkedBlockingQueue blockingQueue;

    /**
     * constructor to initiate data types
     */
    public Bank() {
        this.collectionAccounts = new HashMap<>();
        this.blockingQueue = new LinkedBlockingQueue<>();
    }


    /**
     *
     * @param newAccount is used to add new accout to collectionAccounts.
     */
    public void addAccount(Account newAccount){

        if(newAccount == null)
            throw new RuntimeException("add Account value is null");
        try{
            collectionAccounts.put(newAccount.getAccountNumber(), newAccount);
        }catch (Exception e){
            System.out.println(e);
        }

    }

    /**
     * Method is usd to return a single account using and id
     * @param id
     * @return
     */
    public Account getAccount(int id){

        Account account = collectionAccounts.get(id);
        if (account == null) {
            throw new NoSuchElementException("Account with ID " + id + " does not exist.");
        }
        return account;
    }

    /**
     * add a transaction to Queue only if account exists
     * @param transaction
     * @throws InterruptedException
     */
   public void addTransaction(Transaction transaction) throws InterruptedException {
        Transaction t = transaction;
        if(collectionAccounts.containsKey(t.getAccountNumber())){
            Transaction transactionSub = new Transaction(t.getAccountNumber(), t.getAmount());
            blockingQueue.put(transactionSub);
        }else
            System.out.println("Account dose not exist");

   }

    /**
     * Get next trasaction in Queue using poll method providing time out.
     * @return
     * @throws InterruptedException
     */
   public Transaction getNextTransaction() throws InterruptedException {
       if(blockingQueue.isEmpty()){
           blockingQueue.stream().close();
           return null;
       }
        return (Transaction) blockingQueue.poll(5, TimeUnit.SECONDS);

   }

    /**
     * print all accounts
     */
   public void printAllAccounts(){
        collectionAccounts.forEach((a, b) -> {
            System.out.println("Account details number "+a+" : balance "+b.getBalance());
        });
   }

    /**
     *
     * @return collection of bank account IDs
     */
   public Collection<Integer> getAccountIDs(){
        Collection<Integer> accNum = new ArrayList<>();

        collectionAccounts.forEach((a, b) -> accNum.add(a));

        return accNum;

   }





}
