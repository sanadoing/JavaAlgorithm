import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_8958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		String str;
		int result, temp;
		for (int i = 0; i < T; i++) {
			result = 0;
			str = br.readLine();
			temp = 0;
			for (int j = 0; j < str.length(); j++) {
				if (str.charAt(j) == 'O') {
					temp += 1;
					result += temp;
				} else {

					temp = 0;
				}
			}
			System.out.println(result);
		}
	}

}
