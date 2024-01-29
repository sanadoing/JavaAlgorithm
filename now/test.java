package now;

import java.util.Scanner;

public class test {
  public static void main(String[] args)  {
    Scanner scan = new Scanner(System.in);
  
    int n = scan.nextInt();
    int m = scan.nextInt();
    int[][] arr1 = new int[n][m];
    int[][] arr2 = new int[n][m];
    for (int c = 0 ; c < 2 ; c++){
    for (int i = 0; i<n; i++){
      for (int j = 0; j<m;j++){
        arr1[i][j] += scan.nextInt();
      }
    }
  }
  for (int i = 0; i<n; i++){
    for (int j = 0; j<m;j++){
      
      System.out.print(arr1[i][j]+" ");
    }
    System.out.println();
  }
  
   

  }
}
