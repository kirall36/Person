package IdPersonComporator;

import Person.Person;
import PersonComparator.PersonComparator;

/**
 * Created by Кирилл on 25.11.2018.
 */
public class IdPersonComparator implements PersonComparator {

    public int compare(Person p1, Person p2)
    {
        return new Integer(p1.getId()).compareTo(p2.getId());
    }
}
