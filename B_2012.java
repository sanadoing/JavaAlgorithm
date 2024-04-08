import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2012 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    long[] numbers = new long[N];
    for (int i = 0; i < N; i++) {
      numbers[i] = Long.parseLong(br.readLine());
    }
    Arrays.sort(numbers);

    long result = 0;
    long rate = 1;
    for (int i = 0; i < N; i++) {
      result += (Math.abs(rate - numbers[i]));

      rate += 1;
    }
    System.out.println(result);

  }
}
