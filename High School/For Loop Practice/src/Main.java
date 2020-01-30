public class Main {

	public static void main(String[] args) {
		for (int i = 2; i < 21; i += 2)
			System.out.print(i + " ");
		System.out.println("\n");
		
		for (int i = 24; i >= 4; i -= 4)
			System.out.print(i + " ");
		System.out.println("\n");
		
		int sum = 0;
		for (int i = 1; i <= 100; i++)
			sum += i;
		System.out.println(sum + "\n");
		
		sum = 0;
		for (int i = 1; i <= 1004; i++)
			sum += i;
		System.out.println(sum / (1004.0) + "\n");
		
		for (int i = 0; i < 5; i++)
			System.out.print((int) (Math.random() * 100 + 1) + " ");
		System.out.println("\n");
		
		for (int i = 0; i < 10; i++) {
			System.out.print((int) (Math.random() * 24 + 4));
			if (i + 1 < 10)
				System.out.print(",");
		}
		System.out.println("\n");
		
		sum = -51;
		for (int i = 0; i < 20; i++) {
			int r = (int) (Math.random() * 101 - 50);
			sum = Math.max(sum, r);
			System.out.print(r + " ");
		}
		System.out.println("\nThe largest value is " + sum + "\n");
		
		for (int i = 1; i <= 400; i++) {
			if ((int) Math.sqrt(i) * (int) Math.sqrt(i) == i)
				System.out.print(i + " ");
		}
		System.out.println("\n");
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 5; j++)
				System.out.print("*");
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j <= i; j++)
				System.out.print("*");
			System.out.println();
		}
		System.out.println();
		
		for (int i = 1; i < 8; i++) {
			for (int j = 0; j < i; j++)
				System.out.print(i);
			System.out.println();
		}
		System.out.println();
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 10; j++)
				for (int k = 0; k < 3; k++)
					System.out.print(j);
			System.out.println();
		}
	}

}