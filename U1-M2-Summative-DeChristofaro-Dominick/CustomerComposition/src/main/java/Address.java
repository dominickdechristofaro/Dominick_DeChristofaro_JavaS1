/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Address Class to store data of a Customers various Address (I.E. Home,
 *                  shipping, business, etc.)
 *************************************************************************************************/
public class Address {
    /**********************************************************************************************
     * Variables
     *********************************************************************************************/
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zipcode;

    /**********************************************************************************************
     * Default Constructor
     *********************************************************************************************/
    public Address() {

    }

    /**********************************************************************************************
     *                      5-Parameter Constructor
     * @param street1       Street Address 1    (String)
     * @param street2       Street Address 2    (String)
     * @param city          City                (String)
     * @param state         State               (String)
     * @param zipcode       Zip Code            (String)
     *********************************************************************************************/
    public Address(String street1, String street2, String city, String state, String zipcode) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    /**********************************************************************************************
     * Getters
     *********************************************************************************************/
    public String getStreet1() {
        return this.street1;
    }
    public String getStreet2() {
        return this.street2;
    }
    public String getCity() {
        return this.city;
    }
    public String getState() {
        return this.state;
    }
    public String getZipcode() {
        return this.zipcode;
    }

    /**********************************************************************************************
     * Setters
     *********************************************************************************************/
    public void setStreet1(String street1In) {
        this.street1 = street1In;
    }
    public void setStreet2(String street2In) {
        this.street2 = street2In;
    }
    public void setCity(String cityIn) {
        this.city = cityIn;
    }
    public void setState(String stateIn) {
        this.state = stateIn;
    }
    public void setZipcode(String zipcodeIn) {
        this.zipcode = zipcodeIn;
    }
}
