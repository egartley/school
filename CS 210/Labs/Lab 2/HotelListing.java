package lab2;

public class HotelListing extends Listing {

    private double parkCharge;
    private int conferenceRooms;
    private boolean breakfastIncluded;
    private boolean pool;
    private boolean petsAllowed;

    public double getParkCharge() {
        return parkCharge;
    }

    public void setParkCharge(double parkCharge) {
        this.parkCharge = parkCharge;
    }

    public int getConferenceRooms() {
        return conferenceRooms;
    }

    public void setConferenceRooms(int conferenceRooms) {
        this.conferenceRooms = conferenceRooms;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public boolean isPool() {
        return pool;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

}
