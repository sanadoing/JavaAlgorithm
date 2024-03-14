package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2420 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String [] numbers = br.readLine().split(" ");
    System.out.println((int)Math.abs(Long.parseLong(numbers[0])-Long.parseLong(numbers[1])));

  }
}
