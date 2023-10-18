import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class AccountMain {
	Scanner input;
	Map<Integer, Account> accounts;

	public AccountMain() {
		input = new Scanner(System.in);
		accounts = new HashMap<Integer,Account>();
	}

	public static void main(String[] args) {
		AccountMain bankApp = new AccountMain();
		bankApp.start();

	}

	public void start() {
		showMainMenu();

	}

	private void showMainMenu() {
		System.out.println("Please choose 1 to create an account or 2 to make a withdrawal.");
		int choice = input.nextInt();
		switch(choice) {
		case 1: 
			createNewAccount();
			showMainMenu();
			break;
		case 2: 
			makeWithdrawal();
			showMainMenu();
			break;
		default:
			System.out.println("Invalid choice.");
			showMainMenu();
		}

	}

	private void makeWithdrawal() {
		System.out.println("Please enter an account number: ");
		int accountNumber = input.nextInt();
		Account acc = accounts.get(accountNumber);
		System.out.println("Please enter an amount to withdraw:");
		double amount = input.nextDouble();
		//MAKE A WITHDRAWAL 
		try {
			acc.makeWithdrawal(amount);
		} catch (InsufficientFundsException e) {
			System.out.println("Not enough funds.");
			showMainMenu();
		}
		
		
	}

	private void createNewAccount() {
		System.out.println("Please enter an account number: ");
		int accountNumber = input.nextInt();
		System.out.println("Please enter a starting balance: ");
		double balance = input.nextDouble();
		//HANDLE NEGATIVE BALANCE
		if(balance >= 0) {
			try {
				accounts.put(accountNumber, new Account(accountNumber, balance));
			} catch (NegativeBalanceException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Balance can't be less than 0.");
			showMainMenu();
		}
	}

}
