import java.util.Scanner;
import java.util.HashMap;
public class PhoneBook {
      public static HashMap <String, Integer> phoneBook = new HashMap<>();
      static void addContact() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter contact name: "); String name = sc.nextLine();
            System.out.print("Enter the number: "); int number = sc.nextInt();
            if (phoneBook.containsKey(name)) {
                  System.out.println("Already exist");
            } else {
                  phoneBook.put(name, number);
                  System.out.println("Added");
            }
            sc.close(); 
      }
      static void deleteContact() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter contact name: "); String name = sc.nextLine();
            if (!phoneBook.containsKey(name)) {
                  System.out.println("Not exist");
            } else {
                  phoneBook.remove(name);
                  System.out.println("Deleted");
            } 
            sc.close();
      }
      static void viewContact() {
            System.out.println("List: ");
            for (String i : phoneBook.keySet()) {
                  System.out.printf("Name: %s  Number: %d\n", i, phoneBook.get(i));
            }
      }
      static void updateContact() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter contact name: "); String name = sc.nextLine();
            System.out.print("Enter the number: "); int number = sc.nextInt();
            sc.close();
            if (!phoneBook.containsKey(name)) {
                  System.out.println("Not exist");
            } else {
                  phoneBook.put(name, number);
                  System.out.println("Updated");
            } 
      }
      public static void main(String[] phoneBook) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                  System.out.println("\n---Phone Book---\n1. Add contact\n2. Delete contact\n3. View contact\n4. Update contact\n5. Exit");
                  System.out.print("Enter your choice: "); short choice = sc.nextShort();

                  switch(choice) {
                        case 1:
                              addContact();
                              break;
                        case 2:
                              deleteContact();
                              break; 
                        case 3:
                              viewContact();
                              break;
                        case 4:
                              updateContact();
                              break;
                        case 5:
                              sc.close();
                              System.exit(0);
                              break;
                  }
            }
      }
}