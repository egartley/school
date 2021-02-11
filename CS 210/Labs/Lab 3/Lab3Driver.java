package lab3;

import java.io.FileNotFoundException;

public class Lab3Driver {
	
	public static void main(String[] args) throws FileNotFoundException {
    	ListingFinder lf = new ListingFinder("hotels-short.csv", "listings-short.csv");
        System.out.println("All listings:");
        lf.printAllListings();
        Listing testListing = lf.findCloset(32.83724, -117.2083);
        System.out.println();
        System.out.println("The closest lodging for San Diego: " + testListing);
        testListing = lf.findCloset(32.79235, -117.16978);
        System.out.println("The closest lodging for Linda Vista Skate Park: " + testListing);
        testListing = lf.findCloset(32.813010, -117.268560);
        System.out.println("The closest lodging for La Jolla Hermosa Park: " + testListing);
    }

}
