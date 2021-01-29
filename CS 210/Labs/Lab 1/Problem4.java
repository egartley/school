import java.util.Scanner;

public class Problem4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Enter a value: ");
            int num = scanner.nextInt();
            System.out.println( num + " is an" + (isEven(num) ? " even" : " odd") + " number");
            System.out.print("Done? (y/n) ");
        } while(scanner.next().charAt(0) == 'n');
        scanner.close();
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

}
