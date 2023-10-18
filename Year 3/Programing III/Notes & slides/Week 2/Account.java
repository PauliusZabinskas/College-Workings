
public class Account {
	
	private double balance;
	private int accountNumber;
	
	/**
	 * 
	 * @param accountNumber
	 * @param balance
	 */
	public Account(int accountNumber, double balance) throws NegativeBalanceException {
		try {
		if(balance < 0)
			throw new NegativeBalanceException("Negative balance not allowed");
		} catch(NegativeBalanceException e) {
			System.out.println("Catch block of constructor");
			throw e;
		} finally {
			System.out.println("Finally block of constructor");
		}
		System.out.println("Body of constructor after catch");
		this.balance = balance;
		
		this.accountNumber = accountNumber;
		
	}

	public void makeDeposit(double depositAmount) {
		if(depositAmount >= 0)
			balance += depositAmount;
	}

	public double getBalance() {
		return balance;
	}

	public static void main(String [] args) {
		try {
			Account a = new Account(123, -50);
		} catch (NegativeBalanceException e) {
			System.out.println("Catch block of main");
			e.printStackTrace();
		} finally {
			System.out.println("Finally block of main");
		}
	}

	public void makeWithdrawal(double withdrawalAmount) throws InsufficientFundsException {
		if(withdrawalAmount > balance)
			throw new InsufficientFundsException();
		balance -= withdrawalAmount;
		
	}
	

}
