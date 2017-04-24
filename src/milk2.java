/*
ID: agentle1
PROG: milk2
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * 
 * @author Alex Chiang
 *
 */
public class milk2 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(milk2.class.getName() + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(milk2.class.getName() + ".out")));
		int T = Integer.parseInt(f.readLine());
		HashMap<Integer, Long> start = new HashMap<Integer, Long>();
		HashMap<Integer, Long> end = new HashMap<Integer, Long>();
		long begin = 10000000, fin = 0;
		for (int i = 0; i < T; i++) {
			StringTokenizer st = new StringTokenizer(f.readLine());
			long s = Long.parseLong(st.nextToken()), e = Long.parseLong(st.nextToken());
			start.put(i, s);
			end.put(i, e);
			if (s < begin)
				begin = s;
			if (e > fin)
				fin = e;
		}
		long mostyes = -1;
		long mostno = -1;
		long cy = 0;
		long cn = 0;
		for (long st = begin; st <= fin; st++) {
			if (check(start, end, st)) {
				if (mostno < cn) {
					mostno = cn;
					printLine(mostno + " No " + st);
					cn = 0;
					cy = 0;
				}
				cy++;
			} else {
				if (mostyes < cy) {
					mostyes = cy;
					printLine(mostyes + " Yes " + st);
					cy = 0;
					cn = 0;
				}
				cn++;
			}
		}
		if (mostyes < cy) {
			mostyes = cy;
			cy = 0;
		}
		if (mostno < cn) {
			mostno = cn;
			cn = 0;
		}
		out.println(mostyes + " " + mostno);
		out.close();
		f.close();
	}
	
	public static boolean check(HashMap<Integer, Long> start, HashMap<Integer, Long> end, long time) {
		for (Integer i : start.keySet()) {
			if (time >= start.get(i) && time < end.get(i))
				return true;
		}
		return false;
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
