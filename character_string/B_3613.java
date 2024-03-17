package character_string;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_3613 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split("");
    int size = input.length;
    String result = "";
    boolean checkUb = false, chechUC = false;
    boolean underbar = false;
    boolean isCorJava = true;
    // int underbarCnt = 0;

    // 첫번째 _이던가, 마지막이 _ , 첫번째가 대문자인 경우
    if (input[0].equals("_") || input[size - 1].equals("_") || input[0].equals(input[0].toUpperCase())) {
      System.out.println("Error!");
    } else {

      for (int i = 0; i < size; i++) {
        if (input[i].equals("_")) {
          checkUb = true;
          underbar = true;
          if (i + 1 < size && input[i + 1].equals("_")) { // _가 연속으로 나올 경우
            isCorJava = false;
            break;
          }
          continue;
        } else if (input[i].equals(input[i].toUpperCase())) {
          chechUC = true;
          result += "_";
          result += input[i].toLowerCase();
          continue;
        }
        if (underbar) {
          result += input[i].toUpperCase();
          underbar = false;

        } else {
          result += input[i];
        }

      }
      if (checkUb && chechUC) { // _와 대문자가 모두 등장했을 경우
        isCorJava = false;
      }
      if (isCorJava) {
        System.out.println(result);
      } else {
        System.out.println("Error!");
      }
    }

  }

}
