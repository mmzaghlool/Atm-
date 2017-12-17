package Mine;

public class Deposit {
	private double currentBal;
	private double depositAmt;

	public Deposit(double accBalance, double depositeAmt) {
		this.depositAmt = depositeAmt;
		this.currentBal = accBalance;
	}

	public double deposite() {
		double newBalance = depositAmt + currentBal;
		System.out.printf("Your New Balance is $%.2f\n", newBalance);

		return newBalance;
	}

}
