public interface Rentable {
	
	/**
	 * @param time that the rentable object is being rented
	 * @return the total cost for the time the rentable is being rented
	 */
	public abstract double getRentalCharge(int time);

}
