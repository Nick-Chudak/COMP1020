/**
 * Quest
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 1, question 4
 * @author       Mykola Chudak, 8043157
 * @version      1/28/2025
 */


public class Quest {

    private String description;
    private int difficulty;
    private Companion[] companions;
    private int numCompanions;
    
    public Quest(String description, int difficulty) {

        this.setDescription(description);
        this.setDifficulty(difficulty);
        this.companions = new Companion[5];
        this.numCompanions = 0;
    }

    public void setDescription(String description) {

        if (description == null || description.isBlank()) {
            this.description = "Unnamed Quest";
            System.out.println("Error: Quest description cannot be null or empty");
        } else {
            this.description = description;
        }

    }

    public void setDifficulty(int difficulty) {

        if (1 <= difficulty && difficulty <= 10) {
            this.difficulty = difficulty;
        } else {
            this.difficulty = 1;
            System.out.println("Error: Difficulty must be between 1 and 10");
        }

    }

    public String getDescription() {
        return this.description;
    }

    public int getDifficulty() {
        return this.difficulty;
    }

    public int getNumCompanions() {
        return this.numCompanions;
    }

    public boolean addRequiredCompanion(Companion companion) {
        
        if (numCompanions >= this.companions.length) {
            System.out.println("Error: Cannot add more companions to this quest");
            return false;
        } else {
            companions[numCompanions] = companion;
            numCompanions++;
            return true;
        }
    }

    public boolean canComplete(Player player) {

        int requiredCompanions = difficulty / 2;
        int totalPower = 0;

        for (int i = 0; i < numCompanions; i++) {
            totalPower += companions[i].getPower();
        }

        return (numCompanions >= requiredCompanions) &&
               (totalPower >= difficulty * 10) &&
               (player.getNumArtifacts() >= numCompanions);
    }

    public String attemptQuest(Player player) {
        
        if (canComplete(player)) {
            return "Quest completed successfully! " + this.description;
        } else {
            player.takeDamage(difficulty * 10);
            return "Quest failed! The player has taken damage";
        }
    }

    public String toString() {
        return String.format("Quest{description='%s', difficulty=%d, numCompanions=%d}", 
                this.description, this.difficulty, this.numCompanions);
    }
}
