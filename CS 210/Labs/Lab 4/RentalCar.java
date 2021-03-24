public class RentalCar implements Rentable {
	
	private String make;
	private String model;
	private int year;
	private double dailyCharge;

	/**
	 * @param make
	 * @param model
	 * @param year
	 * @param dailyCharge
	 */
	public RentalCar(String make, String model, int year, double dailyCharge) {
		super();
		this.make = make;
		this.model = model;
		this.year = year;
		this.dailyCharge = dailyCharge;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * @return the dailyCharge
	 */
	public double getDailyCharge() {
		return dailyCharge;
	}

	/**
	 * @param dailyCharge the dailyCharge to set
	 */
	public void setDailyCharge(double dailyCharge) {
		this.dailyCharge = dailyCharge;
	}

	@Override
	public double getRentalCharge(int time) {
		return time * dailyCharge;
	}

	@Override
	public String toString() {
		return "Make: " + make + " Model:" + model + " year: " + year;
	}

}
