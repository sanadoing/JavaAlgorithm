import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_16928 {
	
	/*
	 [CHECK LIST] 1. 주사위 1 ~ 6 
	 2. 보드판 10 X 10 : 100칸 
	 3. 주사위 굴린 결과 > 100 이면, 이동할 수 없음 
	 4. 사다리 위치 + / 뱀 위치 - 
	 5. 시작점 1 / 도착점 100
	
	 결과값 : 주사위를 굴려야 하는 횟수의 최솟 값
	 */

	static int lCnt, sCnt; // 사다리 수, 뱀 수
	static int[] board = new int[101];
	static boolean[] visited = new boolean[101];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		lCnt = Integer.parseInt(st.nextToken());
		sCnt = Integer.parseInt(st.nextToken());

		for (int i = 0; i < lCnt + sCnt; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			board[s] = e;
		}

		PriorityQueue<int[]> pqueue = new PriorityQueue<>(
				(i1, i2) -> (i1[1] == i2[1]) ? (i2[0] - i1[0]) : (i1[1] - i2[1]));
		pqueue.offer(new int[] { 1, 0 });

		if(board[1] == 100) {
			System.out.println(0);
			return;
		}
		while (!pqueue.isEmpty()) {
			int[] now = pqueue.poll();
			int nowP = now[0];
			int nowCnt = now[1];
			
			if (visited[nowP])
				continue;
			if (nowP == 100) {
				System.out.println(nowCnt);
				break;
			}
			visited[nowP] = true;
			if (board[nowP] != 0) {
				if (visited[board[nowP]])
					continue;
				pqueue.offer(new int[] { board[nowP], nowCnt });
			} else {
				for (int i = 1; i <= 6; i++) {
					if (nowP + i > 100 || visited[nowP + i])
						continue;
					pqueue.offer(new int[] { nowP + i, nowCnt + 1 });

				}
			}

		}

	}

}
