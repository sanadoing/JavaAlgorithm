package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_10989 {
  public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int [] numbers = new int[N];
    StringBuilder sb = new StringBuilder();
    for(int i = 0; i < N; i++){
      numbers[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(numbers);
    for(int i = 0; i < N; i++){
      sb.append(numbers[i]).append("\n");
    }
    System.out.println(sb);
  }
}
