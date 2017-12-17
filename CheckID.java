package Mine;

public class CheckID {

	private String result = "Wrong Account or password";
	private String a = "123456 123456 100000.0";
	private String b = "11111 11111 5000.0";
	private String c = "22222 22222 1000.0";
	private String accNum; 
	private String pwd;
	public CheckID(String accNum , String pwd ) {
		this.accNum = accNum;
		this.pwd = pwd;
	}
	
	public double checkID() {
		if (accNum.equals(a.substring(0, a.indexOf(" ")))
				&& pwd.equals(a.substring(a.indexOf(" ") + 1, a.lastIndexOf(" "))))
			return Double.parseDouble(result = a.substring(a.lastIndexOf(" ") + 1));

		if (accNum.equals(b.substring(0, b.indexOf(" ")))
				&& pwd.equals(b.substring(b.indexOf(" ") + 1, b.lastIndexOf(" "))))
			return Double.parseDouble(result = b.substring(b.lastIndexOf(" ") + 1));

		if (accNum.equals(c.substring(0, c.indexOf(" ")))
				&& pwd.equals(c.substring(c.indexOf(" ") + 1, c.lastIndexOf(" "))))
			return Double.parseDouble(result = c.substring(c.lastIndexOf(" ") + 1));
		System.out.println(result);
		return -1;
	}
}
