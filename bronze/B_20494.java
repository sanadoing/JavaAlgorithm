package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_20494 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int result = 0;
    for (int i = 0; i < N; i++) {
      result += br.readLine().length();
    }
    System.out.println(result);
  }
}
