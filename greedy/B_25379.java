

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_25379 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] numbers = new int[N];
		
		
		for (int i = 0; i < N; i++) {
			numbers[i] = Integer.parseInt(st.nextToken());
		}
		
		int even_left = 0; 
		int odd_right = N-1;
		int result1 = 0;

		int even_right = 0; 
		int odd_left = N-1;
    int result2 = 0;
		
		for (int i = 0; i < N/2; i++) {
      
      // 왼(짝) - 오(홀) 
			if(numbers[i]%2 == 0) {
				even_left ++;
			}else if(numbers[N-i-1]%2 == 1) {
				odd_right ++ ;
			}
      // 오(짝) - 왼(홀) 
      if(numbers[i]%2 == 0) {
				
			}else if(numbers[N-i-1]%2 == 1) {
				
			}
		}

	}

}