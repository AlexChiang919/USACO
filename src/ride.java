/*
ID: agentle1
PROG: ride
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author Alex Chiang
 *
 */
public class ride {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader("ride.in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ride.out")));
		String a = f.readLine();
		String b = f.readLine();
		long aa = 1;
		long bb = 1;
		for (int i = 0; i < a.length(); i++)
			aa *= (int) (a.charAt(i) - 'A' + 1);
		for (int i = 0; i < b.length(); i++)
			bb *= (int) (b.charAt(i) - 'A' + 1);
		out.println((aa % 47 == bb % 47) ? "GO" : "STAY");
		out.close();
		f.close();
	}

	public static void print(Object... o) {
		for (Object obj : o) {
			System.out.print(obj);
		}
	}

	public static void printLine(Object... o) {
		if (o.length <= 0) {
			System.out.println();
			return;
		}
		for (Object obj : o) {
			System.out.println(obj);
		}
	}

	public static void printF(boolean newLine, String format, Object... o) {
		System.out.printf(format + ((newLine) ? "\n" : ""), o);
	}

}
