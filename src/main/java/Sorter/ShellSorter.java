package Sorter;

import Person.Person;
import PersonComparator.PersonComparator;
import PersonStorage.PersonStorage;
import org.apache.log4j.Logger;

/**
 * Created by Кирилл on 17.12.2018.
 */
public class ShellSorter implements Sorter {
    /**Поле Логера*/
    private static final Logger log = Logger.getLogger(ShellSorter.class);

    /**
     * Функция сортировки Шелла
     * @param pc - компоратор, в соответсвии с которым происходит сортировка
     *
     */
    public void sort(PersonComparator pc, PersonStorage ps){
        log.info("sort Storage with ShellSorter by " + pc.toString());
        int j;
        for( int gap = ps.length() / 2; gap > 0; gap /= 2 ){
            for(int i=gap;i< ps.length();i++){
                Person temp = ps.people[i];
                for (j = i; j >= gap && pc.compare(ps.people[j - gap], temp) >= 1; j -= gap)
                {
                    ps.people[j] = ps.people[j - gap];
                }
                ps.people[j] = temp;
            }
        }
        ps.changeIds();
        System.out.println("Array after the sort:");
        ps.showAllPersons();
    }
}
