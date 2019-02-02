/**
 * 
 */
package lab1;

/**
 * @author Taylor Palm and Tyler Harring
 *
 */

import java.util.Calendar;

public class Time {
	
	//FIELDS
	
	private int hours, minutes, seconds;

	/**
	 * USER INPUT TIME
	 */
	public Time(int hours, int minutes, int seconds) {
		super();
		this.hours = hours;
		this.minutes = minutes;
		this.seconds = seconds;
	}

	/**
	 * SET CURRENT TIME 
	 */
	public Time() {
		Calendar now = Calendar.getInstance();
		
		hours=now.get((Calendar.HOUR_OF_DAY));
		minutes=now.get(Calendar.MINUTE);
		seconds=now.get(Calendar.SECOND);
		
	
	}

	/**
	 * @return the hours
	 */
	public int getHours() {
		return hours;
	}



	/**
	 * @return the minutes
	 */
	public int getMinutes() {
		return minutes;
	}


	/**
	 * @return the seconds
	 */
	public int getSeconds() {
		return seconds;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	
	@Override
	public String toString() {
		return hours + ":" + minutes 
				+ ":" + seconds;
	}
	
	
	//SET SECONDS
	
	public void incrementSeconds(){
		
		if(seconds==59) 
			{seconds=0;
			this.incrementMinutes();
			}
		
		else
			{seconds++;}
	}
	
	//SET MINUTES
	
	public void incrementMinutes(){
		
		if(minutes==59) 
			{minutes=0;
			this.incrementHours();}
		
		else
			{minutes++;}
	}
	
	//SET HOURS
	
	public void incrementHours(){
		
		if(hours==23) 
			{hours=0;}
		
		else
			{hours++;}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + hours;
		result = prime * result + minutes;
		result = prime * result + seconds;
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Time other = (Time) obj;
		if (hours != other.hours)
			return false;
		if (minutes != other.minutes)
			return false;
		if (seconds != other.seconds)
			return false;
		return true;
	}
		
		
		
	}





	
	
	
