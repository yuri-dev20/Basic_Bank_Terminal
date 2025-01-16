import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

class Bank {
    private static List<User> users = new LinkedList<>();

    public static void addUser(User acc) {
        users.add(acc);
    }

    public static void app() {
        Boolean state = Boolean.TRUE;
        while (state) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter a account id: ");
            Integer id = sc.nextInt();
            displayInfo(id);
            System.out.println();
            System.out.print("Do you want to make a deposit (0) or withdraw (1): ");
            Integer answer = sc.nextInt();
            transaction(id, answer);

            System.out.println();

            System.out.print("Do you to continue operations ?: (1 (YES)/2 (NO))");
            Integer transcationContinue = sc.nextInt();

            if (transcationContinue == 2) {
                break;
            }
        }

    }

    public static void displayInfo(Integer id) {
        for (User acc : users) {
            if (Objects.equals(acc.getId(), id)) {
                System.out.println(acc);
                return;
            }
        }
        System.out.println("Account not find.");
    }

    private static void transaction(Integer accId, Integer answer) {
        Scanner sc = new Scanner(System.in);
        if (answer == 0) {
            for (User acc : users) {
                if (Objects.equals(acc.getId(), accId)) {
                    System.out.print("Enter a amount to deposit: ");
                    Double amount = sc.nextDouble();
                    acc.deposit(amount);
                    return;
                }
            }
        } else if (answer == 1) {
            for (User acc : users) {
                if (Objects.equals(acc.getId(), accId)) {
                    System.out.print("Enter a amount to withdraw: ");
                    Double amount = sc.nextDouble();
                    acc.withdraw(amount);
                    return;
                }
            }
        }
        System.out.println("Transaction Failed.");

        sc.close();
    }
}

class User {
    private Integer id;
    private String name;
    private Double balance;

    public User(Integer id, String name, Double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Please enter a valid amount.");
        }

    }

    public void withdraw(double amount) {
        if (amount <= 0 || balance > amount) {
            balance -= amount;
        } else {
            System.out.println("Please enter a valid amount.");
        }
    }

    @Override
    public String toString() {
        return "Account id: " + id +
               " \nname: " + name +
               " \nbalance: " + balance;
    }
}
