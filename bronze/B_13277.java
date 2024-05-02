package bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class B_13277 {
  public static void main(String[] args) {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BigInteger result = new BigInteger("1");
    try {
      for (String a : br.readLine().split(" ")) {
        result = result.multiply(new BigInteger(a));
      }
      System.out.println(result);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
