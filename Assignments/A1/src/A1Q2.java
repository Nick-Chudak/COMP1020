/**
 * Name of class or program (matches filename)
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 1, question 2
 * @author       Mykola Chudak, 8043157
 * @version      1/28/2025
 */


 public class A1Q2 {
    public static void main(String[] args) {
    // Valid player
    Player player1 = new Player("Arthur", 100);
    System.out.println(player1); // Player{name='Arthur', health=100, numArtifacts=0}
    // Invalid name
    Player player2 = new Player("", 50);
    // Output: Error: Player name cannot be null or empty
    // Output: Warning: Default values assigned for invalid inputs.
    System.out.println(player2); // Player{name='Unknown', health=50, numArtifacts=0}
    // Invalid health
    Player player3 = new Player("Lancelot", -10);
    // Output: Error: Health must be between 0 and 100
    // Output: Warning: Default values assigned for invalid inputs.
    System.out.println(player3); // Player{name='Lancelot', health=100, numArtifacts=0}
    // Collect artifacts
    Artifact artifact = new Artifact("Excalibur", 5, false);
    player1.collectArtifact(artifact);
    System.out.println(player1); // Player{name='Arthur', health=100, numArtifacts=1}
    // Take damage
    player1.takeDamage(30);
    System.out.println(player1); // Player{name='Arthur', health=70, numArtifacts=1}
    player1.takeDamage(100);
    System.out.println(player1); // Player{name='Arthur', health=0, numArtifacts=1}
    // Invalid damage
    player1.takeDamage(-20);
    // Output: Error: Damage amount cannot be negative.
    }
}