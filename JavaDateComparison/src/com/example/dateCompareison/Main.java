package com.example.dateCompareison;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

	public static void main(String[] args) {
		
		Main main= new Main();
		main.init();
	}
	
	private void init(){
		SimpleDateFormat sdf = new SimpleDateFormat("EEE");
		Date today = new Date();
		Date tomorrow = new Date(today.getTime()+addDays(1));
		Date beforeToday = new Date(today.getTime()+addDays(3));
		
		System.out.println("today: " + sdf.format(today));
		System.out.println("tomorrow: " + sdf.format(tomorrow));
		System.out.println("beforeToday: " + sdf.format(beforeToday));
		System.out.println(today.compareTo(beforeToday));
		
	
	}
	
	private long addDays(int days){
		return days * 24 * 60 * 60 * 1000;
	}

}
