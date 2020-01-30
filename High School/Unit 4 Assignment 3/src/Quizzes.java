public class Quizzes {

	public int[] getDayScores(int[] scoresArray, String dayOfWeek) {
		int day = -1;
		switch (dayOfWeek.toLowerCase()) {
		case "monday":
			day = 0;
			break;
		case "tuesday":
			day = 1;
			break;
		case "wednesday":
			day = 2;
			break;
		case "thursday":
			day = 3;
			break;
		case "friday":
			day = 4;
			break;
		}
		int[] r = new int[scoresArray.length / 5];
		for (int d = day, i = 0; d < scoresArray.length; d += 5, i++) {
			r[i] = scoresArray[d];
		}
		return r;
	}

	private int total(int[] n) {
		int sum = n[0];
		for (int i = 1; i < n.length; i++) {
			sum += n[i];
		}
		return sum;
	}

	public String bestDay(int[] scoresArray) {
		String day = "Monday";
		int prev = total(getDayScores(scoresArray, day));
		for (int d = 1; d < 5; d++) {
			String s = "";
			if (d == 1) {
				s = "Tuesday";
			} else if (d == 2) {
				s = "Wednesday";
			} else if (d == 3) {
				s = "Thursday";
			} else if (d == 4) {
				s = "Friday";
			}
			int t = total(getDayScores(scoresArray, s));
			if (t > prev)
				day = s;
			prev = t;
		}
		return day;
	}
}
