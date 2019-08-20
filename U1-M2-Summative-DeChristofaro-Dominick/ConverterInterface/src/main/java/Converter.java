/**************************************************************************************************
 *  Author:         Dominick DeChristofaro
 *  Date:           08.16.2019
 *  Description:    Converter Interface to convert integers to days of the month, and integers to
 *                  months of the year.
 *************************************************************************************************/
public interface Converter {
    /**********************************************************************************************
     *                      This method converts the given number into its corresponding month.
     * @param monthNumber   The number you wish to convert to a month.
     * @return              The name of the corresponding month if the parameter value is between
     *                      1 and 12. Error message otherwise.
     *********************************************************************************************/
    String convertMonth(int monthNumber);

    /**********************************************************************************************
     *                      This method converts the given number into its corresponding
     *                      day of the week.
     * @param dayNumber     Number you wish to convert to a day of the week.
     * @return              The name of the corresponding day if the parameter value is between
     *                      1 and 7. Error message otherwise. The first day of the week is Sunday.
     *********************************************************************************************/
    String convertDay(int dayNumber);
}
