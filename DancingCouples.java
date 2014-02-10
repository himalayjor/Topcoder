import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class DancingCouples
{
	char arr[][];
	int n, m;
	
	int dp[][][];
	int func(int boy, int seG, int K)
	{
		if (boy == n )
			return (K == 0) ? 1 : 0;
				
		if (dp[boy][seG][K] != -1)	
			return dp[boy][seG][K];
		if (K == 0)
			return dp[boy][seG][0] = 1;
		
			
		int ans = 0;	
		ans += func(boy+1, seG, K);
		for (int i = 0; i < m; i++) {
			if (arr[boy][i] == 'Y' && (seG & (1 << i)) == 0 ) {
				ans  += func(boy +1, seG | (1 << i),K-1); 	
			}
		}
		
		return dp[boy][seG][K] = ans;		
	}
	public int countPairs(String[] canDance, int K)
	{
		n = canDance.length;
		m = canDance[0].length();
		arr = new  char[n][];
		for (int i = 0; i < n; i++)
			arr[i] = canDance[i].toCharArray();
		
		dp = new int[n][1<<m][K+1];
		for (int i = 0; i < n; i++) 
			for (int j = 0; j < (1 << m); j++)
				Arrays.fill(dp[i][j], -1);
		
		return func(0, 0, K);												
	}
	
	public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new DancingCouples().countPairs(new String[]{"YYYY",  "YYYY", "YYYY"}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 24;
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
		answer = new DancingCouples().countPairs(new String[]{"YYNN",  "NYYN",  "NNYY"}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 4;
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
		answer = new DancingCouples().countPairs(new String[]{"YY",  "YY",  "YY"}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 0;
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
		answer = new DancingCouples().countPairs(new String[]{"YYNNNN", "NYYNNN", "NNYYNN", "NNNYYN", "NNNNYY", "YNNNNY"}, 3);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 112;
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
