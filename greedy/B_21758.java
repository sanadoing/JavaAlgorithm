import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_21758 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int[] numbers = new int[N];
    long[] sum = new long[N];
    int min = Integer.MAX_VALUE;
    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
      if (i == 0) {
        sum[i] = numbers[i];
      } else {
        sum[i] = sum[i - 1] + numbers[i];
        if (i != N - 1) {
          min = Math.min(min, numbers[i]);
        }
      }
    }
    System.out.println(Arrays.toString(sum));
    long case1 = sum[N - 1] - numbers[0] - numbers[N - 1] - min;
    long case2 = sum[N - 2] - numbers[0] - numbers[1];
    long case3 = sum[N - 3] - numbers[0];
    System.out.println(case1 + " " + case2 + " " + case3);
    long result = Math.max(Math.max(case1, case2), case3);
    System.err.println(result);
  }
}
