package Person; /**
 * Created by Кирилл on 11.11.2018.
 */
import org.joda.time.LocalDate;
import org.joda.time.Years;
import org.apache.log4j.Logger;

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

    /**Поле Логера*/
    private static final Logger log = Logger.getLogger(Person.class);

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param id - уникальный ифентификатор
     * @param fio - ФИО
     * @param sex - Пол
     * @param date_of_birth - Дата рождения
     */
    public Person(int id, String fio, char sex, LocalDate date_of_birth)
    {
        log.debug("init Person");
        this.id = id;
        this.fio = fio;
        this.sex = sex;
        this.date_of_birth = date_of_birth;
    }

    /**
     * Конструктор - создание нового объекта с определенными значениями
     * @param fio - ФИО
     * @param sex - Пол
     * @param date_of_birth - Дата рождения
     */
    public Person(String fio, char sex, LocalDate date_of_birth)
    {
        log.debug("init Person without id");
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
        log.debug("get Person's id");
        return id;
    }

    /**
     * Функция для установки значения поля {@link Person#id}
     */
    public void setId(int id) {
        log.debug("set Person's id to " + id);
        this.id = id; }

    /**
     * Функция для уменьшения значения поля {@link Person#id} на единицу
     */
    public void deductId()
    {
        log.debug("deducting Person's id");
        id--;
    }

    /**
     * Функция для изменения значения поля {@link Person#id} на новое значение new_id
     * @param new_id - новое значение
     */
    public void changeId(int new_id) {
        log.debug("changing Person's id from " + id + " to " + new_id);
        id = new_id;
    }

    /**
     * Функция для получения значения поля {@link Person#fio}
     * @return возвращает ФИО
     */
    public String getFio()
    {
        log.debug("get Person's fio");
        return fio;
    }

    /**
     * Функция для получения значения поля {@link Person#sex}
     * @return возвращает Пол
     */
    public char getSex() {
        log.debug("get Person's sex");
        return sex;
    }

    /**
     * Функция для получения значения поля {@link Person#date_of_birth}
     * @return возвращает Дату рождения
     */
    public LocalDate getDate_of_birth() {
        log.debug("get Person's date of birth");
        return date_of_birth;
    }

    /**
     * Функция для получения возраста в годах
     * @return возвращает количество полных лет
     */
    public int getAge()
    {
        log.debug("get Person's age");
        return Years.yearsBetween(date_of_birth, new LocalDate()).getYears();
    }

    /**
     * Функция для вывода информации о человеке,
     * печает значения полей {@link Person#id}, {@link Person#fio}, {@link Person#sex}, {@link Person#date_of_birth} и колчичество полных лет {@link Person#getAge()}
     */
    public void showInfo()
    {
        log.debug("print Person " + getId() + " " + getFio() + " " + getSex() + " " + getDate_of_birth());
        System.out.printf("id = %d, fio = %s, sex = %c, date of birth = %s, years = %d \n", id, fio, sex, date_of_birth.toString(), getAge());
    }
}
