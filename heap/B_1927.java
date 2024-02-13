import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B_1927 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue <Integer> queue = new PriorityQueue<>();
		int N = Integer.parseInt(br.readLine());
		int n;
		for (int i = 0; i < N; i++) {
			n = Integer.parseInt(br.readLine());
			if (n == 0) {
				if(queue.size()==0) {
					System.out.println(0);
				}else {
					System.out.println(queue.poll());
				}
			}else {
				queue.offer(n);
			}
		}

	}

}
