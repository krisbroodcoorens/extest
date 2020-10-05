package be.abis.exercise.model;

public class Company {
	
	private String name;
	private Address address;
	
	public Company(String name, Address address) {
		this.name = name;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public double calculateTaxToPay()
	{
		switch (this.getAddress().getCountryCode())
		{
			case "BE":
				return 51.0;
			case "NL":
				return 47.0;
			default:
				return 35.0;
		}
	}
}
