import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1759_1 {

	static int L, C;
	static String[] alphabet, tgt;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		alphabet = new String[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			alphabet[i] = st.nextToken();
		}
		Arrays.sort(alphabet);
		tgt = new String[L];
		comb(0, 0);
		System.out.println(sb);

	}

	static void comb(int tgtIdx, int srcIdx) {
		if (tgtIdx == L) {
			int vowelCount = 0; // 모음
			int consonantCount = 0; // 자음
			StringBuilder s = new StringBuilder();

			for (int i = 0; i < L; i++) {
				if (tgt[i].equals("a") || tgt[i].equals("e") || tgt[i].equals("i") || tgt[i].equals("o")
						|| tgt[i].equals("u"))
					vowelCount++;
				else
					consonantCount++;
				s.append(tgt[i]);
			}

			if (vowelCount >= 1 && consonantCount >= 2) {
				sb.append(s).append("\n");
			}
			return;
		}
		if (srcIdx == C)
			return;
		tgt[tgtIdx] = alphabet[srcIdx];
		comb(tgtIdx + 1, srcIdx + 1);
		comb(tgtIdx, srcIdx + 1);
	}
}
