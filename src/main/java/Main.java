import dto.Person;

public class Main {
    public static void main(String[] args) {
        if (args.length > 1) {
            String fName = args[0];
            String lName = args[1];
            Person person = new Person(fName, lName);
            System.out.println(person);
        }
    }
}
