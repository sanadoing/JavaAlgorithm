package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_2587 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] numbers = new int[5];
    int sum = 0;
    for (int i = 0; i < 5; i++) {
      numbers[i] = Integer.parseInt(br.readLine());
      sum += numbers[i];
    }
    Arrays.sort(numbers);
    System.out.println(sum/5+"\n"+numbers[2]);
  }
}
