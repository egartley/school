package lab3;

public class AirbnbListing extends Listing {
	Host host; 
	String propertyType;
	int accommodates, baths, bedrooms, minNights, maxNights; 

	public AirbnbListing(Host host, String id, String name, String description, String roomType, String amenities,
			double costPerNight, double latitude, double longitude, String propertyType, int accommodates, 
			int baths, int bedrooms, int minNights,
			int maxNights) {
		super(id, name, description, roomType, amenities, costPerNight, latitude, longitude);
		this.host = host;
		this.propertyType = propertyType;
		this.accommodates = accommodates;
		this.baths = baths;
		this.bedrooms = bedrooms;
		this.minNights = minNights;
		this.maxNights = maxNights; 
	}
	
	public Host getHost() { return host; }
	public String getPropertyType() { return propertyType; }
	public int getAccommodates() { return accommodates; }
	public int getBaths() { return baths; }
	public int getBedrooms() { return bedrooms; }
	public int getMinNights() { return minNights; }
	public int getMaxNights() { return maxNights; }
	
	public void setHost(Host host) { this.host = host; }
	public void setPropertyType(String propertyType) { this.propertyType = propertyType; }
	public void setAccommodates(int accommodates) { this.accommodates = accommodates; }
	public void setBaths(int baths) { this.baths = baths; }
	public void setBedrooms(int bedrooms) { this.bedrooms = bedrooms; }
	public void setMinNights(int minNights) { this.minNights = minNights; }
	public void setMaxNights(int maxNights) { this.maxNights = maxNights; }
	
	public String toString() { return "Airbnb: " + super.toString() + " Host " + host; }
	
}
