import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_17626 {
	static int n;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		if (n == 1) {
			System.out.println(1);
		} else {
			int[] dp = new int[n + 1];
			int temp;
			dp[0] = 0;
			dp[1] = 1;
			for (int i = 2; i < n + 1; i++) {
				temp = Integer.MAX_VALUE;
				for (int j = 1; j * j <= i; j++) {
					temp = Math.min(temp, dp[i - j * j]);
				}
				dp[i] = temp + 1;
			}

			System.out.println(dp[n]);
		}

	}

}
