package PersonStorage;

import Person.Person;
import PersonChecker.PersonChecker;
import org.joda.time.LocalDate;

/**
 * Created by Кирилл on 11.11.2018.
 */

/**
 * Класс коллекции, в которой хранятся люди со свойством <b>Длина</b>
 * @author Кирилл
 * @version 1.0
 */
public class PersonStorage {

    /** Поле массив людей*/
    public Person[] people;
    /** Поле последний уникальный идентификатор
     * Необходимо для добавления, удаления и выборки людей*/
    private int last_id;

    /**
     * Конструктор - создание нового объекта коллекции людей
     */
    public PersonStorage()
    {
        people = new Person[10];
        last_id = 0;
    }

    /**
     * Функция для получения значения количества людей в коллекции
     * @return возвращает количество людей
     */
    public int length()
    {
        return last_id;
    }


    /**
     * Функция для получения добавления человека в коллекцию
     * @param fio - ФИО
     * @param sex - Пол
     * @param date_of_birth - Дата рождения
     */
    public void addPerson(String fio, char sex, LocalDate date_of_birth)
    {
        if(last_id == people.length) expand();
        people[last_id] = new Person(last_id, fio, sex, date_of_birth);
        System.out.printf("Added new Person.Person ");
        people[last_id].showInfo();
        last_id++;
    }

    /**
     * Функция для удаления пользователя по уникальному идентификатору
     * Ghjdthjdkf
     * @param id - уникальный идентификатор
     */
    public void deletePerson(int id)
    {
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
     * Функция для вывода информации об определенном человеке по уникальному идентификатору
     * Вызывает {@link Person#showInfo()}
     * @param id - уникальный идентификатор
     */
    public void showPerson(int id)
    {
        people[id].showInfo();
    }

    /**
     * Функция для вывода информации обо всех людях в коллекции
     * Вызывает {@link Person#showInfo()}
     */
    public void showAllPersons()
    {
        for(int i = 0; i < last_id; i++)
        {
           people[i].showInfo();
        }
    }

    public void searchPersons(PersonChecker pc, Object value)
    {
        for(int i = 0; i < last_id; i++)
        {
            if(pc.check(people[i], value))
            {
                people[i].showInfo();
            }
        }
    }

    /**
     * Функция для увеличения размера коллекции на 10
     */
    private void expand()
    {
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
        Person[] new_people = new Person[people.length - 10];

        for(int i = 0; i < people.length-10; i++)
            new_people[i] = people[i];
        people = new_people;
    }
}
