package DatePersonComparator;

import Person.Person;
import PersonComparator.PersonComparator;

/**
 * Created by Кирилл on 25.11.2018.
 */
public class DatePersonComparator implements PersonComparator {

    public int compare(Person p1, Person p2) {
        return p1.getDate_of_birth().compareTo(p2.getDate_of_birth());
    }
}
