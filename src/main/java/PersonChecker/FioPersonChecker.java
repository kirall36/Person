package PersonChecker;

import Person.Person;
import org.apache.log4j.Logger;

/**
 * Created by Кирилл on 25.11.2018.
 */
/**
 * Класс чекера для проверки соответствия Фио
 * @author Кирилл
 */
public class FioPersonChecker implements PersonChecker {
    /**Поле Логера*/
    private static final Logger log = Logger.getLogger(FioPersonChecker.class);

    /***
     * Функция для проверки соответсвия поля объекта человека и переданного значения
     * @param p - объект человека
     * @param Fio - проверяемое значения Фио
     * @return Возвращает true, если значение равно, false в другом случае
     */
    public boolean check(Person p, Object Fio)
    {
        log.info("check Person " + p.getFio() + " with " + Fio.toString());
        return p.getFio().equals(Fio);
    }
}
