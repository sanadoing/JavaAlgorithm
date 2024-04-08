package a_samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_5373_큐빙 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());
    String[] color = new String[] { "g", "r", "b", "w", "o", "y" };
    for (int t = 0; t < T; t++) {

      // 큐브 초기화
      String[][][] Qube = new String[5][3][3];
      for (int c = 0; c < 5; c++) {
        for (int i = 0; i < 3; i++) {
          for (int j = 0; j < 3; j++) {
            Qube[c][i][j] = color[c];
          }
        }
      }

      int N = Integer.parseInt(br.readLine());

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
