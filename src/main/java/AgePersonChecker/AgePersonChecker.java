package AgePersonChecker;

import Person.Person;
import PersonChecker.PersonChecker;

/**
 * Created by Кирилл on 25.11.2018.
 */
public class AgePersonChecker implements PersonChecker {
    public boolean check(Person p, Object age)
    {
        return p.getAge() == Integer.valueOf(age.toString());
    }
}
