package a02;

public class Date {
	protected int day;
	protected int month;
	protected int year;
	protected int[] daysPerMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	
	public Date(int day, int month, int year) throws IlligalDateException{
		this.day = day;
		this.month = month;
		this.year = year;
		if(day <= 0 || month <= 0){
			throw new IlligalDateException("No negative days or month!");
		}
		if(0>year || year>3000){
			throw new IlligalDateException("Year out of scope![0-3000]");
		}
		if(month > 12){
			throw new IlligalDateException("illigal month!");
		}
		if(daysPerMonth[month-1] < day){
			throw new IlligalDateException("illigal day > " + daysPerMonth[month-1]);
		}
	}
	public int getDay() {
		return day;
	}
	public int getMonth() {
		return month;
	}
	public int getYear() {
		return year;
	}
	public String toString() {
		return String.format("%02d"+ '.' + "%02d"+ '.' + "%04d", day, month, year);
	}
}
