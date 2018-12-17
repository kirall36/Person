package PersonChecker;

import Person.Person;
import org.apache.log4j.Logger;

/**
 * Created by Кирилл on 25.11.2018.
 */
/**
 * Класс чекера для проверки соответствия возраста
 * @author Кирилл
 */
public class AgePersonChecker implements PersonChecker {
    /**Поле Логера*/
    private static final Logger log = Logger.getLogger(AgePersonChecker.class);

    /***
     * Функция для проверки соответсвия поля объекта человека и переданного значения
     * @param p - объект человека
     * @param age - проверяемое значения возраста
     * @return Возвращает true, если значение равно, false в другом случае
     */
    public boolean check(Person p, Object age)
    {
        log.info("check Person " + p.getAge() + " with " + age.toString());
        return p.getAge() == Integer.valueOf(age.toString());
    }
}
