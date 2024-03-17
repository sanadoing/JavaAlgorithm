import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_11568_1 {
  static int N;
  static int[] numbers;
  static int result = 0;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    numbers = new int[N];
    int[] dp = new int[N + 1];
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    dp[0] = 0;
    for (int i = 0; i < N; i++) {
      int now = numbers[i];
      int temp = 0;
      for (int j = 0; j < i; j++) {
        if (numbers[j] < now) {
          temp = Math.max(temp, dp[j]);
        }
      }
      dp[i] = temp + 1;
      result = Math.max(dp[i], result);
    }
    System.out.println(result);
  }

}
