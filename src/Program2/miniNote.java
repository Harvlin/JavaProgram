import java.util.Scanner;
import java.util.HashMap;
import java.util.InputMismatchException;
public class miniNote {
      static HashMap<String, String> NOTE = new HashMap<>();
      static void addNote() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Title: "); String title = sc.nextLine();
            System.out.print("Note: "); String note = sc.nextLine();
            if (NOTE.containsKey(title)) {
                  System.out.println("Already exist\n");
            } else {
                  NOTE.put(title, note);
                  System.out.println("Added\n");
            }
            sc.close();
      }
      static void deleteNote() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Title: "); String deleteTitle = sc.nextLine();
            if (!NOTE.containsKey(deleteTitle)) {
                  System.out.println("Not exist\n");
            } else {
                  NOTE.remove(deleteTitle);
                  System.out.println("Deleted\n");
            }
            sc.close();
      }
      static void viewNoteList() {
            System.out.println("Note list: ");
            for (String i : NOTE.keySet()) {
                  System.out.println(i);
            }
      }
      static void viewExactNote() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Title: "); String readTitle = sc.nextLine();
            if (!NOTE.containsKey(readTitle)) {
                  System.out.println("Not exist");
            } else {
                  System.out.println(NOTE.get(readTitle));
            }
            sc.close();
      }
      static void editNote() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Title: : "); String editedTitle = sc.nextLine();
            System.out.print("Note: "); String editedNote = sc.nextLine();
            if (!NOTE.containsKey(editedTitle)) {
                  System.out.println("Not exist");
            } else if (NOTE.containsValue(editedNote)) {
                  System.out.println("Same note");
            } else {
                  NOTE.put(editedTitle, editedNote);
                  System.out.println("Edited");
            }
            sc.close();
      }
      public static void main(String[] note) {
            Scanner sc = new Scanner(System.in);
            while (true) {
                  System.out.println("\n1. Add note\n2. Delete note\n3. View note list\n4. View exact note\n5. Edit note\n6. Exit");
                  System.out.print("Enter your choice: "); short choice = sc.nextShort();
                  switch (choice) {
                        case 1:
                              addNote();
                              break;
                        case 2:
                              deleteNote();
                              break;
                        case 3:
                              viewNoteList();
                              break;
                        case 4:
                              viewExactNote();
                              break;
                        case 5:
                              editNote();
                              break;
                        case 6:
                              sc.close();
                              System.exit(0);
                              break;
                        default:
                              throw new InputMismatchException();
                  }
            }
      }
}