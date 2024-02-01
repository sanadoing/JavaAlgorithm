import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11050 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int temp1 = 1;
		int temp2 = 1;

		for (int i = 0; i < K; i++) {
			if (i < K + 1) {
				temp2 *= (i + 1);
			}
			temp1 *= (N - i);
		}
		System.out.println(temp1 / temp2);
	}

}
