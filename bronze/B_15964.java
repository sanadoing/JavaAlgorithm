package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_15964 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    long A = Integer.parseInt(st.nextToken());
    long B = Integer.parseInt(st.nextToken());

    System.out.println((A + B) * (A - B));
  }
}
