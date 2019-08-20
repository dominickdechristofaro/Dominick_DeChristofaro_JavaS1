/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Farmer class inherits from the Character Base Class.  Models a Farmer character
 *                  type in an RPG video game.
 *************************************************************************************************/
public class Farmer extends Character {
    /**********************************************************************************************
     * Default Constructor to initialize the following values:
     *      name        = Farmer
     *      strength    = 75
     *      health      = 100
     *      stamina     = 75
     *      speed       = 10
     *      attackPower = 1
     *********************************************************************************************/
    public Farmer() {
        super("Farmer", 75, 100, 75, 10, 1);
    }

    /**********************************************************************************************
     * The Farmer plow's his fields to prepare for the harvest. Lost 10 stamina.
     *********************************************************************************************/
    public void plow() {
        System.out.println("You plow the fields to prepare the soil. Lose 10 Stamina.");
        this.setStamina(this.getStamina() - 10);
    }

    /**********************************************************************************************
     * The Farmer harvest's his fields and gains 10 health, speed, and strength.
     *********************************************************************************************/
    public void harvest() {
        System.out.println("Your fields are ripe for harvest! Gain 10 health, speed, and strength.");
        this.setHealth(this.getHealth() + 10);
        this.setSpeed(this.getSpeed() + 10);
        this.setStrength(this.getStrength() + 10);
    }
}
