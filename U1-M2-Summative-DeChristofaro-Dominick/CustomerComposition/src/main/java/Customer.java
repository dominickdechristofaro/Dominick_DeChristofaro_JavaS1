/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.20.2019
 *  Description:    Models a customer using composition (extends) in java.
 *************************************************************************************************/
public class Customer extends Address {
    /**********************************************************************************************
     * Variables
     *********************************************************************************************/
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private boolean isRewardsMember;
    private Address shippingAddress;
    private Address billingAddress;

    /**********************************************************************************************
     * Default Constructor
     *********************************************************************************************/
    public Customer() {
    }

    /**********************************************************************************************
     *                          7-Parameter Constructor, Requires Shipping & Billing Address
     * @param firstName         Customer's First Name           (String)
     * @param lastName          Customer's Last Name            (String)
     * @param email             Customer's Email                (String)
     * @param phoneNumber       Customer's Phone Number         (String)
     * @param isRewardsMember   is Customer a Reward Member?    (T/F)
     * @param shippingAddress   Customer's Shipping Address     (Object)
     * @param billingAddress    Customer's Billing Address      (Object)
     *********************************************************************************************/
    public Customer(String firstName, String lastName, String email, String phoneNumber, boolean isRewardsMember, Address shippingAddress, Address billingAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.isRewardsMember = isRewardsMember;
        this.shippingAddress = shippingAddress;
        this.billingAddress = billingAddress;
    }

    /**********************************************************************************************
     * Getters
     *********************************************************************************************/
    public String getFirstName() {
        return this.firstName;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPhoneNumber() {
        return this.phoneNumber;
    }
    public boolean isRewardsMember() {
        return this.isRewardsMember;
    }
    public Address getShippingAddress() {
        return this.shippingAddress;
    }
    public Address getBillingAddress() {
        return this.billingAddress;
    }

    /**********************************************************************************************
     * Setters
     *********************************************************************************************/
    public void setFirstName(String firstNameIn) {
        this.firstName = firstNameIn;
    }
    public void setLastName(String lastNameIn) {
        this.lastName = lastNameIn;
    }
    public void setEmail(String emailIn) {
        this.email = emailIn;
    }
    public void setPhoneNumber(String phoneNumberIn) {
        this.phoneNumber = phoneNumberIn;
    }
    public void setRewardsMember(boolean rewardsMemberIn) {
        this.isRewardsMember = rewardsMemberIn;
    }
    public void setShippingAddress(Address shippingAddressIn) {
        this.shippingAddress = shippingAddressIn;
    }
    public void setBillingAddress(Address billingAddressIn) {
        this.billingAddress = billingAddressIn;
    }
}
