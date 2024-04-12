package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_7891 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int T = Integer.parseInt(st.nextToken());

    for (int t = 0; t < T; t++) {
      st = new StringTokenizer(br.readLine());
      long N = Long.parseLong(st.nextToken());
      long M = Long.parseLong(st.nextToken());
      System.out.println(N + M);
    }
  }
}
