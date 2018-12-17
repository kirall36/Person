package PersonChecker;

import Person.Person;
import org.apache.log4j.Logger;

/**
 * Created by Кирилл on 25.11.2018.
 */

/**
 * Класс чекера для проверки соответствия id
 * @author Кирилл
 */
public class IdPersonChecker implements PersonChecker{
    /**Поле Логера*/
    private static final Logger log = Logger.getLogger(IdPersonChecker.class);
    /***
     * Функция для проверки соответсвия поля объекта человека и переданного значения
     * @param p - объект человека
     * @param id - проверяемое значения уникального идентификатора
     * @return Возвращает true, если значение равно, false в другом случае
     */
    public boolean check(Person p, Object id)
    {
        log.info("check Person " + p.getId() + " with " + id.toString());
        return p.getId() == Integer.valueOf(id.toString());
    }
}
