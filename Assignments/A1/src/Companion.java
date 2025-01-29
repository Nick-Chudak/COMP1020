/**
 * Companion
 *
 * COMP 1020 SECTION A04
 * INSTRUCTOR    Pouya Aghahoseini
 * ASSIGNMENT    Assignment 1, question 3
 * @author       Mykola Chudak, 8043157
 * @version      1/28/2025
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Companion {

    private String name;
    private String role;
    private String ability;
    private int power;
    private Player owner;

    private boolean invalidInput = false;

    private String[] DEFAULT_ROLES = {"Mage", "Warrior", "Healer"};
    // private String[] DEFAULT_ABILITIES = {"casts a fireball!", "swings a mighty sword!", "heals the party!"};
    private Map<String, String> ROLE_TO_ABILITY = new HashMap<>();
    {
        ROLE_TO_ABILITY.put("Mage", "casts a fireball!");
        ROLE_TO_ABILITY.put("Warrior", "swings a mighty sword!");
        ROLE_TO_ABILITY.put("Healer", "heals the party!");
    };

    public Companion(String name, String role, int power, Player owner)  {
        
        this.setName(name);
        this.setRole(role);
        this.setPower(power);
        this.setAbility(role);
        this.setOwner(owner);

        if (invalidInput) {
            System.out.println("Warning: Default values assigned for invalid inputs.");
        }
        
    }

    public void setName(String name) {
        
        if (name == null || name.isBlank()) {
            this.name = "Unknown";
            System.out.println("Error: Companion name cannot be null or empty");
            invalidInput = true;
        } else {
            this.name = name;
        }
    }

    public void setRole(String role) {

        if (Arrays.asList(DEFAULT_ROLES).contains(role)) {
            this.role = role;
        } else {
            this.role = "Unknown Role Type";
            System.out.println("Error: Companion role should be a Mage, Warrior, or Healer");
            invalidInput = true;
        }
    }

    public void setAbility(String role) {

        if (Arrays.asList(DEFAULT_ROLES).contains(role)) {
            this.ability = ROLE_TO_ABILITY.get(role);
        } else {
            this.ability = "rolls around on the ground...";
        }
    }

    public void setPower(int power) {

        if (1 <= power && power <= 100) {
            this.power = power;
        } else {
            this.power = 1;
            System.out.println("Error: Power must be between 1 and 100");
            invalidInput = true;
        }
    }
    
    public void setOwner(Player owner) {
        
        if (owner == null) {
            this.owner = new Player("Default Player", 100);
            System.out.println("Error: Companion must be assigned to a valid Player");
            invalidInput = true;
        } else {
            this.owner = owner;
        }
    }
 
    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public int getPower() {
        return this.power;
    }

    public Player getOwner() {
        return this.owner;
    }

    public String useAbility() {
        switch (role) {
            case "Mage":
                return "Mage " + this.ability;
            case "Warrior":
                return "Warrior " + this.ability;
            case "Healer":
                return "Healer " + this.ability;
            default:
                return this.name + " " + this.ability;
        }
    }

    public String toString() {
        return String.format("Companion{name='%s', role='%s', power=%d, owner='%s'}", 
                this.name, this.role, this.power, this.owner.getName());
    }
}