/**
 * Player
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 1, question 2
 * @author       Mykola Chudak, 8043157
 * @version      1/28/2025
 */


public class Player {

    private String name;
    private int health;
    private Artifact[] inventory;
    private int numArtifacts;
    private boolean invalidInput = false;

    public Player(String name, int health) {

        this.setName(name);
        this.setHealth(health);
        this.inventory = new Artifact[10];
        this.numArtifacts = 0;

        if (invalidInput) {
            System.out.println("Warning: Default values assigned for invalid inputs.");
        }

    }

    public void setName(String name) {
        
        if (name == null || name.isBlank()) {
            this.name = "Unknown";
            this.invalidInput = true;
            System.out.println("Error: Player name cannot be null or empty");
        } else {
            this.name = name;
        }
    }

    public void setHealth(int health) {

        if (0 <= health && health <= 100) {
            this.health = health;
        } else {
            this.health = 100;
            this.invalidInput = true;
            System.out.println("Error: Health must be between 0 and 100");
        }
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getNumArtifacts() {
        return this.numArtifacts;
    }
    
    public void takeDamage(int amount) {
        
        if (amount < 0) {
            System.out.println("Error: Damage amount cannot be negative");
            
        } else {this.health -= amount;

            if (this.health < 0) {
                this.health = 0;
            }
        }
    }
    
    public boolean collectArtifact(Artifact artifact) {

        if (numArtifacts >= 10) {
            System.out.println("Error: Inventory is full, cannot add more artifacts");
            return false;
        } else {
            inventory[numArtifacts] = artifact;
            numArtifacts++;
            return true;
        }
    }

    public String toString() {
        return String.format("Player{name='%s', health=%d, numArtifacts=%d}", this.name, this.health, numArtifacts);
    }
}