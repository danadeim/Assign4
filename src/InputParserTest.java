import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;


public final class InputParserTest {
    File file = new File("C:\\Users\\Admin\\IdeaProjects\\Assign4\\src");
    List<Person> people;

    @Test
    public void InputParser() throws ParseException {
        people = InputParser.parse(file);
        Assert.assertEquals("George", people.get(0).get_firstName());
        Assert.assertEquals("Archer", people.get(0).get_surname());
        Assert.assertEquals(8, people.size());
        Assert.assertEquals(new SimpleDateFormat("yyyy-MM-dd").parse("1988-12-21"), people.get(0).get_birthdate());
    }
}