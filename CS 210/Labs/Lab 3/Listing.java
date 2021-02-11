package lab3;

public class Listing {
	
	protected String id, name, description, roomType, amenities;
	protected double costPerNight = 0.0, latitude, longitude; 
	
	public Listing(String id, String name, String description, String roomType, String amenities, 
			double costPerNight, double latitude, double longitude) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.roomType = roomType;
		this.amenities = amenities;
		this.costPerNight = costPerNight; 
		this.latitude = latitude; 
		this.longitude = longitude; 
	}
	
	public String getId() { return id; }
	
	public String getName() { return name; }
	
	public String getDescription() { return description; }
	
	public String getRoomType() { return roomType; }
	
	public String getAmenities() { return amenities; }
	
	public double getCostPerNight() { return costPerNight; } 
	
	public double getLatitude() { return latitude; }
	public double getLongitude() { return longitude; }
	
	public void setId(String id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setDescription(String description) { this.description = description; }
	public void setRoomType(String roomType) { this.roomType = roomType; }
	public void setAmenities(String amenities) { this.amenities = amenities; }
	public void setCostPerNight(double costPerNight) { this.costPerNight = costPerNight; }
	public void setLatitude(double latitude) { this.latitude = latitude; }
	public void setLongitude(double longitude) { this.longitude = longitude; }
	
	public String toString() { return "ID: " + id + " Name: " + name; }

}
