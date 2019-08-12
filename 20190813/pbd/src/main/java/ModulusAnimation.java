/**************************************************************************************************
 ** Author:         Dominick DeChristofaro
 ** Date:           08.13.2019
 ** Description:    Simulate a animation through terminal output and if statements.
 * 					https://programmingbydoing.com/a/modulus-animation.html
 *************************************************************************************************/
public class ModulusAnimation {
	public static void main( String[] args ) throws Exception {
		// The animation will run for 100 iterations
		for (int i = 0; i < 100; i++) {
			// Print the all the following sequentially
			if (i % 10 == 0) {
				System.out.print("X.........\r");
			}
			if (i % 10 == 1) {
				System.out.print(".X........\r");
			}
			if (i % 10 == 2) {
				System.out.print("..X.......\r");
			}
			if (i % 10 == 3) {
				System.out.print("...X......\r");
			}
			if (i % 10 == 4) {
				System.out.print("....X.....\r");
			}
			if (i % 10 == 5) {
				System.out.print(".....X....\r");
			}
			if (i % 10 == 6) {
				System.out.print("......X...\r");
			}
			if (i % 10 == 7) {
				System.out.print(".......X..\r");
			}
			if (i % 10 == 8) {
				System.out.print("........X.\r");
			}
			if (i % 10 == 9) {
				System.out.print(".........X\r");
			}
			// Pause the loop for 300 milliseconds before executing the next loop.
			Thread.sleep(300);
		}
	}
}
