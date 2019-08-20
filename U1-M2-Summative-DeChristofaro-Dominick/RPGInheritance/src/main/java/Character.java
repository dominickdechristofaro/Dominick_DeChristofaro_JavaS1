/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Base class for the Farmer, Constable, and Warrior Classes.
 *************************************************************************************************/
public class Character {
    /**********************************************************************************************
     * Properties
     *********************************************************************************************/
    private String name;
    private int strength;
    private int health;
    private int stamina;
    private int speed;
    private int attackPower;

    /**********************************************************************************************
     * Default Constructor
     *********************************************************************************************/
    public Character() {

    }

    /**********************************************************************************************
     *                      6-Parameter Constructor to initialize a Character
     * @param name          Character's Name
     * @param strength      Character's initial strength
     * @param health        Character's initial health
     * @param stamina       Character's initial stamina
     * @param speed         Character's initial speed
     * @param attackPower   Character's initial attack power
     *********************************************************************************************/
    public Character(String name, int strength, int health, int stamina, int speed, int attackPower) {
        this.name = name;
        this.strength = strength;
        this.health = health;
        this.stamina = stamina;
        this.speed = speed;
        this.attackPower = attackPower;
    }

    /**********************************************************************************************
     * Getters
     *********************************************************************************************/
    public String getName() {
        return this.name;
    }
    public int getStrength() {
        return this.strength;
    }
    public int getHealth() {
        return this.health;
    }
    public int getStamina() {
        return this.stamina;
    }
    public int getSpeed() {
        return this.speed;
    }
    public int getAttackPower() {
        return this.attackPower;
    }

    /**********************************************************************************************
     * Setters
     *********************************************************************************************/
    public void setName(String nameIn) {
        this.name = nameIn;
    }
    public void setStrength(int strengthIn) {
        this.strength = strengthIn;
    }
    public void setHealth(int healthIn) {
        this.health = healthIn;
    }
    public void setStamina(int staminaIn) {
        this.stamina = staminaIn;
    }
    public void setSpeed(int speedIn) {
        this.speed = speedIn;
    }
    public void setAttackPower(int attackPowerIn) {
        this.attackPower = attackPowerIn;
    }

    /**********************************************************************************************
     * Increase the speed of your character by 10.
     *********************************************************************************************/
    public void run() {
        this.setSpeed(this.getSpeed() + 10);
    }

    /**********************************************************************************************
     * Your character attacks for their attack power in damage.
     *********************************************************************************************/
    public void attack() {
        System.out.println("Attacked for " + this.getAttackPower() + " damage.");
    }

    /**********************************************************************************************
     * Your Character's health increases by 10.
     *********************************************************************************************/
    public void heal() {
        this.setHealth(this.getHealth() + 10);
    }

    /**********************************************************************************************
     * Your Character's health decreases by 10.
     *********************************************************************************************/
    public void decreaseHealth() {
        this.setHealth(this.getHealth() - 10);
    }

    /**********************************************************************************************
     * Your Character's stamina increases by 10.
     *********************************************************************************************/
    public void increaseStamina() {
        this.setStamina(this.getStamina() + 10);
    }

    /**********************************************************************************************
     * Your Character's stamina decreases by 10.
     *********************************************************************************************/
    public void decreaseStamina() {
        this.setStamina(this.getStamina() - 10);
    }
}
