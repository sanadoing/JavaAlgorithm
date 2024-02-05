import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2577 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int number = 1;
		int[] n = new int[10];
		for (int i = 0; i < 3; i++) {
			number *= Integer.parseInt(br.readLine());
		}
		String str = Integer.toString(number);
		for (int i = 0; i < str.length(); i++) {
			n[str.charAt(i) - '0'] += 1;
		}
		for (int i = 0; i < 10; i++) {
			System.out.println(n[i]);
		}
	}

}
