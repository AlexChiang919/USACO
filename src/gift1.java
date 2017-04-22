/*
ID: agentle1
PROG: gift1
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
public class gift1 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(gift1.class.getName() + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(gift1.class.getName() + ".out")));
		HashMap<String, Integer> banks = new HashMap<String, Integer>();
		int times = Integer.parseInt(f.readLine());
		String[] names = new String[times];
		int i = 0;
		while (times-- > 0) {
			String name = f.readLine();
			banks.put(name, 0);
			names[i++] = name;
		}
		String giver = f.readLine();
		String trans = f.readLine();
		while (f.ready()) {
			StringTokenizer st = new StringTokenizer(trans);
			int money = Integer.parseInt(st.nextToken());
			int npi = Integer.parseInt(st.nextToken());
			banks.put(giver, banks.get(giver) - money);
			if (npi != 0) {
				int divided = money / npi;
				if (money % npi != 0)
					banks.put(giver, banks.get(giver) + (money % npi));
				for (int a = 0; a < npi; a++) {
					String taker = f.readLine();
					banks.put(taker, banks.get(taker) + divided);
				}
			}
			giver = f.readLine();
			trans = f.readLine();
		}
		for (i = 0; i < names.length; i++) {
			String s = names[i];
			out.println(s + " " + banks.get(s));
		}
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
