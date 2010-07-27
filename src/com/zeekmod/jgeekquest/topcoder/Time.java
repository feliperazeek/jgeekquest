package com.zeekmod.jgeekquest.topcoder;

// TODO: Auto-generated Javadoc
/**
 * The Class Time.
 */
public class Time {

	/**
	 * What time.
	 * 
	 * @param seconds
	 *            the seconds
	 * 
	 * @return the string
	 */
	public String whatTime(int seconds) {
		int left = seconds;
		int hours = 0;
		int mins = 0;
		int secs = 0;
		for (int i = 23; i > 0; i--) {
			int div = (i * 60 * 60);
			int r = left / div;
			if (r > 0) {
				hours = i;
				left = left - (hours * div);
				break;
			}
		}

		for (int i = 60; i > 0; i--) {
			int div = (i * 60);
			int r = left / div;
			if (r > 0) {
				mins = i;
				left = left - (mins * div);
				break;
			}
		}

		secs = seconds - ((hours * 60 * 60) + (mins * 60));

		return hours + "/" + mins + "/" + secs;
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		Time t = new Time();
		System.out.println(t.whatTime(5436));
		System.out.println(t.whatTime(0));
	}

}
