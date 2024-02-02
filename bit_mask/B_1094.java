import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_1094 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int bit = 0; bit <= 6; bit++) {
			if ((N & 1 << bit) != 0) {
				result += 1;
			}
		}
		System.out.println(result);


	}

}
