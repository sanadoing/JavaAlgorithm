package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11659 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String [] str2 = new String[2];
		str = br.readLine();
		st = new StringTokenizer(str);
		int s, e;
		
		int [] numbers = new int [N+1];
		
		for (int i = 1; i < N+1; i++) {
			numbers[i] = numbers[i-1]+Integer.parseInt(st.nextToken());
		}
		System.out.println(Arrays.toString(numbers));
		for (int i = 0; i < M; i++) {
			str2 = br.readLine().split(" ");
			
			System.out.println(numbers[Integer.parseInt(str2[1])]-numbers[Integer.parseInt(str2[0])]);
		}
	}

}
