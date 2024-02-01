package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12891 {
	static int[] check = new int[4];
	static int[] now = new int[4];
	static int result = 0;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String s = br.readLine();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 4; i++) {
			check[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < P; i++) {
			count(s.charAt(i), 1);
		}

		dna_check();
		int start = 0;
		int end = P - 1;

		for (int i = 0; i < (S - P); i++) {
			start += 1;
			end += 1;
			count(s.charAt(start - 1), -1);
			count(s.charAt(end), 1);
			dna_check();
		}
		System.out.println(result);
	}

	static void count(char s, int p_or_m) {

		int temp = 1 * p_or_m;
		if (s == 'A') {
			now[0] += temp;
		} else if (s == 'C') {
			now[1] += temp;
		} else if (s == 'G') {
			now[2] += temp;
		} else if (s == 'T') {
			now[3] += temp;
		}
	}

	static void dna_check() {
		boolean flag = true;
		for (int j = 0; j < 4; j++) {
			if (now[j] < check[j]) {
				flag = false;
				break;
			}
		}
		if (flag) {
			result += 1;
		}
	}

}
