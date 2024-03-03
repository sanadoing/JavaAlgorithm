package mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_10986 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int answer = 0;
    int[] numbersSum = new int[N + 1];
    int sum = 0;
    st = new StringTokenizer(br.readLine());

    for (int i = 1; i <= N; i++) {
      sum += Integer.parseInt(st.nextToken());
      numbersSum[i] = sum;
    }
    for (int i = 1; i <= N; i++) {
      for (int j = i; j <= N; j++) {
        if ((numbersSum[j] - numbersSum[i - 1]) % M == 0)
          answer += 1;
      }

    }
    System.out.println(answer);
  }
}
