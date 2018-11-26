package DatePersonChecker;

import Person.Person;
import PersonChecker.PersonChecker;

/**
 * Created by Кирилл on 25.11.2018.
 */
/**
 * Класс чекера для проверки соответствия даты рождения
 * @author Кирилл
 */
public class DatePersoneChecker implements PersonChecker{

    /***
     * Функция для проверки соответсвия поля объекта человека и переданного значения
     * @param p - объект человека
     * @param date - проверяемое значения даты рождения
     * @return Возвращает true, если значение равно, false в другом случае
     */
    public boolean check(Person p, Object date)
    {
        return p.getDate_of_birth().equals(date);
    }
}
