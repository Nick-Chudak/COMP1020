import java.util.ArrayList;

public class Type {
    private String typeName;
    private ArrayList<Pokemon> Pokemons;

    public static ArrayList<Type> types;

    public Type (String typeName) {
        this.typeName = typeName;
        this.Pokemons = new ArrayList<>();
    }

    public String getTypeName() {
        return this.typeName;
    }

    public void addPokemon(Pokemon p) {
        this.Pokemons.add(p);
    }

    public ArrayList<Pokemon> getPokemons() {
        return this.Pokemons;
    }

    public String toString() {
        return this.typeName;
    }

    public String getPokemonsToString() {
        String output = "Pokemons: [";

        for (int i = 0; i < Pokemons.size(); i++) {
            output += Pokemons.get(i).getName();
            if (i != Pokemons.size() - 1) {
                output += ", ";
            }
        }
        output += "]";

        return output;
    }

    public static ArrayList<Type> getTypes() {
        return types;
    }

    public static displayTypeStats


    public static Type findType(String typeName) {

        for (Type type : types) {
            if (type.getTypeName().equals(typeName)) {
                return type;
            }
        }

        Type newType = new Type(typeName);
        types.add(newType);
        
        return newType;
    }
}
