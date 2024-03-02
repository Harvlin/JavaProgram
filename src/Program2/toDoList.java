package Program2;
import java.util.HashMap;
import java.util.Scanner;
public class toDoList {
      public static HashMap<String, String> List = new HashMap<>();

      static void create() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Title: "); String title = sc.nextLine();
            System.out.print("Details: "); String detail = sc.nextLine();
            if (List.containsKey(title)) {
                  System.out.println("Already Exist");
            } else {
                  List.put(title, detail);
                  System.out.println("Added");
            }
            sc.close();
      }

      static void read() {
            if (!List.isEmpty()) {
                  for (String i : List.keySet()) {
                        System.out.printf("Title: %s  Details: %s\n", i, List.get(i));
                  }
            } else {
                  System.out.println("Empty");
            }
      }

      static void update() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Title: "); String title = sc.nextLine();
            if (!List.containsKey(title)) {
                  System.out.println("Not exist");
            } else {
                  System.out.print("New Details: "); String detail = sc.nextLine();
                  System.out.println("Updated");
                  List.put(title, detail);
            }
            sc.close();
      }

      static void delete() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Title: "); String title = sc.nextLine();
            if (!List.containsKey(title)) {
                  System.out.println("Not Exist Yet");
            } else {
                  List.remove(title);
            }
            sc.close();
      }

      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                  System.out.println("\n1. Create\n2. Read\n3. Update\n4. Delete\n5. Exit");
                  System.out.print(">> "); short userIn = sc.nextShort();

                  switch (userIn) {
                        case 1:
                              create();
                              break;
                        case 2:
                              read();
                              break;
                        case 3:
                              update();
                              break;
                        case 4:
                              delete();
                              break;
                        case 5:
                              System.exit(0);
                              sc.close();
                              break;
                        default:
                              System.out.println("Invalid");
                              break;
                  }
            }
      }
}