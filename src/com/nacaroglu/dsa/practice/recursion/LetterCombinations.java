package com.nacaroglu.dsa.practice.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

	public static void main(String[] args) {

		LetterCombinations lc = new LetterCombinations();
		List<String> result = lc.letterCombinations("73");
		for (String string : result) {
			System.out.println(string);
		}

	}

	public List<String> letterCombinations(String digits) {

		List<String> result = new ArrayList<String>();

		if (digits == null || digits.length() == 0) {
			return result;
		}

		HashMap<Character, List<String>> map = new HashMap<Character, List<String>>();

		map.put('2', Arrays.asList("a", "b", "c"));
		map.put('3', Arrays.asList("d", "e", "f"));
		map.put('4', Arrays.asList("g", "h", "i"));
		map.put('5', Arrays.asList("j", "k", "l"));
		map.put('6', Arrays.asList("m", "n", "o"));
		map.put('7', Arrays.asList("p", "q", "r", "s"));
		map.put('8', Arrays.asList("t", "u", "v"));
		map.put('9', Arrays.asList("w", "x", "y", "z"));

		backtrack(digits, 0, map, new StringBuffer(), result);

		return result;
	}

	private void backtrack(String digits, int index, HashMap<Character, List<String>> map, StringBuffer sb,
			List<String> result) {

		if (sb.length() == digits.length()) {
			result.add(sb.toString());
			return;
		}

		List<String> chars = map.get(digits.charAt(index));

		for (String chr : chars) {
			sb.append(chr);
			backtrack(digits, index + 1, map, sb, result);
			sb.deleteCharAt(sb.length() - 1);
		}
	}

}
