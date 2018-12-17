package PersonChecker;

import Person.Person;
import org.apache.log4j.Logger;

/**
 * Created by Кирилл on 25.11.2018.
 */
/**
 * Класс чекера для проверки соответствия даты рождения
 * @author Кирилл
 */
public class DatePersoneChecker implements PersonChecker{
    /**Поле Логера*/
    private static final Logger log = Logger.getLogger(DatePersoneChecker.class);

    /***
     * Функция для проверки соответсвия поля объекта человека и переданного значения
     * @param p - объект человека
     * @param date - проверяемое значения даты рождения
     * @return Возвращает true, если значение равно, false в другом случае
     */
    public boolean check(Person p, Object date)
    {
        log.info("check Person " + p.getDate_of_birth() + " with " + date.toString());
        return p.getDate_of_birth().equals(date);
    }
}
