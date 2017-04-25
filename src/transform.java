
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

/**
 * 
 * @author Alex Chiang
 *
 */
public class transform {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(transform.class.getName() + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(transform.class.getName() + ".out")));
		int N = Integer.parseInt(f.readLine());
		char[][] original = new char[N][N];
		char[][] transform = new char[N][N];
		for (int i = 0; i < N; i++)
			original[i] = f.readLine().toCharArray();
		for (int i = 0; i < N; i++)
			transform[i] = f.readLine().toCharArray();
		
		out.close();
		f.close();
	}

	public static boolean check90(char[][] original, char[][] transformed) {
		for (int r = 0; r < original.length; r++) {
			for (int c = 0; c < original[r].length; c++) {
				
			}
		}
	}

	public static boolean check180(char[][] original, char[][] transformed) {

	}

	public static boolean check270(char[][] original, char[][] transformed) {

	}
	
	public static boolean reflectCheck(char[][] original, char[][] transformed) {
		
	}
	
	public static boolean comboCheck(char[][] original, char[][] transformed) {
		
	}

	public static boolean sameCheck(char[][] original, char[][] transformed) {
		
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
