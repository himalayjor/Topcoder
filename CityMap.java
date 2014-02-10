import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class CityMap
{
	public String getLegend(String[] cityMap, int[] POIs)
	{
		int n = cityMap.length;
		int m = cityMap[0].length();
		int cou[] = new int[26];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				char ch = cityMap[i].charAt(j);
				if (ch != '.') {
					cou[ch-'A']++;
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < POIs.length; i++) {
			for (int j = 0; j < 26; j++) {
				if (cou[j] == POIs[i]) {
					char ch = (char)('A' + j);
					sb.append(ch);
					cou[j] = 0;
					break;
				}
			}
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
		answer = new CityMap().getLegend(new String[]{"M....M", "...R.M", "R..R.R"}, new int[]{3, 4});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "MR";
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
		answer = new CityMap().getLegend(new String[]{"XXXXXXXZXYYY"}, new int[]{1, 8, 3});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "ZXY";
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
		answer = new CityMap().getLegend(new String[]{"...........", "...........", "...........", "..........T"}, new int[]{1});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "T";
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
		answer = new CityMap().getLegend(new String[]{"AIAAARRI.......GOAI.", ".O..AIIGI.OAAAGI.A.I", ".A.IAAAARI..AI.AAGR.", "....IAI..AOIGA.GAIA.", "I.AIIIAG...GAR.IIAGA", "IA.AOA....I....I.GAA", "IOIGRAAAO.AI.AA.RAAA", "AI.AAA.AIR.AGRIAAG..", "AAAAIAAAI...AAG.RGRA", ".J.IA...G.A.AA.II.AA"}, new int[]{16,7,1,35,11,66});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = "GOJIRA";
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
