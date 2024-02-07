package Week02_01.temp;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class B_10814 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		List<Person> array = new ArrayList<Person>(
//				(n1, n2) -> {
//					n1.age == n2.age ? n1.name.compareTo(n2.name) : n2.name.compareTo(n1.name)
//				}
		);

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			array.add(new Person(Integer.parseInt(st.nextToken()), st.nextToken(), i));
		}

		Collections.sort(array, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				if (o1.age == o2.age)
					return o1.num - o2.num;

				return o1.age - o2.age;
			}

		});

		for (int i = 0; i < N; i++) {
			System.out.println(array.get(i).age + " " + array.get(i).name);
			;
		}
	}

	static class Person {
		int age;
		String name;
		int num;

		Person(int age, String name, int num) {
			this.age = age;
			this.name = name;
			this.num = num;
		}

	}

}
