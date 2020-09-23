package computershop.tests;

import computershop.person.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonTest {
    private Person person;
    @BeforeEach
    public void init() {
        person = new Person("mike");
    }

    @Test
    public void getName() {
        assertEquals("mike", person.getName());
    }

    @Test
    public void getBudget() {
        person.setBudget(100);
        assertEquals(100, person.getBudget());
    }

    @Test
    public void setName() {
        person.setName("alex");
        assertEquals("alex", person.getName());
    }
}
