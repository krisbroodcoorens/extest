import be.abis.exercise.model.Person;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestPerson
{
    Person myPerson;

    @Before
    public void setUp()
    {
        //Recreate the person before each test
        myPerson = new Person(1234, "Nathalie", "Moerman", LocalDate.of(1976, 6, 28));
    }

    @Test
    public void personShouldBe44YearsOld()
    {
        //Arrange
        int expected = 44;

        //Act
        int calculatedAge = myPerson.calculateAge();

        //AssertEquals
        assertEquals(expected, calculatedAge);

        //AssertThat
        assertThat(calculatedAge,is(expected));

    }

    @Test
    public void toStringSentenceStartWithPerson()
    {
        //Arrange
        String expectedStringName = "Person " +myPerson.getFirstName()+ " " +myPerson.getLastName();
        System.out.println(expectedStringName);

        //Act
        String actualStringName = myPerson.toString();
        System.out.println(actualStringName);

        //AssertThat
        assertThat(actualStringName, startsWith(expectedStringName));
    }
}