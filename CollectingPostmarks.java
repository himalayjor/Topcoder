import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;
 
public class CollectingPostmarks
{
  public int amountOfMoney(int[] prices, int[] have, int[] values, int K)
  {
    int money = 0, all = 0;
    for (int i=0; i<have.length; i++)
      money+=prices[have[i]];
    int n = prices.length;
    for (int i=0; i<n; i++)
      all +=values[i];
    if (all<K) return -1;
    
    pair[] p1, p2;
    
    int n1 = Math.min(n, 16);
    p1 = new pair[1<<n1];
    p2 = new pair[1<<(n-n1)];
    
    for (int i=0; i<(1<<n1); i++)
    {
      int cost=0,value=0;
      for (int j=0; j<n1; j++)
        if ((i&(1<<j))>0)
        {
          cost+=prices[j];
          value+=values[j];
        }
      p1[i] = new pair(cost, value);
    }
    
    for (int i=0; i<(1<<(n-n1)); i++)
    {
      int cost=0,value=0;
      for (int j=0; j<n-n1; j++)
        if ((i&(1<<j))>0)
        {
          cost+=prices[n1+j];
          value+=values[n1+j];
        }
      p2[i] = new pair(cost, value);
    }
    Arrays.sort(p1);
    Arrays.sort(p2);
    int cst = Integer.MAX_VALUE;
    for (int i=p1.length-1; i>=0; i--)
    {
      p1[i].cost = Math.min(p1[i].cost, cst);
      cst = p1[i].cost;
    }
    cst = Integer.MAX_VALUE;
    for (int i=p2.length-1; i>=0; i--)
    {
      p2[i].cost = Math.min(p2[i].cost, cst);
      cst = p2[i].cost;
    }
    int ans = Integer.MAX_VALUE;
    
    int j = p2.length-1;
    for (int i=0; i<p1.length; i++)
    {
      while (j>0&&p1[i].value+p2[j-1].value>=K)
        j--;
      if (p1[i].value+p2[j].value>=K)
        ans = Math.min(ans,p1[i].cost+p2[j].cost);
    }
    return Math.max(ans-money, 0);
  }
  
  class pair implements Comparable<pair>
  {
    int cost, value;
    public pair(int cost, int value)
    {
      this.cost=cost;
      this.value=value;
    }
    public int compareTo(pair o) {
      if (value<o.value) return -1;
      if (value>o.value) return 1;
      if (cost>o.value) return -1;
      if (cost<o.value) return 1;
      return 0;
    }
  }
  public static void main(String[] args)
	{
		long time;
		int answer;
		boolean errors = false;
		int desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new CollectingPostmarks().amountOfMoney(new int[]{2,15}, new int[]{}, new int[]{2,21}, 13);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 15;
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
		answer = new CollectingPostmarks().amountOfMoney(new int[]{9,18,7,6,18}, new int[]{4,0}, new int[]{12,27,10,10,25}, 67);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = 22;
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
		answer = new CollectingPostmarks().amountOfMoney(new int[]{14,14,12,6}, new int[]{3,2,1}, new int[]{19,23,20,7}, 10);
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
		answer = new CollectingPostmarks().amountOfMoney(new int[]{43,33,14,31,42,37,17,42,40,20}, new int[]{6}, new int[]{116,71,38,77,87,106,48,107,91,41}, 811);
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = -1;
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
