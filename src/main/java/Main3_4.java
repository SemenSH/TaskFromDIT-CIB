import dto.Person;

import java.util.*;

public class Main3_4 {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите через пробел имя и фамилию: ");
        while (true) {
            String[] line = scanner.nextLine().split("\\s+");
            if (line[0].equals("exit")) {
                personList.sort(Comparator.comparing(Person::getLastName));
                personList.forEach(System.out::println);
                scanner.close();
                System.exit(0);
            } else {
                String fname = line[0];
                String lname = line[1];
                Person person = new Person(fname, lname);
                personList.add(person);
            }
        }
    }
}
