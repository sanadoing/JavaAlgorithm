import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2475 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int result = 0;
		int n;

		for (int i = 0; i < 5; i++) {
			n = Integer.parseInt(st.nextToken());
			result += n * n;
		}
		System.out.println(result % 10);

	}

}
