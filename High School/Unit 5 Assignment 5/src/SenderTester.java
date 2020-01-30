
public class SenderTester {

	public static void main(String[] args) {
		messageBomber(new ElectronicMailMessage("joesmith@yahoo.com"), "johndoe@gmail.com");
		messageBomber(new TextMessage("(585) 724-3193"), "(585) 810-3013");
		messageBomber(new SkypeMessage("spammer87"), "victim99");
	}
	
	public static void messageBomber(Sendable from, String to) {
		String type = "";
		if (from instanceof SkypeMessage)
			type = "a Skype message";
		else if (from instanceof ElectronicMailMessage)
			type = "an email";
		else
			type = "a text message";
		type += " of \"" + to + " you just got bombed by " + from.getSender() + "\"";
		for (int i = 0; i < 25; i++) {
			from.sendMessage(type, to);
		}
	}

}
