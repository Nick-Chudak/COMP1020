/**
 * Name of class or program (matches filename)
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 1, question 4
 * @author       Mykola Chudak, 8043157
 * @version      1/28/2025
 */


public class A1Q4 {
    public static void main(String[] args) {
        Player player = new Player("Arthur", 100);

        // Valid quest
        Quest quest = new Quest("Defend the Village", 5);
        System.out.println(quest); 
        // Quest{description='Defend the Village', difficulty=5, numCompanions=0}

        // Add required companions
        Companion mage = new Companion("Merlin", "Mage", 80, player);
        Companion warrior = new Companion("Lancelot", "Warrior", 70, player);
        quest.addRequiredCompanion(mage);
        quest.addRequiredCompanion(warrior);

        // Check if the quest can be completed
        System.out.println("Can complete quest: " + quest.canComplete(player)); // false
        player.collectArtifact(new Artifact("Magic Wand", 5, false));
        player.collectArtifact(new Artifact("Shield", 5, false));
        System.out.println("Can complete quest: " + quest.canComplete(player)); // true

        // Attempt the quest
        System.out.println(quest.attemptQuest(player));
        // Quest completed successfully! Defend the Village
    }
}