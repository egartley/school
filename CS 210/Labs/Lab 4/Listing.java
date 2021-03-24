public abstract class Listing implements Comparable<Listing>, Rentable {

	/**
	 * Name is the name of the listing and description is a general description
	 */
	protected String id, name, description, roomType, amenities;
	protected double costPerNight = 0.0, latitude, longitude;

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param roomType
	 * @param amenities
	 * @param costPerNight
	 */
	public Listing(String id, String name, String description, String roomType, String amenities, double costPerNight,
			double latitude, double longitude) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.roomType = roomType;
		this.amenities = amenities;
		this.costPerNight = costPerNight;
		this.latitude = latitude;
		this.longitude = longitude;
	}

	/**
	 * @return return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the room type
	 */
	public String getRoomType() {
		return roomType;
	}

	/**
	 * @return the amenities
	 */
	public String getAmenities() {
		return amenities;
	}

	/**
	 * @return the cost per night
	 */
	public double getCostPerNight() {
		return costPerNight;
	}

	/**
	 * @return the latitude of the listing
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @return the longitude of the listing
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param id of the listing
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @param name of the listing
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param description of the listing (could be long)
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param roomType which could be "queen" or "studio"
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	/**
	 * @param amenities including coffee maker, kitchen, etc.
	 */
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}

	/**
	 * 
	 * @param costPerNight in USD
	 */
	public void setCostPerNight(double costPerNight) {
		this.costPerNight = costPerNight;
	}

	/**
	 * @param latitude of the location of the listing
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @param longitude of the location of the listing
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	@Override
	public String toString() {
		return "ID: " + id + " Name: " + name;
	}

	@Override
	public int compareTo(Listing listing) {
		return this.id.compareTo(listing.id);
	}

	@Override
	public double getRentalCharge(int time) {
		return costPerNight * time;

	}

}
