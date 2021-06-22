import dto.Person;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;

public class Main7 {
    private static List<Person> personList = new ArrayList<>();
    private static TreeSet<Person> personTreeSet = new TreeSet(Person.COMPARE_BY_PERSON);

    public static void main(String[] args) {
        //  List<Person> personList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu(scanner);
    }

    @FunctionalInterface
    private interface Exec {
        void exec(List<Person> data) throws Exception;
    }

    //описывает пункт меню
    private static class MenuItem {
        private String name;
        private Exec exec;
    }

    //описывает объект меню
    private static class Menu {
        private List<MenuItem> items = new ArrayList<>();
        private Service service = new Service();

        public Menu(Scanner scanner) {
            MenuItem menuItem = new MenuItem();
            menuItem.name = "1.Add";
            menuItem.exec = personList -> {
                String fname = scanner.next();
                String lname = scanner.next();
                service.add(new Person(fname, lname));
            };
            items.add(menuItem);


            menuItem = new MenuItem();
            menuItem.name = "2.Show";
            menuItem.exec = personList -> service.show();
            items.add(menuItem);


            menuItem = new MenuItem();
            menuItem.name = "3.Show sotred unique person";
            menuItem.exec = personList -> service.showSortedUnique();
            items.add(menuItem);


            menuItem = new MenuItem();
            menuItem.name = "4.Save to file";
            menuItem.exec = personList -> {
                System.out.println("Введите путь к файлу :");
                String pathFile = scanner.nextLine();
                service.saveToFile(personList, pathFile);
            };
            items.add(menuItem);


            menuItem = new MenuItem();
            menuItem.name = "5.Read to file";
            menuItem.exec = personList -> {
                System.out.println("Введите путь к файлу :");
                String pathFile = scanner.nextLine();
                service.readToFile(pathFile);
            };
            items.add(menuItem);


            menuItem = new MenuItem();
            menuItem.name = "6.Clear";
            menuItem.exec = personList -> service.clearDataInMemory();
            items.add(menuItem);


            menuItem = new MenuItem();
            menuItem.name = "7.Exit";
            menuItem.exec = personList -> System.exit(0);
            items.add(menuItem);


            items.forEach(element -> System.out.println(element.name));

            while (true) {
                String command = scanner.nextLine();
                for (MenuItem item : items) {
                    if (item.name.equalsIgnoreCase(command)) {
                        try {
                            item.exec.exec(personList);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    static class Service {
        private void add(Person person) {
            personList.add(person);
        }


        private void show() {
            System.out.println(personList.toString());
        }


        private void showSortedUnique() {
            for (Person p : personList) {
                personTreeSet.add(p);
            }
            System.out.println(personTreeSet.toString());
        }

        private void saveToFile(List<Person> personList, String filePath) {

//            String filePath = scanner.nextLine();
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
        }

        private void clearDataInMemory() {
            personList.clear();
        }

        private void readToFile(String filePath) {
            ArrayList<Person> newListPerson = new ArrayList<>();
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
                newListPerson = ((ArrayList<Person>) ois.readObject());
            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
            System.out.println(newListPerson);
        }
    }
}

