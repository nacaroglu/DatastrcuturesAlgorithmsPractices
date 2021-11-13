package com.nacaroglu.dsa.practice.string;

import java.util.HashMap;

public class RomanToInteger {

	public static void main(String[] args) {

		RomanToInteger roman = new RomanToInteger();
		System.out.println(roman.romanToInteger("LIX"));
		System.out.println(roman.romanToInteger("MCMXCIV"));
		System.out.println(roman.romanToInteger("LVIIII"));

	}

	public int romanToInteger(String s) {

		int result = 0;

		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		for (int i = s.length() - 1; i >= 0; i--) {

			result = result + map.get(s.charAt(i));

			if (i - 1 >= 0) {

				if (s.charAt(i) == 'X' || s.charAt(i) == 'V') {
					if (s.charAt(i - 1) == 'I') {
						result = result - map.get(s.charAt(i - 1));
						i--;
					}
				}

				if (s.charAt(i) == 'L' || s.charAt(i) == 'C') {
					if (s.charAt(i - 1) == 'X') {
						result = result - map.get(s.charAt(i - 1));
						i--;
					}
				}

				if (s.charAt(i) == 'D' || s.charAt(i) == 'M') {
					if (s.charAt(i - 1) == 'C') {
						result = result - map.get(s.charAt(i - 1));
						i--;
					}
				}
			}

		}

		return result;
	}

}
