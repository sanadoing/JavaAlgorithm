package class_algo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class B_1244 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] switchs = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		String[] str = new String[2];
		
		int g, num, temp, left, right;

		for (int i = 1; i <= N; i++) {
			switchs[i] = Integer.parseInt(st.nextToken());
		}

		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			g = Integer.parseInt(str[0]);
			num = Integer.parseInt(str[1]);

			if (g == 1) { // 남
				temp = num;
				while (num <= N) {
					switchs[num] = (switchs[num] == 0) ? 1 : 0;
					num += temp;
        
				}
			} else { // 여
				switchs[num] = (switchs[num] == 0) ? 1 : 0;
        left = num - 1;
        right = num + 1;
        while (true){
          if(left< 1 || N <right || switchs[left] != switchs[right]) break;
          switchs[left] = (switchs[left] == 0) ? 1 : 0;
					switchs[right] = (switchs[right] == 0) ? 1 : 0;
          left -= 1;
          right += 1;
        }
        }
		}
		for (int i = 1; i < N + 1; i++) {
			System.out.print(switchs[i] + " ");
      if(i%20==0){
        System.out.println();
      }
		}

	}

}