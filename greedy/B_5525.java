import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_5525 {

  static int N, M, cnt;
  static String[] str;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());
    str = br.readLine().split("");
    int answer = 0;

    cnt = 3 + (N - 1) * 2;
    boolean check = false;
    String compareString = "";
    int checkLength = 0;
    for (int i = 0; i < M; i++) {
      if (check) { // 패턴 체크
        if (!compareString.equals(str[i])) {
          checkLength += 1;
          compareString = str[i];
        } else {
          if (checkLength >= cnt) {
            answer += ((checkLength - cnt) / 2 + 1);
          }
          checkLength = 1;
          check = false;
        }

      }
      if(!check) {
        if (str[i].equals("I")) { // 패턴 체크 시작
          check = true;
          compareString = "I";
          checkLength = 1;
        }
      }

    }
    if (checkLength >= cnt) {
      answer += ((checkLength - cnt) / 2 + 1);
    }
    System.out.println(answer);
  }

}
