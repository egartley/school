package lab3;

public class HotelListing extends Listing {
	
	double parkingCharge = 0;
	int conferenceRooms = 0; 
	boolean breakfast, pool, allowPets;

	public HotelListing(String id, String name, String description, String roomType, String amenities,
			double costPerNight, double latitude, double longitude,
			double parkingCharge, int conferenceRooms, boolean breakfast, boolean pool,
			boolean allowPets) {
		super(id, name, description, roomType, amenities, costPerNight, latitude, longitude);
		this.parkingCharge = parkingCharge;
		this.conferenceRooms = conferenceRooms;
		this.breakfast = breakfast;
		this.pool = pool; 
		this.allowPets = allowPets;
	}
	
	public double getParkingCharge() { return parkingCharge; }
	public int getConferenceRooms() { return conferenceRooms; }
	public boolean isBreakfast() { return breakfast; }
	public boolean isPool() { return pool; }
	public boolean isAllowPets() { return allowPets; }
	
	public void setParkingCharge(double parkingCharge) { this.parkingCharge = parkingCharge; }
	public void setConferenceRooms(int conferenceRooms) { this.conferenceRooms = conferenceRooms; }
	public void setBreakfast(boolean breakfast) { this.breakfast = breakfast; }
	public void setPool(boolean pool) { this.pool = pool; }
	public void setAllowPets(boolean allowpets) { this.allowPets = allowPets; } 
	
	public String toString() { return " Hotel: " + super.toString(); }

}
