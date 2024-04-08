import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_11501 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    for (int t = 1; t <= T; t++) {
      int N = Integer.parseInt(br.readLine());

      long[] numbers = new long[N];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        numbers[i] = Long.parseLong(st.nextToken());
      }

      long max = 0;
      long result = 0;
      for (int i = N - 1; i >= 0; i--) {
        max = Math.max(max, numbers[i]);
        result += (max - numbers[i]);
      }
      System.out.println(result);
    }

  }
}
