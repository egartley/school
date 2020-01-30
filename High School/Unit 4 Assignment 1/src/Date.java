public class Date {

	private int year, day;
	private String month;

	public Date() {
		month = "June";
		day = 1;
		year = 1970;
	}

	public Date(String m, int d, int y) {
		setMonth(m);
		setDay(d);
		setYear(y);
	}

	public String getMonth() {
		return month;
	}

	public int getDay() {
		return day;
	}

	public int getYear() {
		return year;
	}

	public void setMonth(String m) {
		month = m;
	}

	public void setDay(int d) {
		day = d;
	}

	public void setYear(int y) {
		year = y;
	}

	public String toString() {
		return month + " " + day + ", " + year;
	}

}