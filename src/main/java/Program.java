import AgePersonChecker.AgePersonChecker;
import AgePersonComparator.AgePersonComparator;
import DatePersonChecker.DatePersoneChecker;
import DatePersonComparator.DatePersonComparator;
import FioPersonChecker.FioPersonChecker;
import FioPersonComparator.FioPersonComparator;
import IdPersonChecker.IdPersonChecker;
import IdPersonComporator.IdPersonComparator;
import PersonComparator.PersonComparator;
import PersonStorage.PersonStorage;
import org.joda.time.LocalDate;
import java.util.Scanner;

/**
 * Created by Кирилл on 11.11.2018.
 */
public class Program {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        PersonStorage people = new PersonStorage();
        people.addPerson("Matveev Kirill Mihailovich", 'm', new LocalDate(1996, 06,15));
        people.addPerson("Stupnikova Ekaterina Petrovna", 'f', new LocalDate(1998, 4,30));
        people.addPerson("Naumenko Dmitrii Ivanovich", 'm', new LocalDate(1997, 4,19));
        people.addPerson("Sherbakov Nikita Igorevich", 'm', new LocalDate(1998, 7, 17));
        people.addPerson("Borovkova Ekaterina Andreevna", 'f', new LocalDate(1998, 8, 17));
        people.addPerson("Pertseva Irina Pavlovna", 'f', new LocalDate(2001, 9,21));
        while(true)
        {
            System.out.print("Select action: \n 0 - Show all persons  \n 1 - Show certain person  \n 2 - Add a person  " +
                    "\n 3 - Delete a person \n 4 - Search  \n 5 - Sorts \n 6 - Exit \n");
            int variant = sc.nextInt();
            int id, age, type;
            String fio;
            char sex;
            LocalDate date_of_birth;
            PersonComparator pc = new IdPersonComparator();
            switch (variant)
            {
                case 0:
                    people.showAllPersons();
                    break;

                case 1:
                    System.out.print("Enter id to show a person ");
                    id = sc.nextInt();
                    people.showPerson(id);
                    break;

                case 2:
                    System.out.println("Enter person's surname ");
                    fio = sc.next();
                    System.out.println("Enter person's name ");
                    fio += " " + sc.next();
                    System.out.println("Enter person's patronymic name ");
                    fio += " " + sc.next();
                    System.out.println("Enter sex of a person ");
                    sex = sc.next().toCharArray()[0];
                    System.out.println("Enter person's date of birth in format yyyy-mm-dd");
                    date_of_birth = LocalDate.parse(sc.next());
                    people.addPerson(fio, sex, date_of_birth);
                    break;

                case 3:
                    System.out.print("Enter id to delete a person ");
                    id = sc.nextInt();
                    people.deletePerson(id);
                    break;

                case 4:
                    System.out.println("Select action of search: 0 - by id \n 1 - by fio \n 2 - by date \n 3 - by age \n");
                    variant = sc.nextInt();
                    switch (variant)
                    {
                        case 0:
                            System.out.print("Enter id of a person ");
                            id = sc.nextInt();
                            people.searchPersons(new IdPersonChecker(), id);
                            break;

                        case 1:
                            System.out.println("Enter person's surname ");
                            fio = sc.next();
                            System.out.println("Enter person's name ");
                            fio += " " + sc.next();
                            System.out.println("Enter person's patronymic name ");
                            fio += " " + sc.next();
                            people.searchPersons(new FioPersonChecker(), fio);
                            break;

                        case 2:
                            System.out.println("Enter person's date of birth in format yyyy-mm-dd");
                            date_of_birth = LocalDate.parse(sc.next());
                            people.searchPersons(new DatePersoneChecker(), date_of_birth);
                            break;

                        case 3:
                            System.out.print("Enter age of a person ");
                            age = sc.nextInt();
                            people.searchPersons(new AgePersonChecker(), age);
                            break;
                    }
                    break;

                case 5:
                    System.out.println("Select action of sort: \n 0 - bubbleSort \n 1 - insertSort \n 2 - shellSort \n");
                    variant = sc.nextInt();
                    System.out.println("Select type of search: 0 - by fio \n 1 - by date \n 2 - by age \n");
                    type = sc.nextInt();
                    switch(type)
                    {
                        case 0:
                            pc = new FioPersonComparator();
                            break;

                        case 1:
                            pc = new DatePersonComparator();
                            break;

                        case 2:
                            pc = new AgePersonComparator();
                            break;
                    }
                    switch (variant)
                    {
                        case 0:
                            people.bubbleSort(pc);
                            break;

                        case 1:
                            people.insertSort(pc);
                            break;

                        case 2:
                            people.shellSort(pc);
                            break;
                    }
                    break;

                case 6:
                    System.exit(0);

                default:
                    System.out.println("You entered a wrong number. Try again");
            }
        }
    }
}