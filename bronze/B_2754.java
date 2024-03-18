import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B_2754 {
  public static void main(String[] args)throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String []input = br.readLine().split("");
    HashMap <String, Double> map = new HashMap<>();
    Double result = 0.0;
    map.put("A", 4.0);
    map.put("B", 3.0);
    map.put("C", 2.0);
    map.put("D", 1.0);
    map.put("F", 0.0);
    
    if(input.length > 1){
      if(input[1].equals("+")){
        result += 0.3;
      }else if(input[1].equals("-")){
        result -= 0.3;
      }
    }
    result += map.get(input[0]);
    System.out.println(result);
  }
}
