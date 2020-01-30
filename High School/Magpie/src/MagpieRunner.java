import java.util.Scanner;
public class MagpieRunner
{
	
    public static void main(String[] args)
    {
        Magpie mag = new Magpie();
        Scanner cmd = new Scanner(System.in);
        String input = "";
        System.out.println(mag.getGreeting());
        while (!input.equalsIgnoreCase("bye")) {
        	input = cmd.nextLine();
        	if (input.equalsIgnoreCase("bye")) {
        		System.out.println("Goodbye!");
        		break;
        	}
        	System.out.println(mag.getResponse(input));
        }
    }

}