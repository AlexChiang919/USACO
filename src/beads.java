/*
ID: agentle1
PROG: beads
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
public class beads {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(beads.class.getName() + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(beads.class.getName() + ".out")));
		int b = Integer.parseInt(f.readLine());
		String neck = f.readLine();
		char[] beads = (neck + neck + neck).toCharArray();
		int most = 0;
		for (int i = b; i < 2 * b; i++) {
			int current = 0;
			char left = 'w';
			for (int a = i; a >= 0; a--) {
				if (left == 'w' && beads[a] != 'w') { 
					left = beads[a];
					current++;
				} else {
					if (beads[a] == left || beads[a] == 'w')
						current++;
					else
						break;
				}
			}
			char right = 'w';
			if (left == 'r')
				right = 'b';
			else if (left == 'b')
				right = 'r';
			for (int c = i + 1; c < beads.length; c++) {
				if (right == 'w' && beads[c] != 'w') { 
					right = beads[c];
					current++;
				} else {
					if (beads[c] == right || beads[c] == 'w')
						current++;
					else
						break;
				}
			}
			if (current > most)
				most = current;
		}
		out.println((most >= b) ? b : most);
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
