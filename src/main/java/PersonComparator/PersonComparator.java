package PersonComparator;

import Person.Person;

/**
 * Created by Кирилл on 25.11.2018.
 */
/***
 * Интерфейс компоратора для проверки величины определенного значения
 * @author Кирилл
 */
public interface PersonComparator {
    /***
     * Функция для проверки величины определенного поля 2 людей
     * @param p1 - объект 1 человека
     * @param p2 - объект 2 человека
     * @return Возвращает 1, если значение p1 больше p2, 0, если равны, -1 в другом случае
     */
    int compare(Person p1, Person p2);
}
