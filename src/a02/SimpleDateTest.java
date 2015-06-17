package a02;

import java.io.PrintWriter;

public class SimpleDateTest {

	public static void main(String[] args) {

		int[][] testdata = {
			{1, 5, 2013},	
			{82, 38, 2013},	
		};
		PrintWriter out = new PrintWriter(System.out, true);
		for (int i = 0; i < testdata.length; i++) {
			SimpleDate date = new SimpleDate(testdata[i][0], testdata[i][1], testdata[i][2]);
			out.printf("Datum: %s %n", date.toString());
		}
	}
}
