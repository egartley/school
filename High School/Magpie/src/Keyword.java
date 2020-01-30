public class Keyword {

	private String[] keys;
	private String response;
	
	public Keyword(String[] keys, String response) {
		this.keys = keys;
		this.response = response;
	}
	
	public String[] getKeys() {
		return keys;
	}
	
	public String getResponse() {
		return response;
	}
	
}