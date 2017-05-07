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

/**
 * 
 * @author antonio081014
 *
 */
public class milk2 {

	public static void main(String[] args) throws IOException {
		BufferedReader f = new BufferedReader(new FileReader(milk2.class.getName() + ".in"));
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(milk2.class.getName() + ".out")));
		int N = Integer.parseInt(f.readLine());
		int[] count = new int[1000001];
		int startTime = 1000000;
        int endTime = 0;
        for (int i = 0; i < N; i++) {
            String[] strs = f.readLine().split("\\s");
            int start = Integer.parseInt(strs[0]);
            int end = Integer.parseInt(strs[1]);
            startTime = Math.min(start, startTime);
            endTime = Math.max(end, endTime);
            for (int k = start; k < end; k++)
                count[k]++;
        }
        int maxTime1 = 0;
        int maxTime2 = 0;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = startTime; i < endTime; i++) {
            if (count[i] > 0) {
                tmp1++;
                tmp2 = 0;
            }
            else {
                tmp2++;
                tmp1 = 0;
            }

            maxTime1 = Math.max(maxTime1, tmp1);
            maxTime2 = Math.max(maxTime2, tmp2);
        }
        out.write("" + maxTime1 + " " + maxTime2 + "\n");
        f.close();
        out.close();
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
