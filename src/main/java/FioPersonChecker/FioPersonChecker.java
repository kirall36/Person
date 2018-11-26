package FioPersonChecker;

import Person.Person;
import PersonChecker.PersonChecker;

/**
 * Created by Кирилл on 25.11.2018.
 */
/**
 * Класс чекера для проверки соответствия Фио
 * @author Кирилл
 */
public class FioPersonChecker implements PersonChecker {

    /***
     * Функция для проверки соответсвия поля объекта человека и переданного значения
     * @param p - объект человека
     * @param Fio - проверяемое значения Фио
     * @return Возвращает true, если значение равно, false в другом случае
     */
    public boolean check(Person p, Object Fio)
    {
        return p.getFio().equals(Fio);
    }
}
