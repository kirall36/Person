import FioPersonChecker.FioPersonChecker;
import IdPersonChecker.IdPersonChecker;
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
        people.addPerson("Matveev Kirill Mihailovich", 'm', new LocalDate(1998, 06,15));
        people.addPerson("Stupnikova Ekaterina Petrovna", 'f', new LocalDate(1998, 4,30));
        people.addPerson("Naumenko Dmitrii Ivanovich", 'm', new LocalDate(1998, 4,19));
        while(true)
        {
            System.out.print("Select action: \n 0 - Show all persons  \n 1 - Show certain person  \n 2 - Add a person  \n 3 - Delete a person \n  4 - Поиск по имени");
            int variant = sc.nextInt();
            int id;
            String fio;
            char sex;
            LocalDate date_of_birth;
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
                    System.out.println("Enter person's surname ");
                    fio = sc.next();
                    System.out.println("Enter person's name ");
                    fio += " " + sc.next();
                    System.out.println("Enter person's patronymic name ");
                    fio += " " + sc.next();
                    people.searchPersons(new FioPersonChecker(), fio);
                    break;

                case 5:
                    System.out.print("Enter id to find a person ");
                    id = sc.nextInt();
                    people.searchPersons(new IdPersonChecker(), id);
                    break;

                default:
                    System.out.println("You entered a wrong number. Try again");
            }
        }
    }
}