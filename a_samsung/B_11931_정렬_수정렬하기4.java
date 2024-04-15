package a_samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class B_11931_정렬_수정렬하기4 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    ArrayList<number> numbers = new ArrayList<>();

    for (int i = 0; i < N; i++) {
      int tmp = Integer.parseInt(br.readLine());
      numbers.add(new number(tmp));
    }
    Collections.sort(numbers);
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < N; i++) {
      sb.append(numbers.get(i).point).append("\n");

    }
    System.out.println(sb);
  }

  static class number implements Comparable<number> {
    int point;

    number(int point) {
      this.point = point;
    }

    @Override
    public int compareTo(number o) {
      return o.point - this.point;
    }

  }
}
