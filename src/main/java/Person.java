/**
 * Created by Кирилл on 11.11.2018.
 */
import org.joda.time.LocalDate;
import org.joda.time.Years;

/**
 * Класс человека со свойствами <b>Уникальный идентификатор</b>, <b>ФИО</b>, <b>Пол</b>, <b>Возраст</b>
 * @author Кирилл
 * @version 1.0
 */
public class Person {

    /** Поле уникальный идентификатор */
    private int id;
    /** Поле ФИО*/
    private String fio;
    /** Поле Пол*/
    private char sex;
    /** Поле Дата рождения*/
    private LocalDate date_of_birth;

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - уникальный ифентификатор
     * @param fio - ФИО
     * @param sex - Пол
     * @param date_of_birth - Дата рождения
     */
    public Person(int id, String fio, char sex, LocalDate date_of_birth)
    {
        this.id = id;
        this.fio = fio;
        this.sex = sex;
        this.date_of_birth = date_of_birth;
    }

    /**
     * Функция для получения значения поля {@link Person#id}
     * @return возвращает уникальный идентификатор
     */
    public int getId()
    {
        return id;
    }

    /**
     * Функция для уменьшения значения поля {@link Person#id} на единицу
     */
    public void deductId()
    {
        id--;
    }

    /**
     * Функция для получения значения поля {@link Person#fio}
     * @return возвращает ФИО
     */
    public String getFio()
    {
        return fio;
    }

    /**
     * Функция для получения значения поля {@link Person#sex}
     * @return возвращает Пол
     */
    public char getSex() {
        return sex;
    }

    /**
     * Функция для получения значения поля {@link Person#date_of_birth}
     * @return возвращает Дату рождения
     */
    public LocalDate getDate_of_birth() {
        return date_of_birth;
    }

    /**
     * Функция для получения возраста в годах
     * @return возвращает количество полных лет
     */
    public int getAge()
    {
        return Years.yearsBetween(date_of_birth, new LocalDate()).getYears();
    }

    /**
     * Функция для вывода информации о человеке,
     * печает значения полей {@link Person#id}, {@link Person#fio}, {@link Person#sex}, {@link Person#date_of_birth} и колчичество полных лет {@link Person#getAge()}
     */
    public void showInfo()
    {
        System.out.printf("id = %d, fio = %s, sex = %c, date of birth = %s, years = %d \n", id, fio, sex, date_of_birth.toString(), getAge());
    }
}
