import be.abis.exercise.model.Address;
import be.abis.exercise.model.Company;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestCompany
{
    Company myFirstCompany;
    Company mySecondCompany;

    @Before
    public void setUp() {
        //Recreate the test addresses and companies before each test
        Address myFirstAddress = new Address("Halsesteenweg", "154", "1500", "Halle", "België", "BE");
        Address mySecondAddress = new Address("Eindhovenlaan", "23", "5600", "Eindhoven", "Nederland", "NL");
        myFirstCompany = new Company("Colruyt", myFirstAddress);
        mySecondCompany = new Company("Philips", mySecondAddress);
    }

    @Test
    public void taxForBelgianCompanyShouldBe51()
    {
        //Arrange
        double expectedTax = 51.0;

        //Act
        double calculatedTax = myFirstCompany.calculateTaxToPay();

        //AssertEquals
        assertEquals(expectedTax, calculatedTax,0.0);
    }
}