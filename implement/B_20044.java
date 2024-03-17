package implement;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_20044 {
  public static void main(String[] args)throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st= new StringTokenizer(br.readLine());
    int[] numbers =new int [N*2];
    for (int i = 0; i < N*2; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
    }
    Arrays.sort(numbers);
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < N; i++) {
      result = Math.min(result, numbers[i]+numbers[N*2-i-1]);
    }
    System.out.println(result);
  }
}
