public class Magpie {

	private Keyword[] keywords = new Keyword[] {
			new Keyword(new String[] { "no" }, "Why so negative?"),
			new Keyword(new String[] { "mother", "father", "sister", "brother",
					"mom", "dad", "aunt", "uncle", "cousin", "papa", "mama",
					"daddy", "mommy" }, "Tell me more about your family?"),
			new Keyword(new String[] { "math" },
					"So, are you taking a math course?"),
			new Keyword(
					new String[] { "hit", "slap", "punch", "knob", "smack" },
					"I don't like violence. Let's change the subject!"),
			new Keyword(new String[] { "wuest" }, "I hear he is one swell guy!"),
			new Keyword(new String[] { "school", "education", "edu" },
					"Make sure to stay in school!"),
			new Keyword(new String[] { "english", "ela" },
					"English is a very important class!"),
			new Keyword(new String[] { "music", "song", "songs" },
					"What kind of music do you listen to?") };

	public String getGreeting() {
		int r = (int) (Math.random() * 10 + 1);
		String s = "";
		switch (r) {
		case 1:
			s = "Hey there!";
			break;
		case 2:
			s = "How's it going?";
			break;
		case 3:
			s = "How are you today?";
			break;
		case 4:
			s = "What's up, doc?";
			break;
		case 5:
			s = "Good day to you!";
			break;
		case 6:
			s = "What are you up to?";
			break;
		case 7:
			s = "What do you want to talk about?";
			break;
		case 8:
			s = "Hey!";
			break;
		case 9:
			s = "Hello!";
			break;
		case 10:
			s = "Hi!";
			break;
		}
		return s;
	}

	public String getResponse(String statement) {
		String s = statement.toLowerCase();

		if (s.length() == 0)
			return "Please say something";
		if (s.startsWith("i want to "))
			return transformIWantStatement(s);

		for (Keyword keyword : keywords) {
			for (String key : keyword.getKeys()) {
				if (findKeyword(s, key) != -1)
					return keyword.getResponse();
			}
		}

		return getRandomResponse();
	}

	public String getRandomResponse() {
		int r = (int) (Math.random() * 6 + 1);
		String s = "";
		switch (r) {
		case 1:
			s = "Oh";
			break;
		case 2:
			s = "Huh.";
			break;
		case 3:
			s = "Cool!";
			break;
		case 4:
			s = "Tell me more, please.";
			break;
		case 5:
			s = "Hmmm";
			break;
		case 6:
			s = "That's odd";
			break;
		}
		return s;
	}

	public String transformIWantStatement(String statement) {
		return "What would it mean to "
				+ statement
						.substring("I want to ".length(), statement.length())
				+ "?";
	}

	public int findKeyword(String statement, String keyword) {
		String phrase = statement.trim();
		int keywordIndex = phrase.indexOf(keyword);
		if (keywordIndex == -1)
			return -1;

		boolean spaceBefore = phrase.substring(keywordIndex - 1, keywordIndex)
				.equals(" ");
		boolean spaceAfter = phrase.substring(keywordIndex + keyword.length(),
				keywordIndex + keyword.length() + 1).equals(" ");

		if (statement.equalsIgnoreCase(keyword))
			return keywordIndex;

		if (keywordIndex == 0
				&& phrase.substring(keyword.length(), keyword.length() + 1)
						.equals(" "))
			return keywordIndex;

		if (spaceBefore && !spaceAfter)
			return keywordIndex;

		if (spaceBefore && spaceAfter)
			return keywordIndex;
		else
			return -1;
	}

}