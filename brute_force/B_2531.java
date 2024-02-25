import java.util.*;
import java.io.*;

public class B_2531 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
  
        st = new StringTokenizer(br.readLine());
  
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
  
        int[] arr = new int[N];
        int[] sushi = new int[D+1];
  
        for (int i = 0; i < N; i++) {
           arr[i] = Integer.parseInt(br.readLine());
        }
  
        int cur = 0;
  
        for (int i = 0; i < K; i++) {
           if (sushi[arr[i]] == 0) {
              cur++;
           }
           sushi[arr[i]]++;
        }
  
        int ans = cur;
  
        for (int i = 1; i < N+1; i++) {
  
           sushi[arr[i - 1]]--;
           if (sushi[arr[i - 1]] == 0) {
              cur--;
           }
  
           int idx = (i + K - 1) % N;
  
           if (sushi[arr[idx]] == 0) {
              cur++;
           }
           sushi[arr[idx]]++;
  
           if (sushi[C] == 0)
              ans = Math.max(ans, cur + 1);
           else
              ans = Math.max(ans, cur);
  
        }
  
        System.out.println(ans);
  
     }
}