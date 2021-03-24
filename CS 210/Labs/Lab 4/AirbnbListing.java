public class AirbnbListing extends Listing {
	// Each Airbnb property has a host
	protected Host host; 
	// Property types include "single room shared bath", "entire house", etc. 
	protected String propertyType;
	// Number of people who could sleep in the lodging
	protected int accommodates, baths, bedrooms, minNights, maxNights; 

	/**
	 * @param host
	 * @param id
	 * @param name
	 * @param description
	 * @param roomType
	 * @param amenities
	 * @param costPerNight
	 * @param propertyType
	 * @param accommodates
	 * @param baths
	 * @param bedrooms
	 * @param minNights
	 * @param maxNights
	 */
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

	/**
	 * @return  a reference to the host of the listing
	 */
	public Host getHost() { return host; }
	/**
	 * @return  type of property
	 */
	public String getPropertyType() { return propertyType; }
	/**
	 * @return number of people who can stay at the property
	 */
	public int getAccommodates() { return accommodates; }
	/**
	 * @return  number of bathrooms
	 */
	public int getBaths() { return baths; }
	/**
	 * @return number of bedrooms
	 */
	public int getBedrooms() { return bedrooms; }
	/**
	 * @return minimum number of nights in a stay
	 */
	public int getMinNights() { return minNights; }
	/**
	 * @return maximum number of nights allowed in a stay
	 */
	public int getMaxNights() { return maxNights; }
	
	/**
	 * @param host   reference to the property owner
	 */
	public void setHost(Host host) { this.host = host; }
	/**
	 * @param propertyType  Type of property
	 */
	public void setPropertyType(String propertyType) { this.propertyType = propertyType; }
	/** 
	 * @param accommodates number of people who can stay at the property
	 */
	public void setAccommodates(int accommodates) { this.accommodates = accommodates; }
	/**
	 * @param baths   number of bathrooms, assumes full baths
	 */
	public void setBaths(int baths) { this.baths = baths; }
	/**
	 * @param bedrooms  number of bedrooms, studio counts as one
	 */
	public void setBedrooms(int bedrooms) { this.bedrooms = bedrooms; }
	/** 
	 * @param minNights  minmium nights in a stay
	 */
	public void setMinNights(int minNights) { this.minNights = minNights; }
	/** 
	 * @param maxNights  maximum number of nights allowed in a stay
	 */
	public void setMaxNights(int maxNights) { this.maxNights = maxNights; }
	
	@Override
	public double getRentalCharge(int time) {
		return super.getRentalCharge(time) + 150;
		
	}
	
	@Override
	public String toString() {
		return "Airbnb: " + super.toString();
		
	}
	
}
