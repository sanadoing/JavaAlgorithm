import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;

public class B_11265 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		long[][] distance = new long[N + 1][N + 1]; // 0 dummy
		for (int s = 1; s <= N; s++) {
			st = new StringTokenizer(br.readLine());
			for (int e = 1; e <= N; e++) {
				distance[s][e] = Integer.parseInt(st.nextToken());
			}
		}

		for (int m = 1; m <= N; m++) {
			for (int s = 1; s <= N; s++) {
				for (int e = 1; e <= N; e++) {
					distance[s][e] = Math.min(distance[s][e], distance[s][m] + distance[m][e]);
				}
			}
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			long t = Integer.parseInt(st.nextToken());
			if (distance[s][e] <= t) {
				System.out.println("Enjoy other party");
			} else {
				System.out.println("Stay here");
			}
		}

	}

}
