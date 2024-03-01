package graph;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SWEA_2383 {

	static int N, personCnt, stairCnt;
	static int select[];

	static Point[] person;
	static Point[] stair;
	static int[] stairLength;

	static int answer;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			personCnt = 0;
			stairCnt = -1;

			person = new Point[10];
			stair = new Point[2];
			stairLength = new int[2];

			for (int i = 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if (num == 1) {
						person[personCnt++] = new Point(i, j);
					} else if (num != 0) {
						stair[++stairCnt] = new Point(i, j);
						stairLength[stairCnt] = num;
						
					}
				}
			}
			answer = Integer.MAX_VALUE;
			select = new int[personCnt];
			dfs(0);
      System.out.println("#"+t+" "+answer);
		}

	}

	static void dfs(int depth) {
		if (depth == personCnt) {
			go();
			return;
		}
		for (int i = 0; i < 2; i++) {
			select[depth] = i;
			dfs(depth + 1);
		}
	}

	static void go() {
		PriorityQueue<Integer> pqueue0 = new PriorityQueue<>();
		PriorityQueue<Integer> pqueue1 = new PriorityQueue<>();

		for (int i = 0; i < personCnt; i++) {
			if (select[i] == 0)
				pqueue0.add(dist(person[i], stair[0]));
			else
				pqueue1.add(dist(person[i], stair[1]));
		}

		int remain = personCnt;
		int[] stair0 = new int[3];
		int[] stair1 = new int[3];

		int time = 0;
		while (true) {
			if (remain == 0) {
				boolean flag = true;
				for (int i = 0; i < 3; i++) {
					if(stair0[i] != 0 ) {
						flag = false;
						break;
					}
          if(stair1[i] != 0) {
						flag = false;
						break;
					}
				}
				if(flag) break;
			}
			for (int i = 0; i < 3; i++) {
        if(stair0[i] == 0){
          if(!pqueue0.isEmpty()){
            if(pqueue0.peek()<= time){
              remain --;
              stair0[i] = stairLength[0];
              pqueue0.poll();
            }
          }
        }else{
          stair0[i]--;
          if(stair0[i]==0){
            if(!pqueue0.isEmpty()){
              if(pqueue0.peek()<= time){
                remain--;
                stair0[i]= stairLength[0];
                pqueue0.poll();
              }
            }
          }
        }
        if(stair1[i] == 0){
          if(!pqueue1.isEmpty()){
            if(pqueue1.peek()<= time){
              remain --;
              stair1[i] = stairLength[1];
              pqueue1.poll();
            }
          }
        }else{
          stair1[i]--;
          if(stair1[i]==0){
            if(!pqueue1.isEmpty()){
              if(pqueue1.peek()<= time){
                remain--;
                stair1[i]= stairLength[1];
                pqueue1.poll();
              }
            }
          }
        }
      }
			
			time++;
		}
    if(time<answer)answer = time;
	};

	static int dist(Point p, Point s) {
		return Math.abs(p.y - s.y) + Math.abs(p.x - s.x);
	}

	static class Point {
		int y;
		int x;

		Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}

}
