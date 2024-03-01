package mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_9506 {
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      int N = Integer.parseInt(br.readLine());
      if (N == -1) {
        break;
      }

      cal(N);
    }
    System.out.println(sb);
    ;
  }

  static void cal(int num) {
    int cnt = 0;
    int sum = 0;
    StringBuilder temp = new StringBuilder();
    sb.append("");
    for (int i = 1; i < num; i++) {
      if (num % i == 0) {
        temp.append(i).append(" + ");
        cnt += 1;
        sum += i;
      }
    }
    if (cnt < 0 || sum != num) {
      sb.append(num).append(" is NOT perfect.\n");
    }else{
      sb.append(num).append(" = ");
      temp.replace(temp.length() - 2, temp.length(), "");
      sb.append(temp).append("\n");
    }
 
  }

}
