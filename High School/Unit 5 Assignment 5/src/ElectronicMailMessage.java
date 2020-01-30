
public class ElectronicMailMessage implements Sendable {

	private String address;
	
	public ElectronicMailMessage(String from) {
		address = from;
	}

	@Override
	public void sendMessage(String messageType, String recipient) {
		System.out.println("Sending " + messageType + " to " + recipient);
	}

	@Override
	public String getSender() {
		return address;
	}

}
