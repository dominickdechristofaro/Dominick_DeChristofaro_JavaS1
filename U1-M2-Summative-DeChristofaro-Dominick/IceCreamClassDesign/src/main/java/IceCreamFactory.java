/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Ice cream as it might be modeled in an ice cream factory.
 *************************************************************************************************/
public class IceCreamFactory {
    /**********************************************************************************************
     * Variables
     *********************************************************************************************/
    private int litersOfHeavyCream;
    private int poundsOfSugar;
    private int poundsOfIce;
    private int minutesOfStirring;
    private int numPintsInABatch;
    private String flavor;

    /**********************************************************************************************
     * Default Constructor
     *********************************************************************************************/
    public IceCreamFactory() {

    }

    /**********************************************************************************************
     *                              6-Parameter Constructor for IceCreamFactory.
     * @param litersOfHeavyCream    Number of liters of heavy cream required for a batch of ice cream.
     * @param poundsOfSugar         Number of pounds of sugar required for a batch of ice cream.
     * @param poundsOfIce           Number of pounds of ice required for a batch of ice cream.
     * @param minutesOfStirring     Number of minutes of stirring required for a batch of ice cream.
     * @param numPintsInABatch      Number of pints a batch of ice cream makes
     * @param flavor                The flavor of ice cream the batch produces.
     *********************************************************************************************/
    public IceCreamFactory(int litersOfHeavyCream, int poundsOfSugar, int poundsOfIce, int minutesOfStirring, int numPintsInABatch, String flavor) {
        this.litersOfHeavyCream = litersOfHeavyCream;
        this.poundsOfSugar = poundsOfSugar;
        this.poundsOfIce = poundsOfIce;
        this.minutesOfStirring = minutesOfStirring;
        this.numPintsInABatch = numPintsInABatch;
        this.flavor = flavor;
    }

    /**********************************************************************************************
     * Getters
     *********************************************************************************************/
    public int getLitersOfHeavyCream() {
        return this.litersOfHeavyCream;
    }
    public int getPoundsOfSugar() {
        return this.poundsOfSugar;
    }
    public int getPoundsOfIce() {
        return this.poundsOfIce;
    }
    public int getMinutesOfStirring() {
        return this.minutesOfStirring;
    }
    public int getNumPintsInABatch() {
        return this.numPintsInABatch;
    }
    public String getFlavor() {
        return this.flavor;
    }

    /**********************************************************************************************
     * Setters
     *********************************************************************************************/
    public void setLitersOfHeavyCream(int litersOfHeavyCreamIn) {
        this.litersOfHeavyCream = litersOfHeavyCreamIn;
    }
    public void setPoundsOfSugar(int poundsOfSugarIn) {
        this.poundsOfSugar = poundsOfSugarIn;
    }
    public void setPoundsOfIce(int poundsOfIceIn) {
        this.poundsOfIce = poundsOfIceIn;
    }
    public void setMinutesOfStirring(int minutesOfStirringIn) {
        this.minutesOfStirring = minutesOfStirringIn;
    }
    public void setNumPintsInABatch(int numPintsInABatchIn) {
        this.numPintsInABatch = numPintsInABatchIn;
    }
    public void setFlavor(String flavorIn) {
        this.flavor = flavorIn;
    }

    /**********************************************************************************************
     *                                  Calculates the total cost per pint of ice cream.  Prints out the
     *                                  total cost of the batch and the total cost per pint.
     * @param heavyCreamPerLiterCost    The cost per liter of heavy cream.
     * @param sugarPerPoundCost         The cost per pound of sugar.
     * @param icePerPoundCost           The cost per pound of ice.
     *********************************************************************************************/
    public void costPerPint(double heavyCreamPerLiterCost, double sugarPerPoundCost, double icePerPoundCost) {
        // Calculate the cost per batch
        double batchCost =  (heavyCreamPerLiterCost * this.litersOfHeavyCream) +
                            (sugarPerPoundCost * this.poundsOfSugar) +
                            (icePerPoundCost * this.poundsOfIce);

        // Calculate the cost per pint
        double costPerPint = batchCost / this.numPintsInABatch;

        // Output the results
        System.out.print("The total cost to make a batch of ");
        System.out.print(this.getFlavor());
        System.out.format(" ice cream is \u0024%.2f%n", batchCost);
        System.out.print("The total cost to make a pint of ");
        System.out.print(this.getFlavor());
        System.out.format(" ice cream is \u0024%.2f%n", costPerPint);
    }
}
