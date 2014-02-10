import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class EllysPairing
{
	public int getMax(int M, int[] count, int[] first, int[] mult, int[] add)
	{
		long p = -1, q = 0;
		
		for (int i = 0; i < count.length; i++) {
			long x = first[i];
			for (int j = 0; j < count[i]; j++) {
				if (p == x) {
					q++;
				}else {
					if (q == 0) {
						q = 1;
						p = x;
					}else {
						q--;
					}
				}
				x = (x * mult[i] + add[i]) & (M-1);	
			}
		}
		
		int n = 0, c = 0;
		
		for (int i = 0; i < count.length; i++) {
			long x = first[i];
			for (int j = 0; j < count[i]; j++) {
				if (x == p)
					c++;
				n++;	
				x = (x * mult[i] + add[i]) & (M-1);	
			}
		}
		
		if (c > n/2) {
			if (n % 1 == 0)
				return n/2 - (c - n/2 -1);
			else
				return n/2 - (c - n/2);	
		}else
			return n/2;
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new EllysPairing().getMax(16, new int[]{4, 7}, new int[]{5, 3}, new int[]{2, 3}, new int[]{1, 0});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 5;
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
		answer = new EllysPairing().getMax(8, new int[]{6, 4, 3}, new int[]{0, 3, 2}, new int[]{3, 7, 5}, new int[]{0, 3, 2});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 5;
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
		answer = new EllysPairing().getMax(128, new int[]{42, 13, 666, 17, 1337, 42, 1}, new int[]{18, 76, 3, 122, 0, 11, 11}, new int[]{33, 17, 54, 90, 41, 122, 20}, new int[]{66, 15, 10, 121, 122, 1, 30});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 1059;
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
		answer = new EllysPairing().getMax(1048576, new int[]{4242, 42, 9872, 13, 666, 21983, 17, 1337, 42, 1}, new int[]{19, 18, 76, 42, 3, 112, 0, 11, 11, 12}, new int[]{27, 33, 10, 8, 17, 9362, 90, 41, 122, 20}, new int[]{98, 101, 66, 15, 10, 144, 3, 1, 5, 1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 16232;
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
		answer = new EllysPairing().getMax(1073741824, new int[]{894602, 946569, 887230, 856152, 962583, 949356, 904847, 829100, 842183, 958440, 811081, 864078, 809209, 938727, 949135, 892809, 816528, 961237, 979142, 890922}, new int[]{844085078, 898937259, 243490172, 887804102, 187696417, 156820442, 237600210, 618812924, 153000239, 912364033, 254936966, 650298774, 982988140, 649258331, 566444626, 201481721, 492943390, 1061953081, 492672963, 960519711}, new int[]{1036482037, 583219072, 819168094, 253755052, 548208982, 401830167, 638626082, 43642932, 123607749, 485521178, 860368129, 30334704, 219771462, 733375600, 130839219, 415503960, 294132484, 1044831462, 256910484, 198852170}, new int[]{889169006, 604831366, 967292994, 980686280, 844875791, 1027687492, 357734882, 295879743, 48284748, 421729100, 1049536313, 327207332, 948053446, 271229570, 664579359, 795815285, 842856528, 876662975, 675611938, 634229925});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 8971965;
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
