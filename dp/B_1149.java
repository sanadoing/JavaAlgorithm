package sw.Week02_04.Day_27;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1149 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][3];

		dp[0][0] = 0;
		dp[0][0] = 1;
		dp[0][0] = 2;

		StringTokenizer st;
		for (int i = 1; i < N + 1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + a;
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + b;
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + c;
		}
		System.out.println(Math.min(dp[N][2], Math.min(dp[N][0], dp[N][1])));
	}

}
