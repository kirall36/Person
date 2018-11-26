package IdPersonChecker;

import Person.Person;
import PersonChecker.PersonChecker;
import com.sun.javafx.scene.layout.region.Margins;

/**
 * Created by Кирилл on 25.11.2018.
 */

/**
 * Класс чекера для проверки соответствия id
 * @author Кирилл
 */
public class IdPersonChecker implements PersonChecker{

    /***
     * Функция для проверки соответсвия поля объекта человека и переданного значения
     * @param p - объект человека
     * @param id - проверяемое значения уникального идентификатора
     * @return Возвращает true, если значение равно, false в другом случае
     */
    public boolean check(Person p, Object id)
    {
        return p.getId() == Integer.valueOf(id.toString());
    }
}
