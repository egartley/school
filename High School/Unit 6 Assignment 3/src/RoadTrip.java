import java.util.ArrayList;

public class RoadTrip {

	private ArrayList<GeoLocation> locs;

	// Default constructor for RoadTrip
	public RoadTrip() {
		locs = new ArrayList<GeoLocation>();
	}

	// Create a GeoLocation and add it to the road trip
	public void addStop(String name, double latitude, double longitude) {
		locs.add(new GeoLocation(name, latitude, longitude));
	}

	// Get the total number of stops in the trip
	public int getNumberOfStops() {
		return locs.size();
	}

	// Get the total miles of the trip
	public double getTripLength() {
		double mi = 0;
		for (short i = 0; i < locs.size(); i++) {
			if (i + 1 < locs.size())
				mi += locs.get(i).distanceFrom(locs.get(i + 1));
		}
		return mi;
	}

	// Return a formatted toString of the trip
	public String toString() {
		String r = "";
		for (short i = 1; i < locs.size() + 1; i++)
			r += i + ". " + locs.get(i - 1) + "\n";
		return r;
	}
}
