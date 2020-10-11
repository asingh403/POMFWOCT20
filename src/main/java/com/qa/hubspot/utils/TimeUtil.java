package com.qa.hubspot.utils;

/**
 * In this class we are define constants wait time to through out the framework
 * development so we can handle the over all wait time from single point.
 * 
 * @author ASHUTOSH SINGH
 *
 */

public class TimeUtil {

	public static void shortWait() {
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void mediumWait() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void longWait() {
		try {
			Thread.sleep(400);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
