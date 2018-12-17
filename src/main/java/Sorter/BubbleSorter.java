package Sorter;

import Person.Person;
import PersonComparator.PersonComparator;
import PersonStorage.PersonStorage;
import org.apache.log4j.Logger;

/**
 * Created by Кирилл on 17.12.2018.
 */
public class BubbleSorter implements Sorter {
    /**Поле Логера*/
    private static final Logger log = Logger.getLogger(BubbleSorter.class);

    /**
     * Функция пузырьковой сортировки
     * @param pc - компоратор, в соответсвии с которым происходит сортировка
     */
    public void sort(PersonComparator pc, PersonStorage ps) {
        log.info("sort Storage with BubbleSorter by " + pc.toString());
        int i = 0;
        int goodPairsCounter = 0;
        while (true) {
            if (pc.compare(ps.people[i], ps.people[i + 1]) >= 1) {
                Person q = ps.people[i];
                ps.people[i] = ps.people[i + 1];
                ps.people[i + 1] = q;
                goodPairsCounter = 0;
            } else {
                goodPairsCounter++;
            }
            i++;
            if (i == ps.length() - 1) {
                i = 0;
            }
            if (goodPairsCounter == ps.length() - 1) break;
        }
        ps.changeIds();
        System.out.println("Array after the sort:");
        ps.showAllPersons();
    }
}
