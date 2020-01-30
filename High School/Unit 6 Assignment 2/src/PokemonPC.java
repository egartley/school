import java.util.ArrayList;
import java.util.Arrays;

public class PokemonPC {

	private ArrayList<Pokemon> pokemon;

	public PokemonPC() {
		pokemon = new ArrayList<Pokemon>();
	}

	public PokemonPC(ArrayList<Pokemon> poke) {
		pokemon = poke;
	}

	public void add(Pokemon poke) {
		pokemon.add(poke);
	}

	public int count() {
		return pokemon.size();
	}

	public void removeByName(String name) {
		for (int i = 0; i < pokemon.size(); i++)
			if (pokemon.get(i).name.equals(name))
				pokemon.remove(i);
	}

	public ArrayList<Pokemon> getPokemonOfType(String type) {
		ArrayList<Pokemon> p = new ArrayList<Pokemon>();
		for (int i = 0; i < pokemon.size(); i++)
			if (pokemon.get(i).type.equals(type))
				p.add(pokemon.get(i));
		return p;
	}

	public Pokemon getHighestLevel() {
		int[] levels = new int[pokemon.size()];
		for (int i = 0; i < pokemon.size(); i++)
			levels[i] = pokemon.get(i).level;
		Arrays.sort(levels);
		Pokemon p = null;
		for (int i = 0; i < pokemon.size(); i++)
			if (pokemon.get(i).level == levels[levels.length - 1])
				p = pokemon.get(i);
		return p;
	}

	public String toString() {
		String s = "";
		for (Pokemon p : pokemon)
			s += p + "\n";
		return s.substring(0, s.length() - 1);
	}

}
