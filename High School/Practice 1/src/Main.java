import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println(changeReturn(new Scanner(System.in)));
		// 3.47
	}
	
	public static String changeReturn(Scanner console) {
		System.out.print("Enter a dollar amount: ");
		double in = console.nextDouble();
		int interm;
		in *= 100;
		interm = (int)((in - (in % 100)) / 100);
		String r = interm + " dollar bill";
		if (interm >= 2 || interm == 0) {
			r += "s";
		}
		in -= in - (in % 100);
		
		interm = (int)((in - (in % 25)) / 25);
		r += ", " + interm + " quarter";
		if (interm >= 2 || interm == 0) {
			r += "s";
		}
		in -= in - (in % 25);
		
		interm = (int)((in - (in % 10)) / 10);
		r += ", " + interm + " dime";
		if (interm >= 2 || interm == 0) {
			r += "s";
		}
		in -= in - (in % 10);
		
		interm = (int)((in - (in % 5)) / 5);
		r += ", " + interm + " nickel";
		if (interm >= 2 || interm == 0) {
			r += "s";
		}
		in -= in - (in % 5);
		
		r += ", " + (int)in + " penn";
		if (in >= 2 || interm == 0) {
			r += "ies";
		} else {
			r += "y";
		}
		
		return r;
	}
	
	/*public static String changeReturn2(Scanner console) {
		System.out.print("Enter a dollar amount: ");
		double d = console.nextDouble();
		int interm;
		String in = String.valueOf(d);
	}*/
	
}