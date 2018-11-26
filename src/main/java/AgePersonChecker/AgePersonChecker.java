package AgePersonChecker;

import Person.Person;
import PersonChecker.PersonChecker;

/**
 * Created by Кирилл on 25.11.2018.
 */
/**
 * Класс чекера для проверки соответствия возраста
 * @author Кирилл
 */
public class AgePersonChecker implements PersonChecker {

    /***
     * Функция для проверки соответсвия поля объекта человека и переданного значения
     * @param p - объект человека
     * @param age - проверяемое значения возраста
     * @return Возвращает true, если значение равно, false в другом случае
     */
    public boolean check(Person p, Object age)
    {
        return p.getAge() == Integer.valueOf(age.toString());
    }
}
