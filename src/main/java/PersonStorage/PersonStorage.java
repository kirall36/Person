package PersonStorage;

import Inject.Inject;
import Person.Person;
import Inject.Injector;
import PersonChecker.PersonChecker;
import PersonComparator.PersonComparator;
import Sorter.Sorter;
import org.apache.log4j.Logger;

import java.util.Comparator;

/**
 * Created by Кирилл on 11.11.2018.
 * + Переделать addPerson - должен принимать экземпляр Person
 * + Создать интерфейс Sorter с методом sort, его реализовать в трех классах для определенного типа сортировки.
 * Убрать все System.out.print(), где это не нужно
 */

/**
 * Класс коллекции, в которой хранятся люди со свойством <b>Длина</b>
 * @author Кирилл
 * @version 1.0
 */
public class PersonStorage {

    /** Поле массив людей*/
    public Person[] people;

    /**Поле сортера*/
    @Inject
    private Sorter sorter = null;

    /**Поле Логера*/
    private static final Logger log = Logger.getLogger(PersonStorage.class);

    /** Поле последний уникальный идентификатор
     * Необходимо для добавления, удаления и выборки людей*/
    private int last_id;

    /**
     * Конструктор - создание нового объекта коллекции людей
     */
    public PersonStorage()
    {
        log.info("init Storage");
        people = new Person[10];
        last_id = 0;
        new Injector().dosomething(this);
    }

    /**
     * Функция для получения значения количества людей в коллекции
     * @return возвращает количество людей
     */
    public int length()
    {
        log.info("get Srorage's length");
        return last_id;
    }


    /**
     * Функция для получения добавления человека в коллекцию
     * @param fio - ФИО
     * @param sex - Пол
     * @param date_of_birth - Дата рождения
     */
    public void addPerson(Person person)
    {
        log.info("add new Person" + person.getId() + " " + person.getFio() + " " + person.getSex() + " " + person.getDate_of_birth() + " " + "in Storage");
        if(last_id == people.length) expand();
        person.setId(last_id);
        people[last_id] = person;
        last_id++;
    }

    /**
     * Функция для удаления пользователя по уникальному идентификатору
     * @param id - уникальный идентификатор
     */
    public void deletePerson(int id)
    {
        log.info("delete a Person" + id + people[id].getFio() + " " + people[id].getSex() + " " + people[id].getDate_of_birth() + " " + "from Storage");
        if(last_id % 10 == 0) reduce();
        Person[] new_people =  new Person[people.length];
        last_id--;

        for(int i = 0; i < id; i++)
        {
            new_people[i] = people[i];
        }
        new_people[id] = people[id+1];
        new_people[id].deductId();
        for(int i = id+1; i < last_id; i++) {
            new_people[i] = people[i+1];
            new_people[i].deductId();
        }
        people = new_people;
    }

    /**
     * Функция для получения определенного человеке по уникальному идентификатору
     * @param id - уникальный идентификатор
     */
    public Person get(int id)
    {
        log.info("get Person with id " + id);
        return people[id];
    }

    /**
     * Функция для вывода информации обо всех людях в коллекции
     * Вызывает {@link Person#showInfo()}
     */
    public void showAllPersons()
    {
        log.info("show all persons");
        for(int i = 0; i < last_id; i++)
        {
           people[i].showInfo();
        }
    }

    /**
     * Функция для перезаписывания всех уникальных идентификаторов в порядке возрастания
     */
    public void changeIds()
    {
        log.info("changing ids in Storage");
        for(int j = 0; j < length(); j++)
        {
            people[j].changeId(j);
        }
    }

    /**
     * Функуция для поиска людей в коллекции
     * @param pc - экземпляр чекера, по которому будет весьтись поиск
     * @param value - значения для сравнения
     */
    public PersonStorage searchPersons(PersonChecker pc, Object value)
    {
        log.debug("search Persons by " + pc.toString() + " and " + value.toString());
        boolean found = false;
        PersonStorage searchedpeople = new PersonStorage();
        for(int i = 0; i < last_id; i++)
        {
            if(pc.check(people[i], value))
            {
                searchedpeople.addPerson(people[i]);
                found = true;
            }
        }
        if(!found) System.out.println("Not found!"); //!!!Переделать
        return searchedpeople;
    }

    /**
     * Функция-сеттер для сортера
     * @param sorter
     */
    public void setSorter(Sorter sorter) {
        log.info("set sorter to " + sorter.toString());
        this.sorter = sorter;
    }

    /**
     * Функция, возвращающая сортер
     * @return sorter
     */
    public Sorter getSorter() {
        log.info("get sorter");
        return this.sorter;
    }

    /**
     * Функция, выполняющая сортировку
     * @param comparator
     */
    public void sort(PersonComparator pc) {
        log.info("sort Repository  with " + this.sorter.toString() + " by " + pc.toString());
        sorter.sort(pc, this);
    }

    /**
     * Функция для увеличения размера коллекции на 10
     */
    private void expand()
    {
        log.info("expand Storage by 10");
        Person[] new_people = new Person[people.length + 10];

        for(int i = 0; i < people.length; i++)
             new_people[i] = people[i];
        people = new_people;
    }

    /**
     * Функция для уменьшения размера коллекции на 10
     */
    private void reduce()
    {
        log.info("reduce Storage by 10");
        Person[] new_people = new Person[people.length - 10];

        for(int i = 0; i < people.length-10; i++)
            new_people[i] = people[i];
        people = new_people;
    }
}
