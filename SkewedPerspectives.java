import java.util.*;
import java.util.regex.*;
import java.text.*;
import java.math.*;
import java.awt.geom.*;

public class SkewedPerspectives
{
	boolean func(int[] height, int[] cb, int b)
	{
		int w = height.length-1;
		boolean valid = true;
		int tot = cb[0] + cb[1] + cb[2] + 2*b;
		
		for (int i = 1; valid && i <= w; i++) {
			tot -= height[i];
		}
		return (tot >= 0);
	}
	public String[] areTheyPossible(int[] cubes, int B, int w, String[] views)
	{
		String[] ans = new String[views.length];
		for (int j = 0; j < views.length; j++) {
			int cb[] = cubes.clone();
			int b = B;
			String S = views[j];
			int height[] = new int[w+1];
			int count = 1;
			boolean valid = true;
			int h = 0;
			
			for (int i = 0; valid && i < S.length(); i++) {
				if (S.charAt(i) != 'b')  {
					h++;
					int tmp = S.charAt(i) - '0';
					cb[tmp]--;
					if (cb[tmp] < 0) 
						valid = false;
				}else if (S.charAt(i) == 'b') {
					int len = 0;
					while (i < S.length() && S.charAt(i) == 'b') {
						len++;
						i++;
					}
					h += len;
					if (len % 2 == 0) {
						
						b -= len/2;
						if (b < 0)
							valid = false;
					}else if (h > 0) {
						height[count] = h-1;
						count++;
						if (count > w)
							valid = false;
					}else {
						height[count] = 1;
						count++;
						h--;
						if (count > w)
							valid = false;
					}				
				}
				
			}
			if (valid) {
					valid = func(height, cb, b);
			}
			ans[j] = (valid) ? "valid" : "invalid";
		}
		return ans;
	}
	
	public static void main(String[] args)
	{
		long time;
		String[] answer;
		boolean errors = false;
		String[] desiredAnswer;
		
		boolean same;
		
		time = System.currentTimeMillis();
		answer = new SkewedPerspectives().areTheyPossible(new int[]{1,1,1}, 1, 2, new String[]{ "012", "012bb", "bb0", "21bb", "21b", "1bb20" });
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"valid", "valid", "valid", "valid", "valid", "valid" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new SkewedPerspectives().areTheyPossible(new int[]{0,1,0}, 3, 2, new String[]{"b","bb","bbb","bbbb","bbbbb","bbbbbb", "1", "1b","1bb","1bbb","1bbbb","1bbbbb","1bbbbbb", "b1","b1b","b1bb","b1bbb","b1bbbb","b1bbbbb", "bb1","bb1b","bb1bb","bb1bbb","bb1bbbb", "bbb1","bbb1b","bbb1bb","bbb1bbb", "bbbb1","bbbb1b","bbbb1bb", "bbbbb1","bbbbb1b", "bbbbbb1" });
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"invalid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "valid", "invalid", "invalid", "invalid", "invalid", "invalid", "invalid", "valid", "valid", "valid", "invalid", "valid", "invalid", "invalid", "invalid", "invalid", "valid", "invalid", "valid", "invalid", "invalid", "valid" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new SkewedPerspectives().areTheyPossible(new int[]{100,0,0}, 20, 3, new String[]{"00000000000000000000000000000000000000000000000000", "00000000000000000000000000000000000b00000000000000", "0000000000000000000000000000000000000000000000000b", "bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb0000000000000"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"valid", "valid", "valid", "valid" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new SkewedPerspectives().areTheyPossible(new int[]{5,6,3}, 0, 1, new String[]{"00000111111222", "0000111111222", "0000011111222", "000001111111222", "0000011111122", "b"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"valid", "valid", "valid", "invalid", "valid", "invalid" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new SkewedPerspectives().areTheyPossible(new int[]{100,100,100}, 100, 50, new String[]{"2", "bb1b012012012012012012012", "bb1b012012012012012012012b", "bb1b012012012b012b012b012012b", "bb1b0b1b2b0b1b2b0b1b2bb012b012b012012b", "b1b0b1b2b0b1b2b0b1b2bb012b012b012012b", "bbb1b012012012012012012012"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"valid", "valid", "valid", "valid", "valid", "invalid", "valid" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new SkewedPerspectives().areTheyPossible(new int[]{0,0,0}, 0, 1, new String[]{"0", "bb"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"invalid", "invalid" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
		{
			errors = true;
			System.out.println("DOESN'T MATCH!!!!");
		}
		else
			System.out.println("Match :-)");
		System.out.println();
		time = System.currentTimeMillis();
		answer = new SkewedPerspectives().areTheyPossible(new int[]{3,0,0}, 4, 3, new String[]{"00b0b", "bbbbbbbb", "000b"});
		System.out.println("Time: " + (System.currentTimeMillis()-time)/1000.0 + " seconds");
		desiredAnswer = new String[]{"invalid", "valid", "valid" };
		System.out.println("Your answer:");
		if (answer.length > 0)
		{
			System.out.print("\t{ \"" + answer[0] + "\"");
			for (int i=1; i<answer.length; i++)
				System.out.print(",\n\t  \"" + answer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		System.out.println("Desired answer:");
		if (desiredAnswer.length > 0)
		{
			System.out.print("\t{ \"" + desiredAnswer[0] + "\"");
			for (int i=1; i<desiredAnswer.length; i++)
				System.out.print(",\n\t  \"" + desiredAnswer[i] + "\"");
			System.out.println(" }");
		}
		else
			System.out.println("\t{ }");
		same = desiredAnswer.length == answer.length;
		for (int i=0; i<answer.length && same; i++)
			if (!answer[i].equals(desiredAnswer[i]))
				same = false;
		if (!same)
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
