import java.util.Arrays;

/**
 * Encrypter is a class that encrypts letter-based strings. The Encrypter
 * classes uses a simple encryption alphabet in which the characters of a normal
 * alphabet are shifted by a specified number of positions to either the right
 * or left. The class contains a char array normalAlphabet with the characters
 * for the normal alphabet.
 */

public class Encrypter {
	// lowercase letters of the alphabet
	private char[] normalAlphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u',
			'v', 'w', 'x', 'y', 'z' };
	private char[] encryptAlphabet = new char[26];

	/**
	 * Write the constructor for the Encrypter class. The constructor takes two
	 * parameters. The parameter shiftAmount indicates the number of positions
	 * the characters in the normal alphabet should be shifted. The parameter
	 * shiftToLeft indicates the direction the characters should be shifted. The
	 * constructor creates a char array encryptAlphabet that should consist of
	 * the characters in normal alphabet shifted properly. (Hint: Use the char
	 * array normalAlphabet to help produce the encryptAlphabet).
	 */
	public Encrypter(int shiftAmount, boolean shiftToLeft) {

		int global = 0;
		if (!shiftToLeft) {
			for (int i = 26 - shiftAmount; i < 26; i++) {
				encryptAlphabet[global] = normalAlphabet[i];
				global++;
			}
			for (int i = 0; i < shiftAmount; i++) {
				encryptAlphabet[global] = normalAlphabet[i];
				global++;
			}
			for (int i = shiftAmount; i < 26 - shiftAmount; i++) {
				encryptAlphabet[global] = normalAlphabet[i];
				global++;
			}
		} else {
			for (int i = shiftAmount; i < shiftAmount * 2; i++) {
				encryptAlphabet[global] = normalAlphabet[i];
				global++;
			}
			for (int i = shiftAmount * 2; i < 26; i++) {
				encryptAlphabet[global] = normalAlphabet[i];
				global++;
			}
			for (int i = 0; i < shiftAmount; i++) {
				encryptAlphabet[global] = normalAlphabet[i];
				global++;
			}
		}
		System.out.println("encryptAlphabet: " + Arrays.toString(encryptAlphabet));
		
	}

	private int indexOf(char c) {
		int i = -1;
		for (char letter : normalAlphabet) {
			i++;
			if (c == letter)
				return i;
		}
		return i;
	}
	
	/**
	 * Write the encrypt() method, which has a parameter for a word, and returns
	 * the encrypted version of that word.
	 */
	public String encrypt(String normalWord) {
		String r = "";
		char[] letters = normalWord.toCharArray();
		for (char letter : letters) {
			r += encryptAlphabet[indexOf(letter)];
		}
		return r;
	}
}