package com.demo.entity;

public class DateOfBirth implements Comparable<DateOfBirth>{

	private Integer day;
	private Integer month;
	private Integer year;

	public DateOfBirth() {
		super();
	}

	public DateOfBirth(Integer day, Integer month, Integer year) {
		super();
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "DateOfBirth [day=" + day + ", month=" + month + ", year="
				+ year + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((day == null) ? 0 : day.hashCode());
		result = prime * result + ((month == null) ? 0 : month.hashCode());
		result = prime * result + ((year == null) ? 0 : year.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DateOfBirth other = (DateOfBirth) obj;
		if (day == null) {
			if (other.day != null)
				return false;
		} else if (!day.equals(other.day))
			return false;
		if (month == null) {
			if (other.month != null)
				return false;
		} else if (!month.equals(other.month))
			return false;
		if (year == null) {
			if (other.year != null)
				return false;
		} else if (!year.equals(other.year))
			return false;
		return true;
	}

	@Override
	public int compareTo(DateOfBirth obj) {
		if(obj.year == this.year){
			if(obj.month == this.month)
			{
				if(obj.day == this.day)
					return 0;
				else if(this.day > obj.day)
					return 1;
				else
					return -1;
			}
			else if(this.month > obj.month)
				return 1;
			else
				return -1;
		}
		else if (this.year > obj.year)
			return 1;
		else return -1;

	}

	
}
