package AgePersonComparator;

import Person.Person;
import PersonComparator.PersonComparator;

/**
 * Created by Кирилл on 25.11.2018.
 */
public class AgePersonComparator implements PersonComparator {

    public int compare(Person p1, Person p2)
    {
        return new Integer(p1.getAge()).compareTo(p2.getAge());
    }
}
