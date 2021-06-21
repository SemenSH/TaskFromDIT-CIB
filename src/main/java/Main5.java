import dto.Person;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main5 {
    public static void main(String[] args) {

        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu:");
        System.out.println("1.Add");
        System.out.println("2.Show");
        System.out.println("3.Exit");
        while (true) {
            System.out.println("Выберите пункт меню.");
            String lineMenu = scanner.nextLine();
            switch (lineMenu) {
                case "1":
                    String fname = line[0];
                    String lname = line[1];
                    Person person = new Person(fname, lname);
                    personList.add(person);
                    if (person != null) {
                        personList.add(actionsPerson.add(lineData));
                    } else {
                        System.out.println("Данные не корректны");
                    }
                    break;
                case "2":
                    if (personList.size() != 0) {
                        actionsPerson.show(personList);
                        break;
                    } else {
                        System.out.println("Список пуст");
                        break;
                    }
                case "3":
                    scanner.close();
                    System.exit(0);
                    break;
            }
        }
