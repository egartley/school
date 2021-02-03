package lab2;

public class Airbnb extends Listing {

    private Host host;
    private String propertyType;
    private int lodging;
    private int baths;
    private int bedrooms;
    private int minNights;
    private int maxNights;

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public int getLodging() {
        return lodging;
    }

    public void setLodging(int lodging) {
        this.lodging = lodging;
    }

    public int getBaths() {
        return baths;
    }

    public void setBaths(int baths) {
        this.baths = baths;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getMinNights() {
        return minNights;
    }

    public void setMinNights(int minNights) {
        this.minNights = minNights;
    }

    public int getMaxNights() {
        return maxNights;
    }

    public void setMaxNights(int maxNights) {
        this.maxNights = maxNights;
    }

}
