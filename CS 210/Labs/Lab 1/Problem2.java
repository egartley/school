import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Event name: ");
        String name = scanner.nextLine();
        System.out.print("Event length: ");
        int length = scanner.nextInt();
        int originalLength = length;
        int minutes = length % 60;
        length /= 60;
        int hours = length % 24;
        int days = length / 24;
        System.out.println(name + " lasting " + originalLength + " minutes is equal to " + days +
                " days and " + hours + " hours " + minutes + " minutes");
        scanner.close();
    }

}
