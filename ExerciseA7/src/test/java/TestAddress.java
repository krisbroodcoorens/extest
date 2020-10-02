import be.abis.exercise.model.Address;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class TestAddress
{
    @Test
    public void belgianZipCodeShouldBeNumeric()
    {
        //Arrange
        boolean isNumeric;
        Address myAddress = new Address("Broekstraat","5","B9000","Brussels", "Belgium", "BE");

        //Act
        isNumeric = myAddress.checkBelgianZipCode(myAddress.getZipCode());

        //Assert
        assertTrue(isNumeric);
    }
}