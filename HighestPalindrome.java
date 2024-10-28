package com.example;

public class HighestPalindrome {

	public static String highestPalindrome(String s, int k) {
		char[] sArray = s.toCharArray();
		int n = sArray.length;

		String result = makePalindrome(sArray, 0, n - 1, k);

		if (result == null) {
			return "-1";
		}

		return buildHighest(result.toCharArray(), 0, n - 1, k);
	}

	private static String makePalindrome(char[] sArray, int left, int right,
			int k) {
		if (left >= right) {
			return new String(sArray);
		}

		if (sArray[left] != sArray[right]) {
			if (k <= 0) {
				return null;
			}
			sArray[left] = sArray[right] = (char) Math.max(sArray[left],
					sArray[right]);
			k--;
		}

		return makePalindrome(sArray, left + 1, right - 1, k);
	}

	private static String buildHighest(char[] sArray, int left, int right, int k) {
		if (left > right) {
			return new String(sArray);
		}

		boolean isSame = sArray[left] == sArray[right];

		if (sArray[left] != '9') {
			if (k > 0) {
				if (isSame) {
					if (k >= 2) {
						sArray[left] = sArray[right] = '9';
						k -= 2;
					}
				} else {
					sArray[left] = sArray[right] = '9';
					k--;
				}
			}
		}

		return buildHighest(sArray, left + 1, right - 1, k);
	}

	public static void main(String[] args) {
		String s1 = "8768";
		int k1 = 1;
		System.out.println(highestPalindrome(s1, k1)); 

		String s2 = "945549";
		int k2 = 2;
		System.out.println(highestPalindrome(s2, k2)); 

		String s3 = "57483";
		int k3 = 3;
		System.out.println(highestPalindrome(s3, k3)); 

	}

}
