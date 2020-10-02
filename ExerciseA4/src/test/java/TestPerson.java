import be.abis.exercise.model.Person;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestPerson
{
    @Test
    public void personShouldBe44YearsOld()
    {
        //Arrange
        int expected = 44;
        Person myPerson = new Person(1234,"Nathalie","Moerman", LocalDate.of(1976, 6, 28));

        //Act
        int calculatedAge = myPerson.calculateAge();

        //AssertEquals
        assertEquals(expected, calculatedAge);

        //AssertThat
        assertThat(calculatedAge,is(expected));

    }
}