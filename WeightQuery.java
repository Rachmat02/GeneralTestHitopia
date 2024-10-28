package com.example;

import java.util.HashSet;
import java.util.Set;

public class WeightQuery {

	public static void main(String[] args) {
		String s = "abccdd";
		int[] kueri = { 1, 3, 9, 8 ,4 };

		String[] hasil = statusKueri(s, kueri);

		for (String res : hasil) {
			System.out.println(res);
		}
	}

	public static int hitungBobotKarakter(char c) {
		return c - 'a' + 1;
	}

	public static Set<Integer> hasilkanBobot(String s) {
		Set<Integer> bobotUnik = new HashSet<>();
		int n = s.length();

		for (int i = 0; i < n; i++) {
			int bobot = 0;
			for (int j = i; j < n && s.charAt(i) == s.charAt(j); j++) {
				bobot += hitungBobotKarakter(s.charAt(i));
				bobotUnik.add(bobot);
			}
		}
		return bobotUnik;
	}

	public static String[] statusKueri(String s, int[] kueri) {
		Set<Integer> bobot = hasilkanBobot(s);
		String[] hasil = new String[kueri.length];

		for (int i = 0; i < kueri.length; i++) {
			if (bobot.contains(kueri[i])) {
				hasil[i] = "Ya";
			} else {
				hasil[i] = "Tidak";
			}
		}

		return hasil;
	}

}
