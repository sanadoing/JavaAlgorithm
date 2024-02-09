package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2231 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int temp, generator;
		int ten;
		
		for (int i = 1; i < N; i++) {
			temp = i;
			generator = i;
			ten = 1;
			while(temp<ten) {
				generator+= (temp%ten);
				System.out.print("i "+i +"ten "+ten+"i/ten " + (i/ten));
				ten *= 10;
				
			}
			generator+= i%10;
			System.out.print(" " + i%10+"\n");
			System.out.println(i +" === " + generator);

		}
	}
}