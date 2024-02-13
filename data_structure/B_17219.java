import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_17219 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String name, password;
		HashMap<String, String> map = new HashMap<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			name = st.nextToken();
			password = st.nextToken();
			
			map.put(name, password);
		}
		
		for (int i = 0; i < M; i++) {
			name = br.readLine();
			System.out.println(map.get(name));
		}
	}

}
