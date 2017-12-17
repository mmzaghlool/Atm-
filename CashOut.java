package Mine;

public class CashOut {
	private int counter20 = 0;
	private int counter50 = 0;
	private int counter100 = 0;
	private int counter200 = 0;
	private int maxCounter20;
	private int maxCounter50;
	private int maxCounter100;
	private int maxCounter200;

	public CashOut(int maxCounter200, int maxCounter100, int maxCounter50, int maxCounter20) {
		this.maxCounter200 = maxCounter200;
		this.maxCounter100 = maxCounter100;
		this.maxCounter50 = maxCounter50;
		this.maxCounter20 = maxCounter20;

	}

	public CashOut() {
		this(32768, 32768, 32768, 32768);
	}

	public boolean getCashOut(double cash) {
		counter20 = 0;
		counter50 = 0;
		counter100 = 0;
		counter200 = 0;
		if (cash > 8000) {
			System.out.println("The maximum cashout is 8000");
			return false;
		} else if (cash % 10 != 0) {
			System.out.println("The ammount requested cashout is't valid");
			return false;
		} else {
			if (cash % 50 == 10) {
				counter20 += 1;
				cash -= 20;

			}
			if ((int) (cash / 200) < maxCounter200) {
				if (maxCounter200 > 1 || (int) (cash / 200) > 1) {
					counter200 += (int) ((cash / 200) - 1);
					maxCounter200 -= counter200;
					cash -= 200 * counter200;
				} else if (maxCounter200 > 0) {
					counter200 += 1;
					cash -= 200;
					maxCounter200 -= counter200;
				}
			} else if (cash != 0){
				counter200 += maxCounter200;
				cash -= 200 * counter200;
				maxCounter200 -= counter200;
			}
			if ((int) (cash / 100) < maxCounter100 && (int) (cash / 100) > 1) {
				if (maxCounter100 > 1) {
					counter100 += (int) ((cash / 100) - 1);
					cash -= 100 * counter100;
					maxCounter100 -= counter100;
				} else if (maxCounter100 > 0) {
					counter100 += 1;
					cash -= 100;
					maxCounter100 -= counter100;
				}
			} else if (cash != 0){
				counter100 += maxCounter100;
				cash -= 100 * counter100;
				maxCounter100 -= counter100;
			}
			if ((int) (cash / 50) < maxCounter50 && (int) (cash / 50) > 1) {
				if (maxCounter50 > 1) {
					counter50 += (int) ((cash / 50));
					cash -= 50 * counter50;
					maxCounter50 -= counter50;
				} else if (maxCounter50 > 0) {
					counter50 += 1;
					cash -= 50;
					maxCounter50 -= counter50;
				}
			} else if (cash != 0) {
				counter50 += maxCounter50;
				cash -= 50 * counter50;
				maxCounter50 -= counter50;
			}
			if ((int) (cash / 20) <= maxCounter20 && (int) (cash / 20) > 1 ) {
				counter20 += (int) (cash / 20);
				maxCounter20 -= counter20;

			}
			if (counter20 + counter50 + counter100 + counter200 <= 40 ) {
				System.out.println(counter200 + " of '200' " + counter100 + " of '100' " + counter50 + " of '50' "
						+ counter20 + " of '20'");
				return true;
			}
			//if (counter20 + counter50 + counter100 + counter200 > 40 || (int) (cash / 20) > maxCounter20) {
				System.out.println("Some cash out of stock.");
				maxCounter50 += counter50;
				maxCounter20 += counter20;
				maxCounter100 += counter100;
				maxCounter200 += counter200;
				return false;
			//}

		}
	}
}