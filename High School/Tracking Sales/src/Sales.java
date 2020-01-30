import java.util.Arrays;
import java.util.Scanner;

public class Sales {

	public static void main(String[] args) {
		Scanner cmd = new Scanner(System.in);
		System.out.print("How many sales? ");
		int[] amounts = new int[cmd.nextInt()];
		for (int i = 0; i < amounts.length; i++) {
			System.out.print("Enter the sales for salesperson " + (i + 1)
					+ ": ");
			amounts[i] = cmd.nextInt();
		}
		System.out.println("\nSalesperson    Sales\n---------------------");
		for (int i = 0; i < amounts.length; i++) {
			System.out.println("     " + (i + 1) + "          " + amounts[i]);
		}
		System.out.println("\nTotal sales: $" + sum(amounts)
				+ "\n\nAverage sales: " + avgSale(amounts)
				+ "\n\nRange of sales: $" + rangeSale(amounts));
		exceededSales(amounts, 450);
		cmd.close();
	}

	public static int sum(int[] n) {
		int sum = n[0];
		for (int i = 1; i < n.length; i++)
			sum += n[i];
		return sum;
	}

	public static int indexOf(int[] n, int k) {
		for (int i = 0; i < n.length; i++)
			if (n[i] == k)
				return i;
		return -1;
	}

	public static String avgSale(int[] n) {
		return String.format("$%.2f", (sum(n) * 1.0) / n.length);
	}

	public static void maxSale(int[] n) {
		int[] m = Arrays.copyOf(n, n.length);
		Arrays.sort(m);
		System.out.println("Salesperson " + (indexOf(n, m[m.length - 1]) + 1)
				+ " had the highest sale with $" + m[m.length - 1]);
	}

	public static int rangeSale(int[] n) {
		int[] m = Arrays.copyOf(n, n.length);
		Arrays.sort(m);
		return m[m.length - 1] - m[0];
	}

	public static void exceededSales(int[] n, int max) {
		int exceeded = 0;
		for (int i = 0; i < n.length; i++) {
			if (n[i] > max) {
				System.out.println("Salesperson " + (i + 1)
						+ " exceeded the amount of sales, their sales were "
						+ n[i]);
				exceeded++;
			}
		}
		switch (exceeded) {
		case 0:
			System.out
					.println("There were no sales associates who exceeded the amount");
			break;

		case 1:
			System.out
					.println("There was one sales associate who exceeded the amount");
			break;

		default:
			System.out.println("There were " + exceeded
					+ " sales associates who exceeded the amount");
			break;
		}
	}

}