package DatePersonChecker;

import Person.Person;
import PersonChecker.PersonChecker;

/**
 * Created by Кирилл on 25.11.2018.
 */
public class DatePersoneChecker implements PersonChecker{
    public boolean check(Person p, Object date)
    {
        return p.getDate_of_birth().equals(date);
    }
}
