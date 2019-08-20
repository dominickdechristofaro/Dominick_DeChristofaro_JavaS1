/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Warrior class inherits from the Character Base Class.  Models a Warrior
 *                  character type in an RPG video game.
 *************************************************************************************************/
public class Warrior extends Character {
    /**********************************************************************************************
     * Properties
     *********************************************************************************************/
    private int shieldStrength;

    /**********************************************************************************************
     * Default Constructor
     *********************************************************************************************/
    public Warrior() {
        super("Warrior", 75, 100, 100, 50, 10);
        this.shieldStrength = 100;
    }

    /**********************************************************************************************
     * Getters
     *********************************************************************************************/
    public int getShieldStrength() {
        return this.shieldStrength;
    }

    /**********************************************************************************************
     * Setters
     *********************************************************************************************/
    public void setShieldStrength(int shieldStrengthIn) {
        this.shieldStrength = shieldStrengthIn;
    }

    /**********************************************************************************************
     * Your characters shield strength is decreased by 10.
     *********************************************************************************************/
    public void decreaseShieldStrength() {
        System.out.println("Your shield takes 10 damage.");
        this.setShieldStrength(this.getShieldStrength() - 10);
    }
}
