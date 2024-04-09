package a_samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_5373_큐빙 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    String[] color = new String[] { "w", "g", "r", "b", "o", "y" };
    for (int t = 0; t < T; t++) {

      // 큐브 초기화
      String[] Qube = new String[56];

      int idx = 0;
      for (int c = 0; c < 56; c++) {
        if(c % 9 == 0){
          idx += 1;
        }
        Qube[c] = color[idx];
      }

      int N = Integer.parseInt(br.readLine());

      int[][] changeList = new int[]


      StringTokenizer st = new StringTokenizer(br.readLine());
      for (int i = 0; i < N; i++) {
        String command = st.nextToken();
        System.out.println(command);

        char c = command.charAt(0);
        char d = command.charAt(1);

        if (c == 'L') {
          if (d == '-') {
          

          } else {

          }

        } else if (c == 'F') {
          if (d == '-') {

          } else {

          }
        } else if (c == 'R') {
          if (d == '-') {

          } else {

          }
        } else if (c == 'U') {
          if (d == '-') {

          } else {

          }
        } else if (c == 'B') {
          if (d == '-') {

          } else {

          }
        } else if (c == 'D') {
          if (d == '-') {

          } else {

          }
        }

      }

    }
  }
}
