package Month03.Week04;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11404 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		StringTokenizer st;
		int[][] distance = new int[N + 1][N + 1]; // 0 dummy

		int INF = Integer.MAX_VALUE;

		for (int i = 1; i < N + 1; i++) {
			Arrays.fill(distance[i], INF);
			distance[i][i] = 0;
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());

			distance[s][e] = Math.min(distance[s][e], cost);

		}

		for (int k = 1; k < N + 1; k++) {
			for (int s = 1; s < N + 1; s++) {
				for (int e = 1; e < N + 1; e++) {
					if (distance[s][k] + distance[k][e] < 0)
						continue;
					distance[s][e] = Math.min(distance[s][e], distance[s][k] + distance[k][e]);
				}
			}
		}
		for (int s = 1; s < N + 1; s++) {
			for (int e = 1; e < N + 1; e++) {
				int output = distance[s][e];
				if (output == INF) {
					System.out.print(0 + " ");
					continue;
				}
				System.out.print(output + " ");

			}
			System.out.println();
		}

	}

}
