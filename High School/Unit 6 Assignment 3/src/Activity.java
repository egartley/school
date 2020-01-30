public class Activity {

	public String location, time, eventName;

	public Activity(String eventName, String location, String time) {
		this.eventName = eventName;
		this.location = location;
		this.time = time;
	}

	public boolean equals(Activity other) {
		if (location.equals(other.location) == false)
			return false;
		if (time.equals(other.time) == false)
			return false;
		if (eventName.equals(other.eventName) == false)
			return false;
		return true;
	}

	public String toString() {
		return eventName + " - " + location + " (" + time + ")";
	}

}
