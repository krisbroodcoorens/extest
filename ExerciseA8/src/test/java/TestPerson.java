import be.abis.exercise.exception.PersonShouldBeOlderThan18Exception;
import be.abis.exercise.model.Person;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class TestPerson
{
    Person myPerson;
    Person mySecondPerson;

    @Before
    public void setUp()
    {
        //Recreate the person before each test
        myPerson = new Person(1234, "Nathalie", "Moerman", LocalDate.of(2000, 6, 28));
        mySecondPerson = new Person(4567, "Stefan,", "Degand", LocalDate.of(2007, 6, 28));
    }

    @Test
    public void personShouldBe44YearsOld() throws PersonShouldBeOlderThan18Exception
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

    @Test(expected=PersonShouldBeOlderThan18Exception.class)
    public void throwExceptionWhenPersonIsYoungerThan18 () throws PersonShouldBeOlderThan18Exception
    {
        mySecondPerson.calculateAge();
        System.out.print(mySecondPerson.calculateAge());
    }
}