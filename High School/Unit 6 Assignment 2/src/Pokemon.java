public class Pokemon {

	public String name;
	public String type;
	public int level;

	public Pokemon(String name, String type, int level) {
		this.name = name;
		this.type = type;
		this.level = level;
	}

	// Use String.format to return a string containing all of the fields
	// Sample output:
	// Level 8 Charmander, Fire Type
	public String toString() {
		return String.format("Level %d %s, %s Type", level, name, type);
	}

}
