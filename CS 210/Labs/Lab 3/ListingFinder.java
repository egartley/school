package lab3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListingFinder {

	private Listing[] listings = new Listing[100];
	private int numListings = 0;

	public ListingFinder(String hotelsFileName, String listingsFileName) throws FileNotFoundException {
		Scanner hotelsFile = new Scanner(new File(hotelsFileName));
		hotelsFile.nextLine();
		while (hotelsFile.hasNext()) {
			String line = hotelsFile.nextLine();
			String[] values = line.split(",");
			listings[numListings++] = new HotelListing(values[0], values[1], values[2], values[6], values[7],
					Double.parseDouble(values[8]), Double.parseDouble(values[4]), Double.parseDouble(values[5]),
					Double.parseDouble(values[9]), Integer.parseInt(values[10]), values[11].equals("y"),
					values[12].equals("y"), values[13].equals("y"));
		}
		hotelsFile.close();

		Scanner airbnbFile = new Scanner(new File(listingsFileName));
		airbnbFile.nextLine();
		while (airbnbFile.hasNext()) {
			String line = airbnbFile.nextLine();
			String[] values = line.split(",");
			Host host = new Host(values[4], values[5], values[6], values[7], values[8], values[9],
					Double.parseDouble(values[10]), Double.parseDouble(values[11]), values[12].equals("t"));
			listings[numListings++] = new AirbnbListing(host, values[0], values[1], values[2], values[21], values[26],
					Double.parseDouble(values[27]), Double.parseDouble(values[18]), Double.parseDouble(values[19]),
					values[20], Integer.parseInt(values[22]), Integer.parseInt(values[23]),
					Integer.parseInt(values[24]), Integer.parseInt(values[28]), Integer.parseInt(values[29]));
		}
		airbnbFile.close();
	}

	public void printAllListings() {
		for (int i = 0; i < numListings; i++) {
			System.out.println(listings[i]);
		}
	}

	public Listing findCloset(double latitude, double longitude) {
		double minDistance = Double.MAX_VALUE;
		Listing minListing = null;
		for (int i = 0; i < numListings; i++) {
			Listing listing = listings[i];
			double lat1 = Math.toRadians(latitude);
			double long1 = Math.toRadians(longitude);
			double lat2 = Math.toRadians(listing.getLatitude());
			double long2 = Math.toRadians(listing.getLongitude());
			double x = Math.cos(lat2) * Math.cos(long2) - Math.cos(lat1) * Math.cos(long1);
			double y = Math.cos(lat2) * Math.sin(long2) - Math.cos(lat1) * Math.sin(long1);
			double z = Math.sin(lat2) - Math.sin(lat1);
			double distance = 3958.761 * Math.sqrt((x * x) + (y * y) + (z * z));
			if (distance < minDistance) {
				minDistance = distance;
				minListing = listing;
			}
		}
		return minListing;
	}

}
