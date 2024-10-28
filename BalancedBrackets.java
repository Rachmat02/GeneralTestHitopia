package com.example;

import java.util.ArrayList;
import java.util.List;

public class BalancedBrackets {
	public static String isBalanced(String s) {
		List<Character> stack = new ArrayList<>();

		for (char ch : s.toCharArray()) {
			if (ch == ' ') {
				continue;
			}
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.add(ch);
			} else if (ch == ')' || ch == '}' || ch == ']') {
				if (stack.isEmpty()) {
					return "Tidak";
				}
				char top = stack.remove(stack.size() - 1);
				if (!isMatchingPair(top, ch)) {
					return "Tidak";
				}
			}
		}

		return stack.isEmpty() ? "Ya" : "Tidak";
	}

	private static boolean isMatchingPair(char open, char close) {
		return (open == '(' && close == ')') || (open == '{' && close == '}')
				|| (open == '[' && close == ']');
	}

	public static void main(String[] args) {
		String input1 = "{ [ ( ) ] }";
		String input2 = "{ ( [ ] ) }";
		String input3 = "{ ( ( [ ] ) ( ] ) [ ] }";

		System.out.println(isBalanced(input1));
		System.out.println(isBalanced(input2));
		System.out.println(isBalanced(input3));
	}
}