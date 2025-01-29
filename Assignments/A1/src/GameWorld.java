/**
 * GameWorld
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 1, question 5
 * @author       Mykola Chudak, 8043157
 * @version      1/28/2025
 */


import java.util.Random;

public class GameWorld {

    private static GameWorld instance;

    private Artifact[] artifacts;
    private int numArtifacts;
    private Player[] players;
    private int numPlayers;
    private Quest[] quests;
    private int numQuests;


    private GameWorld() {
        
        this.players = new Player[100];
        this.numPlayers = 0;
        this.artifacts = new Artifact[50];
        this.numArtifacts = 0;
        this.quests = new Quest[20];
        this.numQuests = 0;
    }

    public static GameWorld getInstance() {

        if (instance == null) {
            instance = new GameWorld();
        }
        return instance;
        
    }


    public static GameWorld resetWorld() {
        GameWorld.instance = new GameWorld();
        return GameWorld.instance;
    }

    public boolean addPlayer(Player player) {

        if (numPlayers >= players.length) {
            System.out.println("Error: Cannot add more players to the GameWorld.");
            return false;
        }
        players[numPlayers] = player;
        numPlayers++;
        return true;

    }

    public boolean addArtifact(Artifact artifact) {

        if (numArtifacts >= artifacts.length) {
            System.out.println("Error: Cannot add more artifacts to the GameWorld.");
            return false;
        }
        artifacts[numArtifacts++] = artifact;
        return true;

    }

    public boolean addQuest(Quest quest) {

        if (numQuests >= quests.length) {
            System.out.println("Error: Cannot add more quests to the GameWorld.");
            return false;
        }
        quests[numQuests] = quest;
        numQuests++;
        return true;

    }

    public Artifact getRandomArtifact() {

        if (numArtifacts == 0) {
            System.out.println("Error: No artifacts available in the GameWorld.");
            return null;
        }
        Random random = new Random();
        return artifacts[random.nextInt(numArtifacts)];

    }

    public Player[] getPlayers() {
        Player[] activePlayers = new Player[numPlayers];

        System.arraycopy(players, 0, activePlayers, 0, numPlayers);
        return activePlayers;
    }

    public Quest[] getQuests() {
        Quest[] activeQuests = new Quest[numQuests];
        System.arraycopy(quests, 0, activeQuests, 0, numQuests);
        return activeQuests;
    }

}