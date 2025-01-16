public class Main {
    public static void main(String[] args) {
        Bank.addUser(new User(199, "Jhon doe", 100.0));
        Bank.addUser(new User(299, "Jane doe", 100.0));

        Bank.app();

        Bank.displayInfo(199);
    }
}
