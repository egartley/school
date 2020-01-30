
public class TextMessage implements Sendable {

	private String number;
	
	public TextMessage(String from) {
		number = from;
	}

	@Override
	public void sendMessage(String messageType, String recipient) {
		System.out.println("Sending " + messageType + " to " + recipient);
	}

	@Override
	public String getSender() {
		return number;
	}

}
