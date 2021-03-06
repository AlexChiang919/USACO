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
public class Template {

	private static BufferedReader scan;
	private static PrintWriter out;
	
	public static void main(String[] args) throws IOException {
		scan = new BufferedReader(new FileReader(Template.class.getSimpleName() + ".in"));
		out = new PrintWriter(new BufferedWriter(new FileWriter(Template.class.getSimpleName() + ".out")));
		
		out.close();
		scan.close();
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
