import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> map = new HashMap<>();
		String [] array = new String[N+1];
		String temp ;
		for (int i = 1; i < N+1; i++) {
			temp = br.readLine();
			map.put(temp, i);
			array[i] = temp;
		}
		
		for (int i = 0; i < M; i++) {
			temp = br.readLine();
			if(map.get(temp) == null) {
				System.out.println(array[Integer.parseInt(temp)]);
			}else {
				System.out.println(map.get(temp));
			}
		}
	}

}
