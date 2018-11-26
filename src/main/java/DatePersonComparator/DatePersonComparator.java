package DatePersonComparator;

import Person.Person;
import PersonComparator.PersonComparator;

/**
 * Created by Кирилл on 25.11.2018.
 */
/***
 * Класс компоратора для проверки даты рождения
 * @author Кирилл
 */
public class DatePersonComparator implements PersonComparator {

    public int compare(Person p1, Person p2) {
        /***
         * Функция для проверки величины даты рождения двух людей
         * @param p1 - объект 1 человека
         * @param p2 - объект 2 человека
         * @return Возвращает 1, если значение p1 больше p2, 0, если равны, -1 в другом случае
         */
        return p1.getDate_of_birth().compareTo(p2.getDate_of_birth());
    }
}
