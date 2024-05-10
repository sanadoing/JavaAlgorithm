import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2174 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int A = Integer.parseInt(st.nextToken());
    int B = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[][] Robot = new int[N][3];
    for (int i = 0; i < 3; i++) {
      st = new StringTokenizer(br.readLine());
      Robot[i][0] = Integer.parseInt(st.nextToken());
      Robot[i][1] = Integer.parseInt(st.nextToken());
      Robot[i][2] = Integer.parseInt(st.nextToken());

    }
  }
}
