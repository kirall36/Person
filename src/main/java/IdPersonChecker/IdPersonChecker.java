package IdPersonChecker;

import Person.Person;
import PersonChecker.PersonChecker;
import com.sun.javafx.scene.layout.region.Margins;

/**
 * Created by Кирилл on 25.11.2018.
 */
public class IdPersonChecker implements PersonChecker{

    public boolean check(Person p, Object id)
    {
        return p.getId() == Integer.valueOf(id.toString());
    }
}
