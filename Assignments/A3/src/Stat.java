public class Stat {
    private int HP;
    private int attack;
    private int defense;
    private int speed;
    private int wins;
    private int losses;

    public Stat(int HP, int attack, int defense, int speed) {
        this.HP = HP;
        this.attack = attack;
        this.defense = defense;
        this.speed = speed;
        this.wins = 0;
        this.losses = 0;
    }

    public int getHP() {
        return this.HP;
    }
    
    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void recordWin() {
        this.wins++;
    }

    public void recordLoss() {
        this.losses++;
    }

    public int getWins() {
        return this.wins;
    }


    public int getLosses() {
        return this.losses;
    }

    public String toString() {
        return "HP: " + this.HP + ", Attack : " + this.attack + ", Defense : " + ", Speed: " + this.speed;
    }
}
