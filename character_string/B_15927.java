package character_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class B_15927 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		String arr[] = s.split("");
		// 팰린드롬 조건
		// #1 - aaa (모든 글자가 같음) - 팰린드롬 O ->false
		// #2 - abc (모든 글자가 다름) - 팰린드롬 X -> true
		// #3 - aabaa (좌우 대칭) - 팰린드롬 O - (len-1) -> true
		
		// 반례 XABX - 팰린드롬 X

		Set<String> arr_toset = new LinkedHashSet<>(Arrays.asList(arr));
		if (arr_toset.size() == 1) {

			System.out.println(-1);
		} else {

			boolean check = true;
			// 대칭이 아닌 글자가 한글자라도 있는지 파악 - false : 한글자라도 다르면, true : 좌우 대칭이면, 계속 true값 유지

			for (int i = 0; i < arr.length / 2; i++) {
				if (check) {
					if (!arr[i].equals(arr[arr.length - 1 - i])) {
						check = false;
					}
				} else {
					break;
				}
			}
			if (check) {
				System.out.println(arr.length - 1);
			} else {
				System.out.println(arr.length);
			}

		}
	}

}
