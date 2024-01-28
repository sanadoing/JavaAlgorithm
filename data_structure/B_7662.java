import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.apple.concurrent.Dispatch.Priority;

public class B_7662 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    for (int i = 1; i < T; i++){
      int K = Integer.parseInt(br.readLine());
      Map<Integer, Integer> map = new HashMap<>();
      PriorityQueue<Integer> minQue = new PriorityQueue<>();
      PriorityQueue<Integer> maxQue = new PriorityQueue<>();

      for(int j = 0; j<K ; i++){
        String[] input = br.readLine().split("");
        char c = input[0].charAt(0);
        int n = Integer.parseInt(input[1]);

        if (c == 'I'){
          
        }
      }
      
    }
  }
}
