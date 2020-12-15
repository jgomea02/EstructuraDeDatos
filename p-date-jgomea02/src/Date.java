package es.unileon.prg1.date;

public class Date {
	private int day;
	private int month;
	private int year;

	// Constructor mal programado: Permite crear fechas no validas
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	public int getYear() {
		return this.year;
	}
	public int getMonth() {
		return this.month;
	}
	public int getDay() {
		return this.day;
	}
	boolean isSameYear(Date year) {
		if (this.year == year.getYear()) {
			return true;
		}
		return false;
	}
	boolean isSameMonth(Date month) {
		if (this.month == month.getMonth()) {
			return true;
		}
		return false;
	}
	boolean isSameDay(Date day) {
		if (this.day == day.getDay()) {
			return true;
		}
		return false;
	}
	boolean isSame(Date date) {
		if ((isSameDay(date) == true) && (isSameMonth(date) == true) && (isSameYear(date) == true)) {
			return true;
		}
		return false;
	}
	public String getMonthName() {
		String name = new String();
		switch (this.month) {
		case 1:
			name = "January";
			break;
		case 2:
			name = "February";
			break;
		case 3:
			name = "March";
			break;
		case 4:
			name = "April";
			break;
		case 5:
			name = "May";
			break;
		case 6:
			name = "June";
			break;
		case 7:
			name = "July";
			break;
		case 8:
			name = "August";
			break;
		case 9:
			name = "September";
			break;
		case 10:
			name = "October";
			break;
		case 11:
			name = "November";
			break;
		case 12:
			name = "December";
			break;
		}
		return name;
	}
	public boolean isDayOfMonthRight() {
		boolean correcto = false;
		switch (this.month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			if (this.day <= 31) {
				correcto = true;
			}
			break;
		case 2:
			if (this.day <= 28) {
				correcto = true;
			}
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			if (this.day <= 30) {
				correcto = true;
			}
			break;
		}
		return correcto;
	}
	public String seasonOfTheMonth() {
		String season = new String();
		switch (this.month) {
		case 1:
		case 2:
		case 12:
			season = "winter";
			break;
		case 3:
		case 4:
		case 5:
			season = "spring";
			break;
		case 6:
		case 7:
		case 8:
			season = "summer";
			break;
		case 9:
		case 10:
		case 11:
			season = "fall";
			break;
		}
		return season;
	}
	public String monthsLeft() {

		StringBuilder months = new StringBuilder();

		for (int i = this.month + 1; i <= 12; i++) {
			Date monthsLeftDate = new Date(this.day, i, this.year);

			months.append(monthsLeftDate.getMonthName() + "\t");
		}

		return months.toString();

	}
	public int numDays(int month) {
		int numMonth = 0;
		switch (month) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			numMonth = 31;
			break;
		case 2:
				numMonth = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			numMonth = 30;
			break;
		}
		
		return numMonth;
	}
	public String daysOfTheMonthLeft() {
		int numMonth = numDays(this.month);
		// Hacemos un bucle hasta el numero calculado antes
		
		StringBuilder daysLeft = new StringBuilder();
		for (int i = this.day+1; i <= numMonth; i++) {
			Date daysLeftDate = new Date(i, this.month, this.year);

			if (daysLeftDate.isDayOfMonthRight() == true) {

				daysLeft.append(daysLeftDate + "\t");

			}
		}

		return daysLeft.toString();
	}
	public String monthsWithSameDays() {
		String months = new String();
		switch (numDays(this.month)){
		case 31:
			months = "Months with 31 days: January, March, May, July, August, October, December";
			break;
		case 28:
		case 29:
			months = "Only February";
			break;
		case 30:
			months = "Months with 30 days: April, June, September, November";
			break;
		}
		return months;
	}
	public int numDaysFrom11(Date date) {
		int num = 0;
		int month = date.getMonth();
		
		for(int i=0;i<month;i++) {
			num = num + numDays(i);
		}
		num = num + date.getDay();
		return num-1;
	}
	public int numAttempsRand() {
		int count = 0;
		boolean off = false;
		while(!off) {
			Date random = new Date((int)Math.random()*31+1,(int)Math.random()*12+1,(int)Math.random()*2019+1);
			count++;
			off = isSame(random);
		}
		return count;
	}
	public String dayOfWeek() {
		//El primer dia del anio 2019 fue martes
		String[] diasSemana = {"Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo", "Lunes"};
		//Primero vemos cuantos dias han pasado desde ese dia
		String day = new String();
		Date today = new Date (this.day, this.month, this.year);
		int weekDay = numDaysFrom11(today)%7;
		day = diasSemana[weekDay];
		return day;
	}
	public String toString() {
		return this.day + "/" + this.month + "/" + this.year;
	}

}
