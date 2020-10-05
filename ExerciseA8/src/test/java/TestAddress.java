import be.abis.exercise.model.Address;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestAddress
{
    Address myFirstAddress;

    @Before
    public void setUp(){
        myFirstAddress = new Address("Diestsevest","32 bus 4B","3000","Leuven","Belgium","BE");
    }

    @Test
    public void belgianZipCodeShouldBeNumeric()
    {
        //Arrange
        boolean isNumeric;
        Address myAddress = new Address("Broekstraat","5","9000","Brussels", "Belgium", "BE");

        //Act
        isNumeric = myAddress.checkBelgianZipCode();

        //Assert
        assertTrue(isNumeric);
    }

    @Test
    public void appendingAddressToFileShouldReturnExtraLineInFile() throws IOException {
        Path path = Address.getFilePath();
        int countBeforeWrite=0;
        if (Files.exists(path)) {
            path.toFile().setWritable(true);
            countBeforeWrite = Files.readAllLines(path).size();
        }
        myFirstAddress.writeToFile();
        int countAfterWrite = Files.readAllLines(path).size();
        int linesAdded=countAfterWrite - countBeforeWrite;
        assertEquals(1,linesAdded);
    }

    @Test
    public void appendingAddressToExistingReadOnlyFileShouldThrowIOException() throws IOException {
        Path path = Address.getFilePath();
        File file = path.toFile();
        if (!Files.exists(path)) {
            file.createNewFile();
        }
        file.setReadOnly();
        myFirstAddress.writeToFile();
    }
}