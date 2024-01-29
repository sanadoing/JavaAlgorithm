package simulation;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3987 {

	public static void main(String[] args) throws Exception {

		// U, R, D, L
		int[] dy = { -1, 0, 1, 0 };
		int[] dx = { 0, 1, 0, -1 };
		String[] result1 = { "U", "R", "D", "L" };
		int[] result2 = { 1,1,1,1 };

		// /의 경우
		int[] change1 = { 1, 0, 3, 2 };
		// \의 경우
		int[] change2 = { 3, 2, 1, 0 };

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");
		StringTokenizer st;

		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);

		char[][] board = new char[N][M];
		for (int i = 0; i < N; i++) {
			String temp = br.readLine();

			for (int j = 0; j < M; j++) {
				board[i][j] = temp.charAt(j);

			}

		}

		str = br.readLine().split(" ");
		int PR = Integer.parseInt(str[0]);
		int PC = Integer.parseInt(str[1]);
		int y, x, dir, yy, xx;


		for (int i = 0; i < 4; i++) {

			int[][] visited = new int[N][M];
			y = PR - 1;
			x = PC - 1;
			dir = i;
			visited[y][x] = (i+1);
			while (true) {
				yy = y + dy[dir];
				xx = x + dx[dir];
				if ((0 <= yy) && (yy < N) && (0 <= xx) && (xx < M)) {
					if((visited[yy][xx]!=(dir+1))){
					
					if (board[yy][xx] == '/') {
						dir = change1[dir];
					} else if (board[yy][xx] == 'C') {
						break;
					} else if (board[yy][xx] == '\\') { // \의 경우
						dir = change2[dir];
					}
					result2[i] += 1;
					visited[yy][xx] = (dir+1);
					y = yy;
						x = xx;
				}else{
					System.out.print(result1[i]+"\n"+"Voyager");
					return;
				}
				} else {

					break;
				}
				

			}
		}
		int temp = 0;
		for(int i = 1; i<4 ; i++){
			if(result2[temp] < result2[i]){
				temp = i;
			}
		}
		System.out.println(result1[temp]+"\n"+result2[temp]);
		

	}

}