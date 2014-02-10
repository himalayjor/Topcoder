import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class MysticAndCandies
{
	public int minBoxes(int C, int X, int[] low, int[] high)
	{
		Arrays.sort(low);
		int n = low.length;
		
		int need = X;
		int c1 = 0;
		for (int i = n-1; i > -1 ; i--) {
			need -= low[i];
			c1++;
			if (need <= 0)
				break;
		}
		
		Arrays.sort(high);
		need = C-X;
		int c2 = 0;
		
		for (int i = 0; i < n; i++) {
			need -= high[i];
			c2++;
			if (need < 0) {
				c2--;
				break;	
			}
		}
		return Math.min(c1, n - c2);
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new MysticAndCandies().minBoxes(15, 12, new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 4, 5});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 3;
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
		answer = new MysticAndCandies().minBoxes(60, 8, new int[]{5, 2, 3}, new int[]{49, 48, 47});
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
		answer = new MysticAndCandies().minBoxes(58, 30, new int[]{3, 9, 12, 6, 15}, new int[]{8, 12, 20, 8, 15});
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
		answer = new MysticAndCandies().minBoxes(207581165, 172146543, new int[]{4725448, 2753824, 6019698, 4199708, 4070001, 3589497, 5358499, 3637585, 5393667, 2837466,2747807, 2918199, 3638042, 5199002, 3072044, 3858909, 3762101, 3657754, 3218704, 3888861,3195689, 4768935, 3137633, 4124272, 4125056, 6087486, 3632970, 3620489, 2748765, 5917493,3958996, 3335021, 3517186, 5543440, 2951006, 3403270, 3299481, 3093204, 4092331}, new int[]{5702812, 6805664, 6823687, 5337687, 4286533, 4999849, 6567411, 4563235, 6618139, 6260135,6249469, 3821449, 5963157, 6385012, 4255959, 5786920, 6112817, 4103918, 6371537, 4231698,3409172, 6806782, 5623563, 4511221, 6407338, 6491490, 5209517, 6076093, 6530132, 6111464,5833839, 6253088, 5595160, 6236805, 5772388, 5285713, 5617002, 4650978, 5234740});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 31;
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
		answer = new MysticAndCandies().minBoxes(43873566, 32789748, new int[]{2053198, 2175819, 4260803, 1542497, 1418952, 5000015, 1381849, 2462882, 6466891, 1827580, 6943641, 5775477}, new int[]{2827461, 3726335, 5410505, 4781355, 4925909, 5621160, 7325774, 5025476, 7876037, 8072075, 6979462, 6647628});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 7;
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
