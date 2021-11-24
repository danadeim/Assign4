import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {
    private final List<Person> people;
    Map<Date, List<Person>> qfil = new HashMap<>();

    public PersonDatabase(File file) {
        people = InputParser.parse(file);
        qfil = people.stream().collect(Collectors.groupingBy(Person::get_birthdate));
        Set<Date> setDate = qfil.keySet();
    }
    public List<Person> sortedByFirstName() {
        people.sort(new FirstNameComparator());
        return people;
        // external rule for ordering (based on Comparator --- FirstNameComparator)
    }

    public List<Person> sortedBySurnameFirstNameAndBirthdate() {
        Collections.sort(people);
        return people;
        // natural order (Comparable)
    }

    public List<Person> sortedByBirthdate() {
        people.sort(new BirthdateComparator());
        return people;
        // external rule for ordering (based on Comparator --- BirthdateComparator)
    }

    public List<Person> bornOnDay(Date born) {
        people.sort(new BirthdateComparator());
        return people;
    }
}