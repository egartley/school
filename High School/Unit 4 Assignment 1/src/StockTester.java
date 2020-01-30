import java.util.*;

public class StockTester {

	private static byte si = 0;
	private static Stock s1, s2;

	public static void main(String[] args) {
		s1 = new Stock("");
		s2 = new Stock("");
		Scanner cmd = new Scanner(System.in);
		double p1 = makePurchases(s1, cmd);
		double p2 = makePurchases(s2, cmd);

		if (p1 == p2) {
			System.out.println("Both stocks were equally as profitable!");
		} else if (p1 > p2) {
			System.out.println(s1.getSymbol() + " was more profitable than "
					+ s2.getSymbol());
		} else {
			System.out.println(s2.getSymbol() + " was more profitable than "
					+ s1.getSymbol());
		}
	}

	public static double makePurchases(Stock currentStock, Scanner console) {
		si++;
		switch (si) {
		case 1:
			System.out.print("First stock symbol: ");
			break;
		case 2:
			System.out.print("Second stock symbol: ");
			break;
		}
		currentStock = new Stock(console.next());
		if (si == 1) {
			s1 = new Stock(currentStock.getSymbol());
		} else {
			s2 = new Stock(currentStock.getSymbol());
		}
		System.out.print("\nHow many purchases did you make? ");
		int purchases = console.nextInt();
		for (int p = 1; p <= purchases; p++) {
			System.out.print("Purchase " + p
					+ ": How many shares, at what price per share? ");
			String in = console.next();
			String t = console.next();
			currentStock.purchase(Integer.valueOf(in), Double.valueOf(t));
		}
		System.out.print("What is today's price per share? ");
		double p = currentStock.getProfit(console.nextDouble());
		System.out.println("Net profit/loss: $" + String.format("%.2f", p)
				+ "\n");
		return p;
	}
}