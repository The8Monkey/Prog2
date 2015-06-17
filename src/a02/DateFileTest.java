package a02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class DateFileTest {
	public static void main(String[] args){
		PrintWriter out = new PrintWriter(System.out, true);
		FileReader fr = null;
		Scanner in = new Scanner(openFile(fr,"./Test/a02/testeingabe"));
		testDateFile(in, out);
		in.close();
	}
	public static void testDateFile(Scanner in, PrintWriter out){
		while(in.hasNext()){
			int day = in.nextInt();
			if(!in.hasNext()){
				break;
			}
			int month = in.nextInt();
			if(!in.hasNext()){
				break;
			}
			int year = in.nextInt();
			try {
				Date date = new Date(day, month, year);
				printDate(date,out);
			} catch (IlligalDateException e) {
				printWrongDate(out, day, month, year);
				System.out.printf(": "+e.getMessage()+"%n");
			}
		}
	}
	public static FileReader openFile(FileReader fr, String path){
		try{
			fr = new FileReader(path);
		}catch (FileNotFoundException e){
			System.err.println("File not found!");
		}
		return fr;
	}
	public static void printWrongDate(PrintWriter out,int day, int month, int year) {
		out.printf("%-9s "+"Datum: "+"%02d"+ '.' + "%02d"+ '.' + "%04d","falsches", day, month, year);
	}
	public static void printDate(Date d, PrintWriter out){
		out.printf("%-9s "+ "Datum: "+d.toString()+"%n","korrektes");
	}
}
