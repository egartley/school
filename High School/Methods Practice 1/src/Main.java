import java.awt.Color;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
	}
	
	public static void powersOfTwo() {
		for (int i = 0; i < 10; i++)
			System.out.print(Math.pow(2, i + 1) + " ");
	}
	
	public static void alarm(int times) {
		for (int i = 0; i < times; i++)
			System.out.println("Alarm!");		
	}
	
	public static int sum100() {
		int sum = 1;
		for (int i = 2; i <= 100; i++)
			sum += i;
		return sum;
	}
	
	public static int sumRange(int x, int y) {
		int sum = 1;
		for (int i = x+1; i <= y; i++)
			sum += i;
		return sum;
	}
	
	public static int maxOfFour(int a, int b, int c, int d) {
		return Math.max(Math.max(c, d), Math.max(a, b));
	}
	
	public static boolean larger(double x, double y) {
		return x > y;
	}
	
	public static int countA(String s) {
		int count = 0;
		String temp = s;
		while (temp.indexOf("a") != -1) {
			count++;
			temp = temp.substring(temp.indexOf("a"));
		}
		return count;
	}
	
	public static boolean evenlyDivisible(int x, int y) {
		return x % y == 0 || y % x == 0;
	}
	
	public static double average(int x, int y, int z) {
		return (x + y + z) / 3.0;
	}
	
	public static double average(int x, int y, int z, int a) {
		return (x + y + z + a) / 4.0;
	}
	
	public static String multiConcat(String s, int n) {
		String r = s;
		while (n >= 2) {
			r += r;
		}
		return r;
	}
	
	public static boolean isAlpha(char c) {
		return Character.isLetter(c);
	}
	
	public static int validate(int x, int y, int n) {
		if (x <= n && y >= n)
			return n;
		Scanner cmd = new Scanner(System.in);
		while (!(x <= n && y >= n)) {
			System.out.print("Please enter a valid value: ");
			n = cmd.nextInt();
		}
		return n;
	}
	
	public static boolean isIsoceles(int a, int b, int c) {
		return (a == b && b != c) || (a == c && b != c) || (c == b && b != a);
	}
	
	public static int randomInRange(int min, int max) {
		return (int) (Math.random() * max + min);
	}
	
	public static int randomInRange(int max) {
		return (int) (Math.random() * max + 1);
	}
	
	public static Color randomColor() {
		return new Color(randomInRange(256), randomInRange(256), randomInRange(256));
	}
	
}