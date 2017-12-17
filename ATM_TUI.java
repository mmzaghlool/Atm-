package Mine;

import java.util.Scanner;

public class ATM_TUI {

	public static void main(String[] args) {
		boolean close = false;
		boolean acc_close = false;
		boolean acc_change = false;
		boolean change = false;
		Scanner input = new Scanner(System.in);

		while (close == false) {
			System.out.println("*************************************************");
			System.out.println("        A       TTTTTTTTT        M     M");
			System.out.println("       A A          T           M M   M M");
			System.out.println("      A   A         T          M   M M   M ");
			System.out.println("     AAAAAAA        T         M     M     M");
			System.out.println("    A       A       T        M             M");
			System.out.println("   A         A      T       M               M");

			System.out.println("**************************************************");

			//while (acc_close == false) {
				while (acc_change == false) {
					change = false;
					System.out.println("Enter Account number: ");
					String accNum = input.next();
					System.out.println("enter password: ");
					String pwd = input.next();
					// input data
					CheckID ID = new CheckID(accNum, pwd);
					double accBalance = ID.checkID();
					CashOut cash = new CashOut( 10, 10 ,10 ,15);
					if (accBalance == -1 ) {
						change = true;
						acc_change = true;
						acc_close = true;
						close = true;
						break;
					}
					

					while (change == false) {

						System.out.println("**************************************************");
						System.out.println(" 01) withdrow");
						System.out.println(" 02) deposit	");
						System.out.println(" 03) cheak Balance	");
						System.out.println(" 04) chang account	");
						System.out.println(" 05) close program");
						System.out.println("**************************************************");

						int choose = input.nextInt();

						switch (choose) {
						case 1: {
							
							System.out.println("Enter the amount :");
							double withdrow = input.nextDouble();
							if (withdrow < accBalance && cash.getCashOut(withdrow))
								accBalance -= withdrow ;
								
							
							break;
						}
						case 2: {
							System.out.println("Enter the amount :");
							Deposit deposit = new Deposit(accBalance, input.nextDouble());
							accBalance = deposit.deposite();
							break;
						}
						case 3: {
							System.out.println("Your balance: " +accBalance);
							break;
						}
						case 4: {
							change = true;
							break;
						}
						case 5: {
							change = true;
							acc_change = true;
							acc_close = true;
							close = true;
							break;
						}
						default:
							System.out.println(" invalid input ");
							
						}
					}
				}
			//}
		}
	}

}
