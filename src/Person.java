import java.util.Date;

public final class Person implements Comparable<Person> {

    private final String _firstName;
    private final String _surname;
    private final Date _birthdate;

    public Person(String firstName, String surname, Date birthdate) {
        _firstName = firstName;
        _surname = surname;
        _birthdate = birthdate;
    }
    public String get_firstName() {
        return _firstName;
    }

    public String get_surname() {
        return _surname;
    }

    public Date get_birthdate() {
        return _birthdate;
    }

    @Override
    public int compareTo(Person person2) {
        int res = _surname.compareTo(person2.get_surname());
        if (res != 0)
            return res;
        res = _firstName.compareTo(person2.get_firstName());
        if (res != 0)
            return res;
        return _birthdate.compareTo(person2.get_birthdate());
        // natural order based on:
        // (1) surname;
        // (2) first name;
        // (3) birth date.
    }
}