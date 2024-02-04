package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA_2001 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int N, M, sum;
		int[][] board, new_board;
		
		for (int t = 1; t < T + 1; t++) {
      int result = Integer.MIN_VALUE;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			board = new int[N][N];
      new_board = new int[N + 1][N + 1];

      for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
						
				}
			}

			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					new_board[i][j] = new_board[i - 1][j] + new_board[i][j - 1] + board[i-1][j-1]
							- new_board[i - 1][j - 1];
				}
			}
  
			sum = 0; 
      for(int i = 1; i < N-M+2; i++){
        for (int j = 1; j < N-M+2; j++){
        
          sum = new_board[i+M-1][j+M-1] - new_board[i+M-1][j-1] -new_board[i-1][j+M-1] + new_board[i-1][j-1];
          result = Math.max(result, sum);
       
        }
      }
      System.out.println("#"+t+" "+result);
		

		}

	}

}