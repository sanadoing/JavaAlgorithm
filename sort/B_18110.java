package sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B_18110 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    int [] numbers= new int[N];
    for(int i = 0 ; i <N; i++){
      numbers[i] = Integer.parseInt(br.readLine());
    }
    int NN =  (int) Math.round(N * (0.15)) ;
    Arrays.sort(numbers);
    double result = 0;
    for(int i = NN ; i <N-NN; i++){
      result += numbers[i] ;
    }
    System.out.println(Math.round(result/(N-2*NN)));
  }
}
