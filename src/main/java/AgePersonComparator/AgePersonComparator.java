package AgePersonComparator;

import Person.Person;
import PersonComparator.PersonComparator;

/**
 * Created by Кирилл on 25.11.2018.
 */
/***
 * Класс компоратора для проверки возраста
 * @author Кирилл
 */
public class AgePersonComparator implements PersonComparator {

    /***
     * Функция для проверки величины возраста двух людей
     * @param p1 - объект 1 человека
     * @param p2 - объект 2 человека
     * @return Возвращает 1, если значение p1 больше p2, 0, если равны, -1 в другом случае
     */
    public int compare(Person p1, Person p2)
    {
        return new Integer(p1.getAge()).compareTo(p2.getAge());
    }
}
