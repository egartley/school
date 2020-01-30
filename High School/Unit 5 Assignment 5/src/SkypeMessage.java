
public class SkypeMessage implements Sendable {

	public String username;
	
	public SkypeMessage(String u) {
		username = u;
	}

	@Override
	public void sendMessage(String messageType, String recipient) {
		System.out.println("Sending " + messageType + " to " + recipient);
	}

	@Override
	public String getSender() {
		return username;
	}

}
