public class HotelListing extends Listing {
	// Does the hotel charge for parking?
	protected double parkingCharge = 0;
	// How many conference rooms are at the hotel?
	protected int conferenceRooms = 0;
	protected boolean breakfast, pool, allowPets;

	/**
	 * @param id
	 * @param name
	 * @param description
	 * @param roomType
	 * @param amenities
	 * @param costPerNight
	 * @param latitude
	 * @param longitude
	 * @param parkingCharge
	 * @param conferenceRooms
	 * @param breakfast
	 * @param pool
	 * @param allowPets
	 */

	public HotelListing(String id, String name, String description, String roomType, String amenities,
			double costPerNight, double latitude, double longitude, double parkingCharge, int conferenceRooms,
			boolean breakfast, boolean pool, boolean allowPets) {
		super(id, name, description, roomType, amenities, costPerNight, latitude, longitude);
		this.parkingCharge = parkingCharge;
		this.conferenceRooms = conferenceRooms;
		this.breakfast = breakfast;
		this.pool = pool;
		this.allowPets = allowPets;
	}

	/**
	 * @return the parking charge per day
	 */
	public double getParkingCharge() {
		return parkingCharge;
	}

	/**
	 * @return the number of conference rooms at the hotel
	 */
	public int getConferenceRooms() {
		return conferenceRooms;
	}

	/**
	 * @return whether free breakfast is offered or not
	 */
	public boolean isBreakfast() {
		return breakfast;
	}

	/**
	 * @return whether the hotel has a pool or not
	 */
	public boolean isPool() {
		return pool;
	}

	/**
	 * @return whether the hotel allows pets or not
	 */
	public boolean isAllowPets() {
		return allowPets;
	}

	/**
	 * @param parkingCharge charge to park one vehicle per day
	 */
	public void setParkingCharge(double parkingCharge) {
		this.parkingCharge = parkingCharge;
	}

	/**
	 * @param conferenceRooms number of conference rooms in the hotel
	 */
	public void setConferenceRooms(int conferenceRooms) {
		this.conferenceRooms = conferenceRooms;
	}

	/**
	 * @param breakfast set free breakfast
	 */
	public void setBreakfast(boolean breakfast) {
		this.breakfast = breakfast;
	}

	/**
	 * @param pool set whether a pool is located at the hotel
	 */
	public void setPool(boolean pool) {
		this.pool = pool;
	}

	/**
	 * @param allowpets set whether the hotel allows pets or not
	 */
	public void setAllowPets(boolean allowPets) {
		this.allowPets = allowPets;
	}

	@Override
	public String toString() {
		return "Hotel: " + super.toString();
	}

	@Override
	public double getRentalCharge(int time) {
		return super.getRentalCharge(time) * 1.21;

	}

}
