import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.sql.Date;
import java.util.List;


public class PersonDatabaseTest {
    File file = new File("C:\\Users\\Admin\\IdeaProjects\\Assign4\\src");
    PersonDatabase database = new PersonDatabase(file);

    @Test
    public void sortedByFirstName()
    {
        List<Person> res = database.sortedByFirstName();
        Assert.assertEquals("Ally", res.get(0).get_firstName());
        Assert.assertEquals("Carla", res.get(1).get_firstName());
    }

    @Test
    public void sortedBySurnameFirstNameAndBirthdate() {
        List<Person> res = database.sortedBySurnameFirstNameAndBirthdate();
        Assert.assertEquals(Date.valueOf("1993-12-10"), res.get(3).get_birthdate());
        Assert.assertEquals("Phone", res.get(7).get_surname());
    }

    @Test
    public void sortedByBirthdate() {
        List<Person> res = database.sortedByBirthdate();
        Assert.assertEquals(Date.valueOf("1958-04-15"), res.get(0).get_birthdate());
        Assert.assertEquals(Date.valueOf("1999-07-09"), res.get(7).get_birthdate());
    }

    @Test
    public void bornOdDay() {
        List<Person> res = database.bornOnDay(Date.valueOf("1964-03-12"));
        Assert.assertEquals(1, res.size());
        Assert.assertEquals("Kelly Machinegun", res.get(0).get_firstName() + " " + res.get(0).get_surname());

    }
}
