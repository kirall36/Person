package FioPersonChecker;

import Person.Person;
import PersonChecker.PersonChecker;

/**
 * Created by Кирилл on 25.11.2018.
 */
public class FioPersonChecker implements PersonChecker {

    public boolean check(Person p, Object Fio)
    {
        return p.getFio().equals(Fio);
    }
}
