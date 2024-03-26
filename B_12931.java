
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_12931 {

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine());
    int[] numbers = new int[N];
    int minN = Integer.MAX_VALUE;

    for (int i = 0; i < N; i++) {
      numbers[i] = Integer.parseInt(st.nextToken());
      minN = Math.min(minN, numbers[i]);
    }

    int result = 0;

    System.out.println(Math.log(100) / Math.log(2));

    System.out.println(result);
  }

}
