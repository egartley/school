import java.util.ArrayList;

public class PokemonPCTester {

	public static void main(String[] args) {
		ArrayList<Pokemon> pokemon = new ArrayList<Pokemon>();
		pokemon.add(new Pokemon("Charmander", "Fire", 8));
		pokemon.add(new Pokemon("Mewtwo", "Psychic", 70));
		pokemon.add(new Pokemon("Pidgeot", "Flying", 23));
		pokemon.add(new Pokemon("Dugtrio", "Ground", 46));
		pokemon.add(new Pokemon("Wingull", "Water", 21));

		PokemonPC pc = new PokemonPC(pokemon);
		System.out.println(pc);
		System.out.println(pc.getHighestLevel());
		System.out.println(pc.getPokemonOfType("Fire"));
	}

}
