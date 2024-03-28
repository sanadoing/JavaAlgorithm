package Month03.Week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1263 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] distance = new int[N + 1][N + 1];
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					int input = Integer.parseInt(st.nextToken());
					if (input == 0 && s != e) {
						distance[s][e] = Integer.MAX_VALUE;
						continue;
					}
					distance[s][e] = input;
				}
			}
			for (int m = 0; m <= N; m++) {
				for (int s = 1; s <= N; s++) {
					for (int e = 1; e <= N; e++) {
						int temp = distance[s][m] + distance[m][e];
						if (temp < 2)
							continue;
						distance[s][e] = Math.min(temp, distance[s][e]);
					}
				}
			}

			int result = Integer.MAX_VALUE;

			for (int s = 1; s <= N; s++) {
				int tempSum = 0;
				for (int e = 1; e <= N; e++) {
					tempSum += distance[s][e];
				}
				result = Math.min(result, tempSum);
			}
			System.out.println("#" + t + " " + result);
		}

	}

}
