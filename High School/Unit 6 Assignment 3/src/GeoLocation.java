public class GeoLocation {

	public static final double RADIUS = 3963.1676;

	public String name;
	public double latitude;
	public double longitude;

	public GeoLocation(String name, double theLatitude, double theLongitude) {
		this.name = name;
		latitude = theLatitude;
		longitude = theLongitude;
	}

	public String toString() {
		return name + " (" + longitude + ", " + latitude + ")";
	}

	public double distanceFrom(GeoLocation other) {
		double lat1 = Math.toRadians(latitude);
		double long1 = Math.toRadians(longitude);
		double lat2 = Math.toRadians(other.latitude);
		double long2 = Math.toRadians(other.longitude);
		double theCos = Math.sin(lat1) * Math.sin(lat2) + Math.cos(lat1)
				* Math.cos(lat2) * Math.cos(long1 - long2);
		double arcLength = Math.acos(theCos);
		return arcLength * RADIUS;
	}
}