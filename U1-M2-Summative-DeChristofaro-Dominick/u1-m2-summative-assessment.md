# Summative Assessment: Object-Oriented Programming in Java

This assessment consists of several coding exercises that evaluate your understanding of object-oriented programming in Java.

## Structure
* All code must reside in one directory called `U1-M2-Summative-Lastname-Firstname`.
* Your solution for each exercise must reside in its own IntelliJ project as specified in the exercise specifications below.

## Requirements/Features

### ConverterInterface

Create your solution in an IntelliJ project called ```ConverterInterface```.

In this exercise you will create two differnt implementations of the following interface. The first implementation must use if/else/else if statements and be called ```ConverterIf```. The second implementation must use switch statements and be called ```ConverterSwitch```.

Once you have your classes written, create a class called ```ConverterApplication``` which has your `main` method. In that main method, instantiate and use both the `ConverterIf` and `ConverterSwitch` classes.

```java
public interface Converter {

    /**
     * This method converts the given number into its corresponding month.
     * @param monthNumber the number you wish to convert to a month
     * @return the name of the corresponding month if the parameter value is between 1 and 12; error message otherwise
     */
    String convertMonth(int monthNumber);

    /**
     * This method converts the given number into its corresponding day of the week.
     * @param dayNumber number you wish to convert to a day of the week
     * @return the name of the corresponding day if the parameter value is between 1 and 7, error message otherwise
     * The first day of the week is Sunday
     */
    String convertDay(int dayNumber);

}
```

---

### CalculateObject
In this exercise, you will create an object that has a set of methods that does addition, subtraction, multiplication, and division for tow int parameters and a separate set of methods that does the same for two double parameters. You will then instantiate the object and use it to perform the following calculations. You must print out the calculation being performed and the result of the calculation. For example: 2 + 2 = 4

Create your solution in an IntelliJ project called ```CalculatorObject```.

* 1 + 1
* 23 - 52
* 34 * 2
* 12 / 3
* 12 / 7
* 3.4 + 2.3
* 6.7 * 4.4
* 5.5 - 0.5
* 10.8 / 2.2

---

### IceCreamDesign
In this exercise, you will model the attributes of two different ```IceCream``` classes: 

1. The first class represents ice cream as it might be modeled in the point-of-sale system in an ice cream shop.
1. The second class represents ice cream as it might be modeled in an ice cream factory.

Create your solution in an IntelliJ project called ```IceCreamClassDesign```.

---

### RPGInheritance
In this exercise, you will design an inheritance hierarchy for characters in a video game. Your design must include a common base clase for the following three character types:
* Farmer
* Constable
* Warrior


Create your solution in an IntelliJ project called (```RPGInheritance```).

* Farmer
  * Properties:
    * name
    * strength (initial value = 75)
    * health (initial value = 100)
    * stamina (initial value = 75)
    * speed (initial value = 10)
    * attackPower (initial value = 1)
  * Abilities:
    * run
    * plow
    * harvest
    * attack
    * heal
    * decreaseHealth
    * increaseStamina
    * decreaseStamina
* Constable
  * Properties
    * name
    * strength (initial value = 60)
    * health (initial value = 100)
    * stamina (initial value = 60)
    * speed (initial value = 20)
    * attackPower (initial value = 5)
    * jurisdiction
  * Abilities:
    * run
    * arrest
    * attack
    * heal
    * decreaseHealth
    * increaseStamina
    * decreaseStamina
* Warrior
  * Properties
    * name
    * strength (initial value = 75)
    * health (initial value = 100)
    * stamina (initial value = 100)
    * speed (initial value = 50)
    * attackPower (initial value = 10)
    * shieldStrength (initial value = 100)
  * Abilities:
    * run
    * attack
    * heal
    * decreaseHealth
    * increaseStamina
    * decreaseStamina
    * decreaseShieldStrength

---

### CustomerComposition
In this exercise, you will design and implement a class that represents a customer based on the specification below. Use composition for maximum code reuse. 

Create your solution in an IntelliJ project called ```CustomerComposition```.

* Design a Customer class.
* It must keep track of:
  * First name
  * Last name
  * Email
  * Phone number
  * Shipping address:
    * Street 1
    * Street 2
    * City
    * State
    * Zip
  * Billing address:
    * Street 1
    * Street 2
    * City
    * State
    * Zip
  * If the customer is a Rewards Member or not.


---
© 2019 Trilogy Education Services




