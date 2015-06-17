package a02;

public class SimpleDate {
	protected int day;
	protected int month;
	protected int year;

	public SimpleDate(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
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
		return "" + day + '.' + month + '.' + year;
	}
}