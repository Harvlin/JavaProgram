package Program2;
import java.util.Scanner;
import java.util.HashMap;

class bankData {
    private int id;
    private int password;
    private String uname;
    private long balance;

    public int getId() {
        return id;
    }
    public int getPassword() {
        return password;
    }
    public String getUname() {
        return uname;
    }
    public long getBalance() {
        return balance;
    }

    public bankData(int id, int password, String uname, long balance) {
        this.id = id;
        this.password = password;
        this.uname = uname;
        this.balance = balance;
    }
}

public class bank {
    private static void os() {
        HashMap<Integer, bankData> data = new HashMap<Integer, bankData>();
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("= BANK =");
                System.out.print("Sign in | Login | Exit"); String log = scanner.nextLine();
                if (log.equalsIgnoreCase("login")) {
                    login(scanner, data);
                } else if (log.equalsIgnoreCase("sign in")) {
                    signIn(scanner, data);
                } else if (log.equalsIgnoreCase("exit")) {
                    System.exit(0);
                    scanner.close();
                    break;
                } else {
                    System.out.println("Invalid");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void deposit(Scanner scanner, HashMap<Integer, bankData> data, String uname, int password, int id) {
        System.out.print("Amount: "); long amount = Long.parseLong(scanner.nextLine());
        scanner.nextLine();
        long currentBalance = data.get(id).getBalance();
        long totalAmount = currentBalance + amount;
        bankData object = new bankData(id, password, uname, totalAmount);
        data.put(id, object);
        System.out.println("Username: " + data.get(id).getUname() +
                "  Balance: Rp" + data.get(id).getBalance() + "  ID: " + data.get(id).getId());
    }

    private static void withdraw(Scanner scanner, HashMap<Integer, bankData> data, String uname, int password, int id) {
        System.out.print("Amount: "); long amount = Long.parseLong(scanner.nextLine());
        scanner.nextLine();
        long currentBalance = data.get(id).getBalance();
        long totalAmount = currentBalance - amount;
        bankData object = new bankData(id, password, uname, totalAmount);
        data.put(id, object);
        System.out.println("Username: " + data.get(id).getUname() +
                "  Balance: Rp" + data.get(id).getBalance()+ "  ID: " + data.get(id).getId());
    }

    private static void signIn(Scanner scanner, HashMap<Integer, bankData> data) {
        System.out.println("Sign in selected.");

        System.out.print("Username: "); String uname = scanner.nextLine();
        System.out.print("id: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("password: "); int password = scanner.nextInt(); scanner.nextLine();

        if (data.containsKey(id)) {
            System.out.println("You're already have an account");
            os();
        } else {
            while (true) {
                System.out.print("Withdraw | Deposit | Log out: "); String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("deposit")) {
                    deposit(scanner, data, uname, password, id);
                } else if (choice.equalsIgnoreCase("withdraw")) {
                    withdraw(scanner, data, uname, password, id);
                } else if (choice.equalsIgnoreCase("log out")) {
                    os();
                }
            }
        }

    }

    private static void login(Scanner scanner, HashMap<Integer, bankData> data) {
        System.out.println("Login selected.");
        System.out.print("id: "); int id = scanner.nextInt(); scanner.nextLine();
        System.out.print("password: "); int password = scanner.nextInt(); scanner.nextLine();

        if (!data.containsKey(id)) {
            System.out.println("You don't have an account");
            os();
        } else if (password != data.get(id).getPassword()) {
            System.out.println("Wrong password");
        } else {
            while (true) {
                System.out.print("Withdraw | Deposit | Log out: "); String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("deposit")) {
                    deposit(scanner, data, data.get(id).getUname(), password, id);
                } else if (choice.equalsIgnoreCase("withdraw")) {
                    withdraw(scanner, data, data.get(id).getUname(), password, id);
                } else if (choice.equalsIgnoreCase("log out")) {
                    os();
                }
            }
        }
    }

    public static void main(String[] args) {
        os();
    }
}