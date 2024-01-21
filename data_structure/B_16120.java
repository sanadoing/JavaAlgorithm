// package data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Scanner;
import java.util.Stack;

public class B_16120 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String str = bf.readLine();
		Stack<String> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {

			stack.add(Character.toString(str.charAt(i)));
			
			if (stack.size() >= 4) {

				String temp = "";
				for (int j = 0; j < 4; j++) {
					temp = temp + stack.pop();
				}
				// 뽑은 4개의 글자가 PAPP(pop했으므로 반대)이면, P를 추가
				if (temp.equals("PAPP")) {
					stack.add("P");
				} else { // 뽑은 4개의 글자가 PAPP가 아니라면, 다시 뽑은 4개의 글자를 다시 넣어줌.
					for (int j = 0; j < temp.length(); j++) {
						stack.add(Character.toString(temp.charAt(3 - j)));
					}
				}
			}
		}
		if (stack.size() == 1 && stack.pop().equals("P")) {
			System.out.println("PPAP");
		} else {
			System.out.println("NP");
		}
	}

}
