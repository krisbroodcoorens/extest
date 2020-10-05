import be.abis.exercise.exception.PersonShouldBeOlderThan18Exception;
import be.abis.exercise.model.Person;
import org.junit.jupiter.api.*;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Person class - Unit Tests")
public class TestPerson
{
    Person myPerson;
    Person mySecondPerson;

    @BeforeEach
    public void setUp() {
        //Recreate the person before each test
        myPerson = new Person(1234, "Nathalie", "Moerman", LocalDate.of(1976, 6, 28));
        mySecondPerson = new Person(4567, "Stefan,", "Degand", LocalDate.of(1976, 6, 28));
    }

    @Nested
    @Tag("Test")
    @DisplayName("Tests concerning age of the person")
    class ageTest
    {
        @Test
        @DisplayName("This if calculated age it equal to the expected age")
        public void personShouldBe44YearsOld() throws PersonShouldBeOlderThan18Exception
        {
            //Arrange
            int expected = 44;

            //Act
            int calculatedAge = myPerson.calculateAge();

            //AssertEquals
            assertEquals(expected, calculatedAge);

            //AssertThat
            assertThat(calculatedAge, is(expected));
        }

        @Test
        @DisplayName("Test if exception is thrown when person is younger than 18")
        public void throwExceptionWhenPersonIsYoungerThan18() throws PersonShouldBeOlderThan18Exception
        {
            Throwable exception = assertThrows(PersonShouldBeOlderThan18Exception.class, () -> mySecondPerson.calculateAge());
            assertEquals("Person is younger than 18", exception.getMessage());
        }
    }

    @Test
    @DisplayName("Test outcome of method ofString()")
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