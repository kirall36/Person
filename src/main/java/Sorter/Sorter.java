package Sorter;

import PersonComparator.PersonComparator;
import PersonStorage.PersonStorage;

/**
 * Интерфейс Сортера для сортировки
 * Created by Кирилл on 17.12.2018.
 */
public interface Sorter {
    /***
     * Функция сортирующая список людей, используя определенный компоратор
     * @param pc - объект компоратора, по которому ведется сортировка
     * @param ps - объукт коллекции людей
     * @return Возвращает true, если значение равно, false в другом случае
     */
    void sort(PersonComparator pc, PersonStorage ps);
}
