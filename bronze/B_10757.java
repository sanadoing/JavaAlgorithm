package bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B_10757 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] input = br.readLine().split(" ");

    BigInteger a = new BigInteger(input[0]);
    BigInteger b = new BigInteger(input[1]);
    System.out.println(a.add(b));
  }
}
