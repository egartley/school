public interface Sendable {

	void sendMessage(String messageType, String recipient);
	String getSender();
	
}
