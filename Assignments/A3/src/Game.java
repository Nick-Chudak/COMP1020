public class Game {
    private Player player1;
    private Player player2;
    private Menu menu;

    public Game () {
        this.menu = Menu.getInstance();
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return this.player1;
    }

    public Player getPlayer2() {
        return this.player2;
    }

    public void simulateGame() {

    }

    public void getPlayerNames() {
        
    }

    public void pickPokemons() {

    }

    public void sendPokemon(Player player) {

    }

    public void choosePokemonMove(Player player, Pokemon pokemon) {

    }

    public void startBattle() {

    }

    public void simulateFight(Pokemon player1Pokemon, Pokemon player2Pokemon) {

    }


}
