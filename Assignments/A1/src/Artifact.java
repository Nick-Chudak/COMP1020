/**
 * Artifact
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 1, question 1
 * @author       Mykola Chudak, 8043157
 * @version      1/28/2025
 */


public class Artifact {

    private String name;
    private int rarity;
    private boolean isCursed;

    private static int totalArtifacts = 0;

    public Artifact (String name, int rarity, boolean isCursed) {

        this.setName(name);
        this.setRarity(rarity);
        this.isCursed = isCursed;

        totalArtifacts += 1;
    }
    
    public void setName(String name) {

        if (name == null || name.isBlank()) {
            this.name = "Unknown";
            System.out.println("Error: Artifact name cannot be null or empty");
        } else {
            this.name = name;
        }

    }

    public void setRarity(int rarity) {

        if (1 <= rarity && rarity <= 5) {
            this.rarity = rarity;
        } else {
            this.rarity = 1;
            System.out.println("Error: Rarity must be between 1 and 5");
        }

    }

    public String getName() {
        return this.name;
    }

    public int  getRarity() {
        return this.rarity;
    }

    public boolean isCursed() {
        return this.isCursed;
    }

    public static int getTotalArtifacts() {
        return totalArtifacts;
    }

    public static void resetTotalArtifacts() {
        totalArtifacts = 0;
    }

    public String useArtifact() {

        if(isCursed == true) {
            return "The artifact is cursed! Beware!";
        } else {
            return "You use the " + this.name + " artifact. It glows with magical power!";
        }

    }
    
    public String toString() {

        return String.format(
            "Artifact{name='%s', rarity=%d, isCursed=%b}",
            this.name, this.rarity, this.isCursed
        );

    }
}