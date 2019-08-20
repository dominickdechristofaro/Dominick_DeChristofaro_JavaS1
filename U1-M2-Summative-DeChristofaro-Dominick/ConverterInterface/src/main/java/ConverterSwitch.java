/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Convert an integer input (1 to 12) into the month of the year and convert a
 *                  second integer (1 to 7) into the day of the week using switch conditionals.
 *************************************************************************************************/
public class ConverterSwitch implements Converter {
    /**********************************************************************************************
     * Default Constructor
     *********************************************************************************************/
    public ConverterSwitch() {

    }

    /**********************************************************************************************
     *                      This method converts the given Integer into its corresponding month.
     * @param monthNumber   The Integer you wish to convert to a month.
     * @return              The name of the corresponding month if the parameter value is
     *                      between 1 and 12. Error message otherwise.
     *********************************************************************************************/
    public String convertMonth(int monthNumber) {
        String monthString;
        switch (monthNumber) {
            case 1:     monthString = "January";
                        break;
            case 2:     monthString = "February";
                        break;
            case 3:     monthString = "March";
                        break;
            case 4:     monthString = "April";
                        break;
            case 5:     monthString = "May";
                        break;
            case 6:     monthString = "June";
                        break;
            case 7:     monthString = "July";
                        break;
            case 8:     monthString = "August";
                        break;
            case 9:     monthString = "September";
                        break;
            case 10:    monthString = "October";
                        break;
            case 11:    monthString = "November";
                        break;
            case 12:    monthString = "December";
                        break;
            default:    monthString = "Error";
                        break;
        }
        return monthString;
    }

    /**********************************************************************************************
     *                      This method converts the given Integer into its corresponding day
     *                      of the week.
     * @param dayNumber     Number you wish to convert to a day of the week.
     * @return              The name of the corresponding day if the parameter value is between
     *                      1 and 7. Error message otherwise. The first day of the week is Sunday.
     *********************************************************************************************/
    public String convertDay(int dayNumber) {
        String dayString;
        switch (dayNumber) {
            case 1:     dayString = "Sunday";
                        break;
            case 2:     dayString = "Monday";
                        break;
            case 3:     dayString = "Tuesday";
                        break;
            case 4:     dayString = "Wednesday";
                        break;
            case 5:     dayString = "Thursday";
                        break;
            case 6:     dayString = "Friday";
                        break;
            case 7:     dayString = "Saturday";
                        break;
            default:    dayString = "Error";
                        break;
        }
        return dayString;
    }
}
