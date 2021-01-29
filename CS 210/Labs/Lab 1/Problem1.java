import java.util.Scanner;

public class Problem1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        System.out.print("Hourly pay: ");
        double pay = scanner.nextDouble();
        System.out.print("Hours worked: ");
        double hours = scanner.nextDouble();
        System.out.println("My name is " + name + ", my age is " + age + ", any my pay is $" + pay + " per hour");
        scanner.close();
    }

}
