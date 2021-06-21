import dto.Person;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя и фамилию с большой буквы через пробел: ");
        String[] line = scanner.nextLine().split("\\s+");
        String fname = line[0];
        String lname = line[1];
        scanner.close();
        Person person = new Person(fname, lname);
        System.out.println(person);
    }
}
