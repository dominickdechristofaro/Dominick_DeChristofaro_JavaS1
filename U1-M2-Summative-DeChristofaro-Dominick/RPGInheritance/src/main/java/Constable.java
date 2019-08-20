/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Constable class inherits from the Character Base Class.  Models a Constable
 *                  character type in an RPG video game.
 *************************************************************************************************/
public class Constable extends Character {
    /**********************************************************************************************
     * Properties
     *********************************************************************************************/
    private int jurisdiction;

    /**********************************************************************************************
     * Constructor to initialize the following values:
     *      name            = "Constable"
     *      strength        = 60
     *      health          = 100
     *      stamina         = 60
     *      speed           = 20
     *      attackPower     = 5
     *      jurisdiction    = int parameter
     *********************************************************************************************/
    public Constable(int jurisdiction) {
        super("Constable", 60, 100, 60, 20, 5);
        this.jurisdiction = jurisdiction;
    }

    /**********************************************************************************************
     * Getters
     *********************************************************************************************/
    public int getJurisdiction() {
        return this.jurisdiction;
    }

    /**********************************************************************************************
     * Setters
     *********************************************************************************************/
    public void setJurisdiction(int jurisdictionIn) {
        this.jurisdiction = jurisdictionIn;
    }

    /**********************************************************************************************
     * You arrest the other character and increase your jurisdiction by 10.
     *********************************************************************************************/
    public void arrest() {
        System.out.println("You arrest the other character. Your jurisdiction increases by 10.");
        this.setJurisdiction(this.getJurisdiction() + 10);
    }
}
