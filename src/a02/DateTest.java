package a02;

import java.io.PrintWriter;

public class DateTest {
	public static void main(String[] args){
		PrintWriter out = new PrintWriter(System.out, true);
		int[][] testDate={
				{1,5,2013},
				{82,38,2013},
				{32,1,2015},
				{16,12,1992},
				{1,1,3015},
				{1,13,2015}								
			};
		testDate(out, testDate);
	}
	public static void testDate(PrintWriter out, int[][] testDate){
		for (int i = 0; i < testDate.length; i++) {
			try {
				Date date = new Date(testDate[i][0], testDate[i][1], testDate[i][2]);
				printDate(date,out);
			} catch (IlligalDateException e) {
				printWrongDate(out, testDate[i][0], testDate[i][1], testDate[i][2]);
				System.out.printf(": "+e.getMessage()+"%n");
			}
		}
	}
	private static void printWrongDate(PrintWriter out,int day, int month, int year) {
		out.printf("%-9s "+"Datum: "+"%02d"+ '.' + "%02d"+ '.' + "%04d","falsches", day, month, year);
	}
	public static void printDate(Date d, PrintWriter out){
		out.printf("%-9s "+ "Datum: "+d.toString()+"%n","korrektes");
	}
}
