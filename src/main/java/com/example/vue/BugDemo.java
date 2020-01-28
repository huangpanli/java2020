package com.example.vue;

public class BugDemo {

	public static void main(String[] args) {
		String s = null;
		if (s.equals("0")) {
			System.out.println("Find a bug.");
		} else {
			System.out.println("Another bug.");
		}
	}
}
