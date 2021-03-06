import be.abis.exercise.exception.PersonShouldBeOlderThan18Exception;
import be.abis.exercise.model.Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestPerson
{
    Person myPerson;
    Person mySecondPerson;

    @BeforeEach
    public void setUp()
    {
        //Recreate the person before each test
        myPerson = new Person(1234, "Nathalie", "Moerman", LocalDate.of(1976, 6, 28));
        mySecondPerson = new Person(4567, "Stefan,", "Degand", LocalDate.of(1976, 6, 28));
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

    @Test
    public void throwExceptionWhenPersonIsYoungerThan18 () throws PersonShouldBeOlderThan18Exception
    {
        mySecondPerson.calculateAge();
        System.out.print(mySecondPerson.calculateAge());
    }
}