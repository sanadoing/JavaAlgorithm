import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_1233 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N, result;
		String now;
		String[] info;
		StringTokenizer st;

		for (int t = 1; t < 11; t++) {
			N = Integer.parseInt(br.readLine());
			info = new String[N + 1];
			result = 1;
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				now = st.nextToken(); // dummy
				info[i] = st.nextToken();

			}
			for (int i = 1; i < N + 1; i++) {
				if (Character.isDigit(info[i].charAt(0))) { // 숫자일 경우
					if (i * 2 > N) {
						continue;
					} else {
						result = 0;
						break;
					}
				} else { // 문자일 경우
					if ((i * 2 + 1) <= N) {
						continue;
					} else {
						result = 0;
						break;
					}
				}
			}
			System.out.println("#" + t + " " + result);
		}

	}

}
