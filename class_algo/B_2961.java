import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2961 {

	static int[][] foods;
	static int COUNT;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		COUNT = 1 << N;
		foods = new int[N][2];
		int result = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			foods[i][0] = Integer.parseInt(st.nextToken());
			foods[i][1] = Integer.parseInt(st.nextToken());

		}

		for (int i = 1; i < COUNT; i++) {
			int sour = 1, bitter = 0;
			for (int j = 0; j < N; j++) {
				if ((i & 1 << j) != 0) {
					sour *= foods[j][0];
					bitter += foods[j][1];
				}

			}
			result = Math.min(result, Math.abs(sour - bitter));

		}
		System.out.println(result);
	}

}
