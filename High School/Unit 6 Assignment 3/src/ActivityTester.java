public class ActivityTester {

	public static void main(String[] args) {
		Activities a1 = new Activities();
		a1.addActivity(new Activity("Chayse's Pool Party", "Helen Newman Hall",
				"11 AM"));
		a1.addActivity(new Activity("Retsim's Victory Party", "GSM", "9 PM"));
		System.out.println(a1);
		a1.addActivity(new Activity("Victor Graduation", "Blue Cross Arena",
				"6 PM"));
		System.out.println(a1);
		a1.cancelActivities("Helen Newman Hall");
		System.out.println(a1);
		System.out.println(a1.getActivities("6 PM"));
	}

}
