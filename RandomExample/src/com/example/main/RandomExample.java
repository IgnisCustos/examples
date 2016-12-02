package com.example.main;

import java.util.Random;

public class RandomExample {

	public static void main(String[] args) {
		Random random = new Random();
		int max = 10;
		int min = 1;
	
		for (int i = 0; i < 100; i++) {
			int nextNum = random.nextInt(max - min + 1) + min;
			System.out.println(i+": " + nextNum);
		}
		
	}

}
