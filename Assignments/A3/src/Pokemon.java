import java.util.ArrayList;

public class Pokemon {
    private String name;
    private int level;
    private Stat statistics;
    private int currentHP;
    private ArrayList<Type> types;
    private ArrayList<Move> moves;

    private static ArrayList<Pokemon> Pokemons;

    public Pokemon(String name, int level, Stat statistics) {
        this.name = name;
        this.level = level;
        this.statistics = statistics;
        this.currentHP = this.statistics.getHP();
        this.types = null;
        this.moves = null;
    }

    public boolean isFainted() {
        return this.currentHP <= 0;
    }

    public boolean takeDamage(int damage) {
        this.currentHP -= damage;
        
        if (this.isFainted()) {
            this.statistics.recordLoss();
            return true;
        }

        return false;
    }

    public void attack(Pokemon opponent, Move move) {
        opponent.takeDamage(move.getPower());

        if (opponent.isFainted()) {
            this.getStatistics().recordWin();
            opponent.getStatistics().recordLoss();
        }
    }

    public String getName() {
        return this.name;
    }

    public String getHP() {
        return this.currentHP + "/" + this.statistics.getHP();
    }

    public int getSpeed() {
        return this.statistics.getSpeed();
    }

    
    public ArrayList<Move> getMoves() {
        return this.moves;
    }

    public Stat getStatistics() {
        return this.statistics;
    }

    public boolean isFasterThan(Pokemon opponent) {
        if (this.getSpeed() == opponent.getSpeed()) {
            return Math.random() < 0.5;
        } else {
            return this.getSpeed() > opponent.getSpeed();
        }
    }

    public String toString() {
        return "Pikachu (HP: " + this.currentHP + "/" + this.statistics.getHP() + ", Speed: " 
                + this.statistics.getSpeed() + ", Level: " + this.level + ", Types: " + this.types + ")";
    }

    public void addType(Type type) {
        this.types.add(type);
    }

    public void addMove(Move move) {
        this.moves.add(move);
    }

    public String toStringMoves() {
        return this.moves.toString();
    }

    public String toStringTypes() {
        return this.types.toString();
    }

    public void restoreHP() {
        this.currentHP = this.statistics.getHP();
    }

    public String getStat() {
        this.statistics
    }

    public static ArrayList<Pokemon> getPokemons() {
        return Pokemons;
    }

    public static void displayPokemonStats() {
        for (Pokemon p : Pokemons) {
            p.getStat();
            System.out.println();
        }
    }
    public static void restoreAllHP() {
        for (Pokemon p : Pokemons) {
            p.restoreHP();
        }
    }

    public static void loadPokemons() {
        
    }
}
