/**
 * Name of class or program (matches filename)
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 1, question 5
 * @author       Mykola Chudak, 8043157
 * @version      1/28/2025
 */

public class A1Q5 {
        public static void main(String[] args) {
        GameWorld world = GameWorld.getInstance();
        // Add players
        Player player1 = new Player("Arthur", 100);
        Player player2 = new Player("Merlin", 90);
        world.addPlayer(player1);
        world.addPlayer(player2);
        // Add artifacts
        Artifact artifact1 = new Artifact("Excalibur", 5, false);
        Artifact artifact2 = new Artifact("Pandora's Box", 4, true);
        world.addArtifact(artifact1);
        world.addArtifact(artifact2);
        // Add quests
        Quest quest1 = new Quest("Defend the Village", 5);
        Quest quest2 = new Quest("Find the Holy Grail", 7);
        world.addQuest(quest1);
        world.addQuest(quest2);
        // Get players and quests
        for (Player player : world.getPlayers()) {
        System.out.println(player);
        }
        for (Quest quest : world.getQuests()) {
        System.out.println(quest);
        }
        // Get a random artifact
        Artifact randomArtifact = world.getRandomArtifact();
        System.out.println("Random Artifact: " + randomArtifact);
        // Try adding beyond capacity
        for (int i = 0; i < 101; i++) {
        world.addPlayer(new Player("ExtraPlayer" + i, 100));
        }
    }
}