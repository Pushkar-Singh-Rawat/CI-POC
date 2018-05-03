package demo.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;

public class SalaryServiceImplTests {

	private SalaryServiceImpl salaryServiceImpl;
	private String day;
	private Date date;

	@Before
	public void setup() {
		salaryServiceImpl = new SalaryServiceImpl();
	}

	@Test
	public void testShowSalaryMessage() throws Exception {
		String username = System.getProperty("user.name");

		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
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
		String expectedMessage = "Today is " + date + "." + "You have " + remainingDays
				+ " days remaining to get salary.";
		if (remainingDays == 0) {
			assertEquals("Happy Salary Day!", salaryServiceImpl.showSalaryMessage());
		} else {
			assertEquals(expectedMessage, salaryServiceImpl.showSalaryMessage());
		}
	}

	@Test
	public void testRemainingDaysToSalary() throws Exception {
		long millis = System.currentTimeMillis();
		Date date = new Date(millis);
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

		assertNotNull(salaryServiceImpl.calculateDaysToGetSalary());
		assertEquals(String.valueOf(remainingDays), salaryServiceImpl.calculateDaysToGetSalary());

	}
}
