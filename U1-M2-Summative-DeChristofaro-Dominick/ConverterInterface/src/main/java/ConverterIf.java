/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Convert an integer input (1 to 12) into the month of the year and convert a
 *                  second integer (1 to 7) into the day of the week using if/else/if else conditionals.
 *************************************************************************************************/
public class ConverterIf implements Converter {
    /**********************************************************************************************
     * Default Constructor
     *********************************************************************************************/
    public ConverterIf() {

    }

    /**********************************************************************************************
     *                      This method converts the given Integer into its corresponding month.
     * @param monthNumber   The Integer you wish to convert to a month.
     * @return              The name of the corresponding month if the parameter value is
     *                      between 1 and 12. Error message otherwise.
     *********************************************************************************************/
    public String convertMonth(int monthNumber) {
       if(monthNumber == 1) {
           return "January";
       }
       else if(monthNumber == 2) {
            return "February";
       }
       else if(monthNumber == 3) {
           return "March";
       }
       else if(monthNumber == 4) {
           return "April";
       }
       else if(monthNumber == 5) {
           return "May";
       }
       else if(monthNumber == 6) {
           return "June";
       }
       else if(monthNumber == 7) {
           return "July";
       }
       else if(monthNumber == 8) {
           return "August";
       }
       else if(monthNumber == 9) {
           return "September";
       }
       else if(monthNumber == 10) {
           return "October";
       }
       else if(monthNumber == 11) {
           return "November";
       }
       else if(monthNumber == 12) {
           return "December";
       }
       else {
           return "Error";
       }
    }

    /**********************************************************************************************
     *                      This method converts the given number into its corresponding day
     *                      of the week.
     * @param dayNumber     Number you wish to convert to a day of the week.
     * @return              The name of the corresponding day if the parameter value is between
     *                      1 and 7. Error message otherwise, The first day of the week is Sunday.
     *********************************************************************************************/
    public String convertDay(int dayNumber) {
        if(dayNumber == 1) {
            return "Sunday";
        }
        else if(dayNumber == 2) {
            return "Monday";
        }
        else if(dayNumber == 3) {
            return "Tuesday";
        }
        else if(dayNumber == 4) {
            return "Wednesday";
        }
        else if(dayNumber == 5) {
            return "Thursday";
        }
        else if(dayNumber == 6) {
            return "Friday";
        }
        else if(dayNumber == 7) {
            return "Saturday";
        }
        else {
            return "Error";
        }
    }
}
