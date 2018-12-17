package Sorter;

import Person.Person;
import PersonComparator.PersonComparator;
import PersonStorage.PersonStorage;
import org.apache.log4j.Logger;

/**
 * Created by Кирилл on 17.12.2018.
 */
public class InsertSorter implements Sorter {
    /**Поле Логера*/
    private static final Logger log = Logger.getLogger(InsertSorter.class);

    /**
     * Функция сортировки вставками
     * @param pc - компоратор, в соответсвии с которым происходит сортировка
     */
    public void sort(PersonComparator pc, PersonStorage ps) {
        log.info("sort Storage with InsertSorter by " + pc.toString());
        Person temp;
        int j;
        for(int i = 0; i < ps.length() - 1; i++){
            if ( pc.compare(ps.people[i], ps.people[i + 1]) >=1) {
                temp = ps.people[i + 1];
                ps.people[i + 1] = ps.people[i];
                j = i;
                while (j > 0 && pc.compare(temp, ps.people[j - 1]) <=-1) {
                    ps.people[j] = ps.people[j - 1];
                    j--;
                }
                ps.people[j] = temp;
            }
        }
        ps.changeIds();
        System.out.println("Array after the sort:");
        ps.showAllPersons();
    }
}
