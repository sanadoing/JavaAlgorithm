package now;

import java.util.Scanner;

public class test {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String str = scan.nextLine();
    boolean toggle = true;
    for(int i = 0 ; i < (int)(str.length()/2); i++){
      if (str.charAt(i) != str.charAt(str.length()-i-1)){
        System.out.println(0);
        toggle = false;
        break;
      }
    }
    if(toggle){
      System.out.println(1);
    }
  }
}
