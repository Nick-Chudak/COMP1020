import java.util.ArrayList;

public class PokemonTeam {
    private ArrayList<Pokemon> team;


    public PokemonTeam() {
        this.team = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        this.team.add(pokemon);
    }  

    public Pokemon getPokemon(int index) {
        return this.team.get(index);
    }

    public void removePokemon(int index) {
        this.team.remove(index);
    }

    public int size() {
        return this.team.size();
    }

    public void updateTeam() {

    }

    public ArrayList<Pokemon> getTeam() {
        return this.team;
    }

    public String toString() {
        return 
    }

    public void clearTeam() {
        this.team.clear();
    }
}
