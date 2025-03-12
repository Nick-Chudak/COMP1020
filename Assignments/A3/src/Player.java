import java.util.ArrayList;

public class Player {
    private String name;
    private PokemonTeam team;
    private int wins;
    private int losses;


    public static ArrayList<Player> players;

    public Player(String name) {
        this.name = name;
        this.wins = 0;
        this.losses = 0;
        this.team = null;
    }


    public Player findPlayer(String name) {
        for (Player p : players) {
            if (p.getName().equals(name)) {
                return p;
            }
        }

        Player newPlayer = new Player(name);
        players.add(newPlayer);

        return newPlayer;
    }

    public String displayPlayerStats() {
        
    }

    public void wonAgainst(Player otherPlayer) {
        this.recordVictory();
        otherPlayer.recordLoss();
    }

    public void recordVictory() {
        this.wins += 1;
    }

    public void recordLoss() {
        this.losses += 1;
    }

    public void clearPlayer() {
        players.clear();
    }

    public String getName() {
        return this.name;
    }

    public PokemonTeam getTeam() {
        return this.team;
    }

    public String toString() {
        return this.name + " " + "(Wins: " + this.wins + ", Losses: " + this.losses + ")";
    }
}
