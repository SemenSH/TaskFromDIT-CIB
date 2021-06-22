import dto.Person;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
        System.out.println("4.Show sorted unique");
        System.out.println("5.Save to file");
        while (true) {
            System.out.println("Выберите пункт меню.");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    String[] line = scanner.nextLine().split("\\s+");
                    personList.add(new Person(line[0], line[1]));
                    break;
                case "2":
                    if (personList.size() != 0) {
                        personList.forEach(System.out::println);
                        break;
                    } else {
                        System.out.println("Список пуст");
                        break;
                    }
                case "3":
                    scanner.close();
                    System.exit(0);
                    break;
                case "4":
                    personList.sort(Comparator.comparing(Person::getLastName));
                    personList.forEach(System.out::println);
                    break;
                case "5":
                    System.out.println("Введите путь к файлу :");
                    String filePath = scanner.nextLine();
                    File file = new File(filePath);
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
                        oos.writeObject(personList);
                        oos.flush();
                        System.out.println("Файл записан");
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                    break;
                default:
                    System.out.println("Ошибка ввода");
            }
        }
    }
}
