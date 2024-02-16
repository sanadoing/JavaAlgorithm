import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_4012 {

	static int N;
	static int[][] info;
	static int result;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		info = new int[16][16];
		for (int t = 1; t < T + 1; t++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st;
			result = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					info[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			comb(0, 0, new int[N]);
			System.out.println("#" + t + " " + result);

		}

	}

	static void comb(int tgtIdx, int cnt, int[] array) {

		if (cnt == N / 2) {
			result = Math.min(result, check(array));
			return;
		}
		if (tgtIdx == N)
			return;
		array[tgtIdx] = 1;
		comb(tgtIdx + 1, cnt + 1, array);
		array[tgtIdx] = 0;
		comb(tgtIdx + 1, cnt, array);
	}

	static int check(int[] array) {
		boolean flag;
		int s1 = 0;
		int s2 = 0;
		for (int i = 0; i < N; i++) {
			if (array[i] == 1) {
				flag = true;
			} else {
				flag = false;
			}
			for (int j = 0; j < N; j++) {
				if (flag && array[j] == 1) {
					s1 += info[i][j];
				}
				if (!flag && array[j] == 0) {
					s2 += info[i][j];
				}
			}
		}
		return Math.abs(s1 - s2);
	}

}
