import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1759 {
	static int L, C;
	static String[] words, result;
	static int[] check;
	static String[] vowel = { "a", "e", "i", "o", "u" };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		words = br.readLine().split(" ");
		result = new String[L];
		check = new int[C];
		Arrays.sort(words);

		for (int i = 0; i < C; i++) {
			if (Arrays.asList(vowel).contains(words[i])) {
				check[i] = 0;
			} else {
				check[i] = 1;
			}
		}
		comb(0, 0, 0);
	}

	static void comb(int nowIdx, int tgtIdx, int c) {
		if (tgtIdx == L) {
			if (c < L && 1 < c) {
				for (int i = 0; i < L; i++) {
					System.out.print(result[i]);
				}
				System.out.println();
			}
			return;
		}
		if (nowIdx == C)
			return;
		result[tgtIdx] = words[nowIdx];

		comb(nowIdx + 1, tgtIdx + 1, c + check[nowIdx]);
		comb(nowIdx + 1, tgtIdx, c);

	}

}
