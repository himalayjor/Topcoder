import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class StringInterspersal
{
	String[] W;
	int n;
	char getMinimum()
	{
		if (W.length == 0)
			return 'a';
			
		Arrays.sort(W, new Comparator<String>(){
			public int compare(String a, String b) {
				String x = a + b;
				String y = b + a;
				return x.compareTo(y);
			}
		});
		
		char ch = W[0].charAt(0);
		if (W[0].length() > 1)
			W[0] = W[0].substring(1);
		else {
			ArrayList<String> arr = new ArrayList<String>();
			for (int i = 1; i < W.length; i++)
				arr.add(W[i]);
			W = arr.toArray(new String[W.length - 1]);	
		}	
		return ch;
	}
	public String minimum(String[] W)
	{
		this.W = W;
		StringBuilder sb = new StringBuilder();
		while (true) {
			char ch = getMinimum();
			if (ch == 'a')
				break;
			sb.append(ch);	
		}
		return sb.toString();
	}
	public static void main(String[] args)
	{
		long time;
		String answer;
		boolean errors = false;
		String desiredAnswer;
		
		
		time = System.currentTimeMillis();
		answer = new StringInterspersal().minimum(new String[]{"DESIGN","ALGORITHM","MARATHON"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "ADELGMAORARISIGNTHMTHON";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new StringInterspersal().minimum(new String[]{"TOMEK","PETR","ACRUSH","BURUNDUK","KRIJGERTJE"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "ABCKPERIJGERRTJETOMEKTRURUNDUKUSH";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new StringInterspersal().minimum(new String[]{"CCCA","CCCB","CCCD","CCCE"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "CCCACCCBCCCCCCDE";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new StringInterspersal().minimum(new String[]{"BKSDSOPTDD","DDODEVNKL","XX","PODEEE","LQQWRT"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "BDDKLODEPODEEEQQSDSOPTDDVNKLWRTXX";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new StringInterspersal().minimum(new String[]{"TOPCODER","BETFAIR","NSA","BT","LILLY"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "BBELILLNSATFAIRTOPCODERTY";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new StringInterspersal().minimum(new String[]{"QITHSQARQV","BYLHVGMLRY","LKMAQTJEAM","AQYICVNIKK","HKGZZFFEWC"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "ABHKGLKMAQIQQTHSQARQTJEAMVYICVNIKKYLHVGMLRYZZFFEWC";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new StringInterspersal().minimum(new String[]{"XHCYBTUQUW","EKBISADSSN","LOOISPOFAK","MIXBDHPJUQ","BNMNDHMOTC"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "BEKBILMINMNDHMOOIOSADSPOFAKSSNTCXBDHPJUQXHCYBTUQUW";
		System.out.println("Your answer:");
		System.out.println("\t\"" + answer + "\"");
		System.out.println("Desired answer:");
		System.out.println("\t\"" + desiredAnswer + "\"");
		if (!answer.equals(desiredAnswer))
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
