package FioPersonComparator;

import Person.Person;
import PersonComparator.PersonComparator;

/**
 * Created by Кирилл on 25.11.2018.
 */
public class FioPersonComparator implements PersonComparator{

    public int compare(Person p1, Person p2)
    {
        return p1.getFio().compareTo(p2.getFio());
    }
}
