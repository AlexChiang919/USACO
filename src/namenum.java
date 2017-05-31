/*
ID: agentle1
PROG: namenum
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 * @author Alex Chiang
 *
 */
public class namenum {

	private static BufferedReader scan;
	private static PrintWriter out;
	private static Set<String> dictionary;
	
	private static HashMap<Integer, ArrayList<Character>> map = new HashMap<Integer, ArrayList<Character>>(); 
	
	public static void main(String[] args) throws IOException {
		setup();
		scan = new BufferedReader(new FileReader(namenum.class.getSimpleName() + ".in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter(namenum.class.getSimpleName() + ".out")));
		BufferedReader df = new BufferedReader(new FileReader("dict.txt"));
		Set<String> dict = new HashSet<String>();
		dictionary = dict;
		while (df.ready())
			dict.add(df.readLine());
		df.close();
		long serial = Long.parseLong(scan.readLine());
		Set<String> possible = generatePossible(serial);
		boolean none = true;
		for (String s : possible)
			if (dict.contains(s)) {
				none = false;
				printLine(s);
			}
		if (none)
			printLine("NONE");
		out.close();
		scan.close();
	}
	
	/*
	 *  2: A,B,C     5: J,K,L    8: T,U,V
     *  3: D,E,F     6: M,N,O    9: W,X,Y
     *  4: G,H,I     7: P,R,S
	 */
	public static void setup() {
		char c = 'A';
		for (int i = 2; i <= 9; i++) {
			ArrayList<Character> set = new ArrayList<Character>();
			for (int j = 0; j < 3; j++) {
				set.add(c++);
				if (c == 'Q' || c == 'Z')
					c++;
			}
			map.put(i, set);
		}
	}
	
	public static Set<String> generatePossible(long number) {
		Set<String> possible = new TreeSet<String>();
		for (char c : map.get(Integer.parseInt("" + String.valueOf(number).charAt(0))))
			recur(number, possible, 1, new StringBuilder("" + c));
		return possible;
	}
	
	public static void recur(long number, Set<String> possible, int i, StringBuilder current) {
		if (i == String.valueOf(number).length()) {
			if (!possible.contains(current.toString()) && dictionary.contains(current.toString()))
				possible.add(current.toString());
		} else {
			for (char c : map.get(Integer.parseInt("" + String.valueOf(number).charAt(i))))
				recur(number, possible, i + 1, current.append(c));
		}
	}
	
	public static void print(Object... o) {
		for (Object obj : o) {
			out.print(obj);
		}
	}

	public static void printLine(Object... o) {
		if (o.length <= 0) {
			out.println();
			return;
		}
		for (Object obj : o) {
			out.println(obj);
		}
	}

	public static void printF(boolean newLine, String format, Object... o) {
		out.printf(format + ((newLine) ? "\n" : ""), o);
	}

}
