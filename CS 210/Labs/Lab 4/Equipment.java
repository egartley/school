public class Equipment implements Rentable {
	
	private String equipName;
	private double horsePower;
	private double hourlyCharge;

	/**
	 * @param equipName the name of the equipment
	 * @param horsePower the horse power of the quipment
	 * @param hourlyCharge the hourly cost of the equipment
	 */
	public Equipment(String equipName, double horsePower, double hourlyCharge) {
		super();
		this.equipName = equipName;
		this.horsePower = horsePower;
		this.hourlyCharge = hourlyCharge;
	}

	/**
	 * @return the equipName
	 */
	public String getEquipName() {
		return equipName;
	}

	/**
	 * @param equipName the equipName to set
	 */
	public void setEquipName(String equipName) {
		this.equipName = equipName;
	}

	/**
	 * @return the horsePower
	 */
	public double getHorsePower() {
		return horsePower;
	}

	/**
	 * @param horsePower the horsePower to set
	 */
	public void setHorsePower(double horsePower) {
		this.horsePower = horsePower;
	}

	/**
	 * @return the hourlyCharge
	 */
	public double getHourlyCharge() {
		return hourlyCharge;
	}

	/**
	 * @param hourlyCharge the hourlyCharge to set
	 */
	public void setHourlyCharge(double hourlyCharge) {
		this.hourlyCharge = hourlyCharge;
	}

	@Override
	public String toString() {
		return "Equipment: " + equipName + " has " + horsePower + " horse Power.";
	}

	@Override
	public double getRentalCharge(int time) {
		return time * hourlyCharge;
	}

}
