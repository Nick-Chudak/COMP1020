import java.util.ArrayList;

public class Move {
    private String moveName;
    private Type moveType;
    private String category;
    private int power;
    private int accuracy;
    private ArrayList<Pokemon> pokemons;

    private static ArrayList<Move> moves;

    public Move(String moveName, Type moveType, String category, int power, int accuracy) {
        this.moveName = moveName;
        this.moveType = moveType;
        this.category = category;
        this.power = power;
        this.accuracy = accuracy;
    }

    public String getMoveName() {
        return this.moveName;
    }

    public int getPower() {
        return this.power;
    }

    public int getAccuracy() {
        return this.accuracy;
    }

    public Type getMoveType() {
        return this.moveType;
    }

    public void addPokemon(Pokemon p) {
        this.pokemons.add(p);
    }

    public String getPokemonsToString() {
        String output = "Pokemons: [";

        for (int i = 0; i < pokemons.size(); i++) {
            output += pokemons.get(i).getName();
            if (i != pokemons.size() - 1) {
                output += ", ";
            }
        }
        output += "]";

        return output;
    }

    public String toString() {
        return this.moveName + "(" + "MoveType : " + this.moveType.getTypeName() + ", Category: " + this.category 
                + ", Power: " + this.power + ", Accuracy : " + this.accuracy + ")" + this.getPokemonsToString();
    }

    public static ArrayList<Move> getMoves() {
        return moves;
    }

    public loadMoves() {

    }

    public Move findMove(String MoveName) {

        for (Move move : moves) {
            if (move.getMoveName() == MoveName) {
                return move;
            }
        }

        return null;
    }   
    
    public displayMoveStats() {
        
    }
}
