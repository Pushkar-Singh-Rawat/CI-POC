package demo.services;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.springframework.stereotype.Service;

@Service
public class SalaryServiceImpl implements SalaryService {

	private Date date;
	String day;
	String presentDate;

	String username = ""/* System.getProperty("user.name") */;

	@Override
	public String showSalaryMessage() {
		// TODO Auto-generated method stub
		long millis = System.currentTimeMillis();
		date = new Date(millis);
		day = date.toString().split("-")[2];
		if (calculateDaysToGetSalary().equalsIgnoreCase("0")) {
			return "Today is " + date + "." + " Happy Salary Day!";
		} else {
			return "Today is " + date + "." + "You have " + calculateDaysToGetSalary()
					+ " days remaining to get salary.";
		}
	}

	@Override
	public String calculateDaysToGetSalary() {
		long millis = System.currentTimeMillis();
		date = new Date(millis);
		java.util.Date today = new java.util.Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(today);
		day = date.toString().split("-")[2];
		calendar.add(Calendar.MONTH, 1);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		do {
			calendar.add(Calendar.DATE, -1);
		} while (calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY
				|| calendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
		java.util.Date lastDayOfMonth = calendar.getTime();
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("Today: " + sdf.format(today));
		System.out.println("Last Day of Month: " + sdf.format(lastDayOfMonth));
		int presentDay = Integer.valueOf(day);
		int lastDay = Integer.valueOf(sdf.format(lastDayOfMonth).toString().split("-")[2]);
		int remainingDays = lastDay - presentDay;

		return String.valueOf(remainingDays);
	}

	@Override
	public String displayUserName() {
		// TODO Auto-generated method stub

		return null;
	}

}
