import be.abis.exercise.exception.PersonShouldBeOlderThan18Exception;
import be.abis.exercise.model.Company;
import be.abis.exercise.model.Person;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class TestPerson
{
    Person myPerson;
    Person mySecondPerson;

    @Mock
    Company myMockCompany;

    @Before
    public void setUp()
    {
        //Recreate the person before each test
        myPerson = new Person(123, "Nathalie", "Moerman", LocalDate.of(1976, 6, 28));
        mySecondPerson = new Person(456, "Stefan,", "Degand", LocalDate.of(1976, 6, 28));
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
        assertThat(calculatedAge, is(expected));
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

    @Test
    public void calculateNetSalaryOfBelgianPersonUsingMockCompany()
    {
        Person myThirdPerson = new Person(987, "Peter", "Verstappen", LocalDate.of(1964, 8, 20),myMockCompany);
        myThirdPerson.setGrossSalary(4500);
        when(myMockCompany.calculateTaxToPay()).thenReturn(51.0);
        assertEquals(myThirdPerson.calculateSalary(), 2105, 0.01);
        verify(myMockCompany,times(1)).calculateTaxToPay();
    }
}