package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class groupWordsWithSameSetOfCharacters {
	public static void findSimilarWords(String[] arr) {
		HashMap<String, ArrayList<Integer>> hp = new HashMap<>();
		for (int i = 0; i < arr.length; i++) {
			boolean[] visited = new boolean[26]; // constant time
			String s = arr[i];
			for (int j = 0; j < s.length(); j++) {
				visited[s.charAt(j) - 'a'] = true;
			}
			String sortedPattern = "";
			for (int k = 0; k < visited.length; k++) {
				if (visited[k] == true) {
					char ch = (char) (k + 'a');
					sortedPattern += ch;
				}
			}
			// if hashmap dont have that patt
			if (hp.get(sortedPattern) == null) {
				ArrayList<Integer> mapAl = new ArrayList<>();
				mapAl.add(i);
				hp.put(sortedPattern, mapAl);
			} else {
				ArrayList<Integer> mapAl = hp.get(sortedPattern);
				mapAl.add(i);
				hp.put(sortedPattern, mapAl);
			}
		}
		// display
		ArrayList<String> al = new ArrayList<>(hp.keySet());
		for (int i = 0; i < al.size(); i++) {
			String s = al.get(i);
			for (int p = 0; p < hp.get(s).size(); p++) {
				System.out.print(arr[hp.get(s).get(p)]+" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int arraySize = sc.nextInt();
		String[] arr = new String[arraySize];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.next();
		}
		sc.close();
		findSimilarWords(arr);
	}
}
