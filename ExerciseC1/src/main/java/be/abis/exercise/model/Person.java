package be.abis.exercise.model;

import be.abis.exercise.exception.PersonShouldBeOlderThan18Exception;
import be.abis.exercise.model.Company;

import java.time.LocalDate;
import java.time.Period;

public class Person {
	
	private int personNumber;
	private String firstName;
	private String lastName;
	private LocalDate birthDay;
	private Company company;
	private double grossSalary;
	
	public Person(int personNumber, String firstName, String lastName, LocalDate birthDay) {
		this.personNumber = personNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDay = birthDay;
	}

	public Person(int personNumber, String firstName, String lastName, LocalDate birthDay, Company company) {
		this(personNumber,firstName,lastName,birthDay);
		this.company = company;
	}

	public Person(){
	}

	public int getPersonNumber() {
		return personNumber;
	}

	public void setPersonNumber(int personNumber) {
		this.personNumber = personNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDate birthDay) {
		this.birthDay = birthDay;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	@Override
	public String toString()
	{
		String text = null;
		try
		{
			text = "Person " +this.firstName + " " +this.lastName + " (" +this.calculateAge()+ " years old)";
			if (this.company != null)
			{
				text+= " works for " + this.company.getName() + " in " + this.company.getAddress().getTown() + ".";
			}
			else
			{
				text+= " is not employed for the moment.";
			}
		}
		catch (PersonShouldBeOlderThan18Exception exp)
		{
			exp.printStackTrace();
		}
		return text;
	}

	public int calculateAge() throws PersonShouldBeOlderThan18Exception
	{
		int age = Period.between(birthDay, LocalDate.now()).getYears();
		if (age<18) throw new PersonShouldBeOlderThan18Exception("person is not an adult");
		return age;
	}

	public double calculateSalary()
	{
		double salary = 0.0;
		salary = grossSalary*(1.0-(company.calculateTaxToPay()/100.0));
		return salary;
	}
}
