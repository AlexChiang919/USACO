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
import java.util.List;
import java.util.Set;

/**
 * 
 * @author Alex Chiang
 *
 */
public class namenum {

	private static BufferedReader scan;
	private static PrintWriter out;
	
	private static HashMap<Integer, ArrayList<Character>> map = new HashMap<Integer, ArrayList<Character>>(); 
	
	public static void main(String[] args) throws IOException {
		setup();
		scan = new BufferedReader(new FileReader(namenum.class.getSimpleName() + ".in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter(namenum.class.getSimpleName() + ".out")));
		printLine(map);
		BufferedReader df = new BufferedReader(new FileReader("dict.txt"));
		Set<String> dict = new HashSet<String>();
		while (df.ready())
			dict.add(df.readLine());
		df.close();
		long serial = Long.parseLong(scan.readLine());
		List<String> possible = generatePossible(serial);
		for (String s : possible)
			if (dict.contains(s))
				printLine(s);
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
	
	public static ArrayList<String> generatePossible(long number) {
		ArrayList<String> possible = new ArrayList<String>();
		int length = String.valueOf(number).length();
		for (int i = 0; i < length; i++) {
			ArrayList<String> p = new ArrayList<String>();
			ArrayList<Character> mini = map.get(Integer.parseInt("" + String.valueOf(number).charAt(i)));
			for (char c : mini)
				;
		}
		
		return possible;
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
