package lab2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lab2Driver {

    public static void main(String[] args) throws FileNotFoundException {
        countListings();
        Host host1 = new Host();
        Host host2 = new Host();
        Airbnb airbnbList1 = new Airbnb();
        Airbnb airbnbList2 = new Airbnb();
        HotelListing hl1 = new HotelListing();
        HotelListing hl2 = new HotelListing();

        System.out.println("Airbnb name:" + airbnbList1.getName() + "is hosted by " + airbnbList1.getHost());
        System.out.println("Airbnb name:" + airbnbList2.getName() + "is hosted by " + airbnbList2.getHost());

        System.out.println("Hotel name:" + hl1.getName() + "is " + hl1.getDescription());
        System.out.println("Hotel name:" + hl2.getName() + "is " + hl2.getDescription());
    }

    public static void countListings() throws FileNotFoundException {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the name of an file for properties: ");
        String name = input.nextLine();
        System.out.print("Enter the descriptive phrase for an Airbnb property: ");
        String phrase = input.nextLine();

        Scanner listing = new Scanner(new File(name));

        int count = 0;
        while (listing.hasNext()) {
            if (phrase.equalsIgnoreCase(listing.next())) {
                count++;
            }

        }

        System.out.println(count);
        input.close();
    }

}
