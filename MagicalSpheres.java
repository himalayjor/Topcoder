import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MagicalSpheres
{
	int fp(int n, int k)
	{
		int ret = 0;
		while (n > 0) {
			n = n/k;
			ret += n;
		}
		return ret;
	}
	
	int test(int n, int k, int d)
	{
		return fp(n, d) - fp(k, d) - fp(n-k, d);
	}
	
	public int divideWork(int spheres, int fake, int gnomes)
	{
		int n = spheres + fake;
		int m = fake;
		
		for (int i = gnomes; i > 0; i--) {
			int k = i;
			
			int fail = 0;
			for (int j = 2; j*j <= k; j++) {
				if (k % j == 0) {
					int tot = 0;
					while (k % j == 0) {
						tot++;
						k = k/j;
					}
					if (test(n, m, j) < tot) {
						fail = 1;
						break;
					}
				}
			}
			if (k > 1) {
				if (test(n, m, k) < 1)
					fail = 1;
			}
			
			if (fail == 0)
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new MagicalSpheres().divideWork(3, 1, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 2;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MagicalSpheres().divideWork(3, 3, 50);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 20;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MagicalSpheres().divideWork(4, 3, 4);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new MagicalSpheres().divideWork(15634, 456, 5000);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 4990;
		System.out.println("Your answer:");
		System.out.println("\t" + answer);
		System.out.println("Desired answer:");
		System.out.println("\t" + desiredAnswer);
		if (answer != desiredAnswer)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		
		
		if (errors)
			System.out.println("Some of the test cases had errors :-(");
		else
			System.out.println("You're a stud (at least on the test data)! :-D ");
	}

}
//Powered by [KawigiEdit] 2.0!
