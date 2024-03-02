package Program2;
import java.util.Scanner;
import java.util.HashMap;
class PersonInformation {
      private String name;
      private String details;
      private int num;
      public String getDetails() {
            return details;
      }
      public String getName() {
            return name;
      }
      public int getNum() {
            return num;
      }
      PersonInformation(String name, int num, String details) {
            this.name = name;
            this.details = details;
            this.num = num;
      }
      
}
class phoneBookSystem {
      HashMap<Integer, PersonInformation /*Person Information Constructor Method*/> phonebookMap = new HashMap<Integer, PersonInformation>();
      public void addPerson(String name, int num, String details) {
            PersonInformation obj = new PersonInformation(name, num, details);
            if (phonebookMap.containsKey(num)) {
                  System.out.println("Already exist");
            } else {
                  phonebookMap.put(num, obj);
                  System.out.println("Added");
            }
      }
      public void removePerson(int num) {
            if (!phonebookMap.containsKey(num)) {
                  System.out.println("Not exist");
            } else {
                  System.out.println("Deleted");
                  phonebookMap.remove(num);
            }
      }
      public void editDetails(int num, String newDetails) {
            if (phonebookMap.containsKey(num)) {
                  PersonInformation obj = phonebookMap.get(num);
                  obj = new PersonInformation(obj.getName(), obj.getNum(), newDetails);
                  phonebookMap.put(num, obj);
                  System.out.println("Updated");
            } else {
                  System.out.println("Not found");
            }
      }
      public void personList() {
            if (phonebookMap.isEmpty()) {
                  System.out.println("Empty");
            } else {
                  System.out.println("List: ");
                  for (PersonInformation obj : phonebookMap.values()) {
                        System.out.printf("Name: %s    Num: %d    Details: %s\n", obj.getName(), obj.getNum(), obj.getDetails());
                  }     
            }
      }
}
public class phonebook2 {
      public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            
            sc.close();
      }
}