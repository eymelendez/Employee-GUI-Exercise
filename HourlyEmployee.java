package edu.pupr.Employee;

// Fig. 10.6: HourlyEmployee.java
// HourlyEmployee class extends Employee

public class HourlyEmployee extends Employee
{

	private double wage; // wage per hour
	private double hours; // hours worked for week
	
	// constructor with 5 parameters 
	public HourlyEmployee(int ID, String SSN, String salutation, String firstName, String lastName, 
			 String maidenName, int earning_Type, double earnings, double weeklySalary, double wage, double hours) 
	{
		// super class
		super(ID, SSN, salutation, firstName, lastName, maidenName, earning_Type, earnings);
		
		// Exception handling
		if(wage < 0.0) // validate wage
		{
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}
		
		if(hours < 0.0 || (hours > 168.0)) // validate hours
		{
			throw new IllegalArgumentException("Hours worked must be >= 0.0");
		}
		
		this.wage = wage;
		this.hours = hours;
	}
	
	// set wage
	public void setWage(double wage) 
	{
		if(wage < 0.0) // validate wage
		{
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");
		}
		
		this.wage = wage;
	}
	
	// return wage
	public double getWage() 
	{
		return wage;
	}
	
	// set hours worked
	public void setHours(double hours) 
	{
		if(hours < 0.0 || (hours > 168.0)) // validate hours
		{
			throw new IllegalArgumentException("Hours worked must be >= 0.0");
		}
		
		this.hours = hours;
	}
	
	// return hours worked
	public double getHours()
	{
		return hours;
	}

	// calculate earnings: override abstract method earnings in Employee
	@Override
	public double earnings() 
	{
		if(getHours() <= 40) // no overtime
			return getWage() * getHours();
		else
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
	}

	// return String representation of HourlyEmployee object
	@Override
	public String toString()
	{
		return String.format("Hourly employee: %s%n%s: $%,.2f; %s: %, .2f", 
				super.toString(), "Hourly wage", getWage(),
				"Hours worked", getHours());
	}
	

} // end class HourlyEmployee