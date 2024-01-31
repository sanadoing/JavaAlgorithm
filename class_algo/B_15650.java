package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_15650 {

	static int N, M;
	static int[] tgt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		M = Integer.parseInt(str[1]);
		tgt = new int[M];

		comb(1, 0);

	}

	static void comb(int srcIdx, int tgtIdx) {
		if (tgtIdx == M) {
			for (int i = 0; i < M; i++) {
				System.out.print(tgt[i] + " ");
			}
			System.out.println();
			return;
		}
		if (srcIdx == N + 1)
			return;
		tgt[tgtIdx] = srcIdx;

		comb(srcIdx + 1, tgtIdx + 1);
		comb(srcIdx + 1, tgtIdx);
	}

}
