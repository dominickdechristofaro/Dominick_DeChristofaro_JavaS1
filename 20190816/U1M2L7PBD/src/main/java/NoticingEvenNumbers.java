/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.16.2019
 ** Description:    https://programmingbydoing.com/a/noticing-even-numbers.html
 *************************************************************************************************/
public class NoticingEvenNumbers {
    public static void main(String[] args) {
        // Loop for 20 numbers
        for(int i = 1; i <= 20; i++) {
            // If evenly divisible by 2, mark
            if(i % 2 == 0) {
                System.out.println(i + " <");
            }
            // If not evenly divisible by 2, simply output the number
            else {
                System.out.println(i);
            }
        }
    }
}
