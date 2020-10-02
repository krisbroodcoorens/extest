import be.abis.exercise.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

public class TestPerson
{
    @Test
    public void personShouldBe44YearsOld()
    {
        //Arrange
        int expected = 44;
        Person myPerson = new Person(1234,"Nathalie","Moerman", LocalDate.of(1981, 6, 28));

        //Act
        int calculatedAge = myPerson.calculateAge();

        //Assert
        assertEquals(expected, calculatedAge);
    }
}