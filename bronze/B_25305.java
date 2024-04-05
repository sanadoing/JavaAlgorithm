import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_25305 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(numbers);

		System.out.println(numbers[N - K]);

	}

}
