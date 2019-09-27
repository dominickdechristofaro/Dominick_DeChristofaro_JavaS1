public class NestingLoops
{
	public static void main( String[] args )
	{
		// this is #1 - I'll call it "CN"
		// The inner loop (variable n) changes faster as shown by running the program
		// The numbers 1 - 3.
		// When changing the inner and outer loop, the A through E is iterated through
		// 3 times.
		for ( int n=1; n <= 3; n++ )
		{
			for ( char c='A'; c <= 'E'; c++ )
			{
				System.out.println( c + " " + n );
			}
		}

		System.out.println("\n");

		// this is #2 - I'll call it "AB"
		// Each loop is printed on a separate line when using println
		// When System.out.println() is places inside the first loop, but outside the second loop
		// A new line is printed after each iteration of the inner loops completes, but before the
		// outer loop completes.
		for ( int a=1; a <= 3; a++ )
		{
			for ( int b=1; b <= 3; b++ )
			{
				System.out.print( a + "-" + b + " " );
			}
			System.out.println();
		}

		System.out.println("\n");

	}
}
