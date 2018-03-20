


package edu.pupr.Employee;

import java.util.*;

public abstract class Employee 
{
	private final int ID;
	private final String SSN;
	private final String salutation;
	private final String firstName;
	private final String lastName;
	private final String maidenName;
	private final int earning_Type;
	private final double earnings;
	
	// Constructor with three parameters
	public Employee(int ID, String SSN, String salutation, String firstName, String lastName, String maidenName, int earning_Type, double earnings)
	{
		// super(); 
		this.ID = ID;
		this.SSN = SSN;
		this.salutation = salutation;
		this.firstName = firstName;
		this.lastName = lastName;
		this.maidenName = maidenName;
		this.earning_Type = earning_Type;
		this.earnings = earnings;
		
	}

	public int getID() {
		return ID;
	}



	public String getSSN() {
		return SSN;
	}



	public String getSalutation() {
		return salutation;
	}

	/**
	 * 
	 * @return returns first name.
	 */
	public String getFirstName() 
	{
		return firstName;
	}

	/**
	 * 
	 * @return returns last name.
	 */
	
	public String getLastName() 
	{
		return lastName;
	}

	/**
	 * 
	 * @return returns the social security number
	 */
	public String getSocialSecurityNumber() 
	{
		return SSN;
	}
	
	public String getMaidenName() {
		return maidenName;
	}

	public int getEarning_Type() {
		return earning_Type;
	}

	public double getEarnings() {
		return earnings;
	}
	
	// return String representation of Employee Object:
	@Override
	public String toString() 
	{
		return String.format("%s %s %s%s%nSocial Security Number: %s %n ID: %s Earning Type: %d Earnings: %d", 
				getSalutation(), getFirstName(), getLastName(), getMaidenName(), getSSN(), getID(), getEarning_Type(), getEarnings());
	}
	
	// Abstract Method must be overridden by concrete subclasses
	public abstract double earnings(); // no implementation here
	
	// After passing the Fig. 10.13
	
	// NOTE: We do not implement Payable method getPaymentAmount here so
	// this class must be declared abstract to avoid a compilation error.
	
	
} // end abstract class Employee