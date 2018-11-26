package PersonChecker;

import Person.Person;

/**
 * Created by Кирилл on 25.11.2018.
 */

/***
 * Интерфейс чекера для проверки соответствия
 * @author Кирилл
 */
public interface PersonChecker {
    /***
     * Функция для проверки соответсвия поля объекта человека и переданного значения
     * @param p - объект человека
     * @param obj - проверяемое значения
     * @return Возвращает true, если значение равно, false в другом случае
     */
    boolean check(Person p, Object obj);
}
