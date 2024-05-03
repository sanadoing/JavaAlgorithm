import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_3049 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int top = 1;
		for (int i = N; i >= N - 3; i--) {
			top *= i;
		}

		System.out.println(top / 24);

	}
}
