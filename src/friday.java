/*
ID: agentle1
PROG: template
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * 
 * @author Alex Chiang
 *
 */
public class friday {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(friday.class.getName() + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(friday.class.getName() + ".out")));
		int years = f.read();
		int[] occ = new int[7];
		Arrays.fill(occ, 0);
		int day = 2;
		for (int y = 0; y < years; y++) {
			for (int m = 0; m < 12; m++) {
				int days = days(m, y);
				for (int d = 0; d < days; d++) {
					if (d + 1 == 13)
						occ[day]++;
					day++;
					if (day == 7)
						day = 0;
				}
			}
		}
		out.println(Arrays.toString(occ).replaceAll("[\\[\\]]", "").replaceAll("[\\,\\s]+", " "));
		out.close();
		f.close();
	}
	
	public static int days(int month, int year) {
		if (month == 8 || month == 5 || month == 3 || month == 10)
			return 30;
		if (month == 1) {
			if (String.valueOf(year).endsWith("00") && year % 400 == 0)
				return 29;
			else if (!String.valueOf(year).endsWith("00") && year % 4 == 0)
				return 29;
			else
				return 28;
		}
		return 31;
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
