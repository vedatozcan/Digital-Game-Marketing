public class Date {
	private int day;
	private int month;
	private int year;

	public Date(int day, int month, int year) throws IllegalArgumentException {

		if (day < 1 || day > 31)
			throw new IllegalArgumentException("Invalid day.");
		else if (month < 1 || month > 31)
			throw new IllegalArgumentException("Invalid month.");
		else if (year < 0 || year > 2500)
			throw new IllegalArgumentException("Invalid year.");
		else {
			this.day = day;
			this.month = month;
			this.year = year;
		}
	}

	public Date() {
		this.day = 1;
		this.month = 1;
		this.year = 2020;

	}

	public int getDay() {
		return this.day;
	}

	public int getMonth() {
		return this.month;
	}

	public int getYear() {
		return this.year;
	}

	
	
	public void setDay(int day) {
		this.day = day;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public void setYear(int year) {
		this.year = year;
	}
	public void addMonths(Date date, int numMonths){
	    date.setMonth((date.getMonth() - 1 + numMonths) % 12 + 1);
	}

	@Override
	public String toString() {
		String tempString = "";
		
		if((String.valueOf(day)).length() == 1)
		{
			tempString += "0";
		}
		tempString += day + "-";
		
		if((String.valueOf(month)).length() == 1)
		{
			tempString += "0";
		}
	    tempString += month + "-";
		
		if((String.valueOf(year)).length() == 1)
		{
			tempString += "0";
		}
	   tempString += year;
		
		return tempString;
	}
	
	
	
}
