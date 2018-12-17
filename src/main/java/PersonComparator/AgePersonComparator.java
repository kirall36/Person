package PersonComparator;

import Person.Person;
import org.apache.log4j.Logger;

/**
 * Created by Кирилл on 25.11.2018.
 */
/***
 * Класс компоратора для проверки возраста
 * @author Кирилл
 */
public class AgePersonComparator implements PersonComparator {

    /**Поле Логера*/
    private static final Logger log = Logger.getLogger(AgePersonComparator.class);

    /***
     * Функция для проверки величины возраста двух людей
     * @param p1 - объект 1 человека
     * @param p2 - объект 2 человека
     * @return Возвращает 1, если значение p1 больше p2, 0, если равны, -1 в другом случае
     */
    public int compare(Person p1, Person p2)
    {
        log.debug("compare Person1: " + p1.getAge() + " with Person2:" + p2.getAge() + " by age");
        return new Integer(p1.getAge()).compareTo(p2.getAge());
    }
}
