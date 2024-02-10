package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2231 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String str;
		int result;
    boolean flag = false;
		for (int i = 1; i < N; i++) {
			str = i + "";
      result = i;
      for(int j = 0; j<str.length();j++){
        result += str.charAt(j) - '0';
      }
      if(result == N){
        System.out.println(i);
        flag = true;
        break;
      }
		}
    if(!flag){
      System.out.println(0);
    }
	}
}