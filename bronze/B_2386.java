package bronze;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class B_2386 {
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    while (true) {
      String input = br.readLine().toLowerCase();
      int answer = 0;
      if(input.charAt(0)== '#'){
        break;
      }
      char target = input.charAt(0);
      int size = input.length();
      for (int i = 2; i < size; i++) {
        if(input.charAt(i)== target){
answer += 1;
        }
      }
    
        System.out.println(target +" "+answer);

      }
   
  }
}
