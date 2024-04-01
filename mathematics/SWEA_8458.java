import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_8458 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		StringTokenizer st;
		for (int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());

			int oddMax = -1;
			int evenMax = -1;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());

				int distance = Math.abs(x) + Math.abs(y);

				if (distance % 2 == 0) {
					evenMax = Math.max(evenMax, distance);
				} else {
					oddMax = Math.max(oddMax, distance);
				}

			}

			int result = -1;

			if (evenMax == 0 && oddMax == -1) {
				result = 0;
			} else if (oddMax != -1 && evenMax != -1) {
				result = -1;
			} else if (oddMax == -1 && evenMax != -1) { // 다 짝수일 때
				int n = 1;
				int sum = 0;
				while (true) {
					sum += n;
					if (sum % 2 == 0 && sum >= evenMax) {
						result = n;
						break;
					}
					n += 1;
				}
			} else if (evenMax == -1 && oddMax != -1) { // 다 홀수일 때
				int n = 1;
				int sum = 0;
				while (true) {
					sum += n;
					if (sum % 2 == 1 && sum >= oddMax) {
						result = n;
						break;
					}
					n += 1;
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

}
