import java.util.ArrayList;
import java.util.List;

public class Activities {

	private List<Activity> act;

	public Activities() {
		act = new ArrayList<Activity>();
	}

	public Activities(Activity[] activities) {
		this();
		for (Activity a : activities)
			act.add(a);
	}

	public void addActivity(Activity activity) {
		act.add(activity);
	}

	public void cancelActivity(Activity activity) {
		ArrayList<Short> indexes = new ArrayList<Short>();
		short c = 0;
		for (Activity a : act) {
			if (a.equals(activity))
				indexes.add(c);
			c++;
		}
		for (short s : indexes)
			act.remove(s);
	}

	public void cancelActivities(String location) {
		ArrayList<Short> indexes = new ArrayList<Short>();
		short c = 0;
		for (Activity a : act) {
			if (a.location.equals(location))
				indexes.add(c);
			c++;
		}
		for (short s : indexes)
			act.remove(s);
	}

	public List<Activity> getActivities() {
		return act;
	}

	public List<Activity> getActivities(String time) {
		List<Activity> ta = new ArrayList<Activity>();
		for (Activity a : act)
			if (a.time.equals(time))
				ta.add(a);
		return ta;
	}

	public String toString() {
		String r = "";
		short c = 1;
		for (Activity a : act) {
			r += c + ") " + a + "\n";
			c++;
		}
		return r;
	}

}
