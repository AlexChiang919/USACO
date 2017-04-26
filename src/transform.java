
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
		if (check90(original, transform))
			printLine(1);
		else if (check180(original, transform))
			printLine(2);
		else if (check270(original, transform))
			printLine(3);
		else if (reflectCheck(original, transform))
			printLine(4);
		else if (comboCheck(original, transform))
			printLine(5);
		else if (sameCheck(original, transform))
			printLine(6);
		else
			printLine(7);
		out.close();
		f.close();
	}

	public static boolean check90(char[][] original, char[][] transformed) {
		int ii = 0, jj = 0;
		for (int i = 0; i < original[0].length; i++) {
			for (int j = original.length - 1; j >= 0; j--) {
				if (transformed[ii][jj] != original[i][j])
					return false;
				jj++;
			}
			ii++;
		}
		return true;
	}

	public static boolean check180(char[][] original, char[][] transformed) {
		for (int r = 0; r < original.length; r++) {
			for (int c = 0; c < original[r].length; c++) {
				if (!(original[r][c] == transformed[original.length - 1 - r][original[r].length - 1 - c]))
					return false;
			}
		}
		return true;
	}

	public static boolean check270(char[][] original, char[][] transformed) {
		char[][] c180 = new char[original.length][original[0].length];
		for (int r = 0; r < original.length; r++) {
			for (int c = 0; c < original[r].length; c++) {
				c180[original.length - 1 - r][original[r].length - 1 - c] = original[r][c];
			}
		}
		return check90(c180, transformed);
	}

	public static boolean reflectCheck(char[][] original, char[][] transformed) {
		for (int i = 0; i < original.length; i++)
			if (!reverseCheck(original[i], transformed[i]))
				return false;
		return true;
	}

	public static boolean comboCheck(char[][] original, char[][] transformed) {
		char[][] reflected = new char[original.length][original[0].length];
		for (int i = 0; i < original.length; i++)
			reflected[i] = new StringBuilder(String.copyValueOf(original[i])).reverse().toString().toCharArray();
		return check90(reflected, transformed) || check180(reflected, transformed) || check270(reflected, transformed);
	}

	public static boolean sameCheck(char[][] original, char[][] transformed) {
		for (int r = 0; r < original.length; r++)
			for (int c = 0; c < original[r].length; c++)
				if (original[r][c] != transformed[r][c])
					return false;
		return true;
	}

	public static boolean reverseCheck(char[] arr1, char[] arr2) {
		return new StringBuilder(String.copyValueOf(arr1)).reverse().toString().equals(String.copyValueOf(arr2));
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
