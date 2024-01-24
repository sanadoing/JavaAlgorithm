package now;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class test {
  public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String s = br.readLine();
    String arr[] = s.split("");
    // 팰린드롬 조건
    // #1 - aaa (모든 글자가 같음) - 팰린드롬 O ->false
    // #2 - abc (모든 글자가 다름) - 팰린드롬 X -> true
    // #3 - aabaa (좌우 대칭) - 팰린드롬 O - (len-1) -> true

    Set<String> arr_toset = new LinkedHashSet<>(Arrays.asList(arr));
    if (arr_toset.size() == 1) {
      System.out.println(-1);
    } else {

      if (arr[0].equals(arr[arr.length - 1])) {
        System.out.println(arr.length - 1);
      } else {

        System.out.println((arr.length));
      }

    }

  }
}
