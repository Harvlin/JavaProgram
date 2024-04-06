package Program2;
import java.util.HashMap;
import java.util.Scanner;
public class gradeReport {
      public static void main(String[] args) {
            mainProgram();
      }
      private static void mainProgram() {
            HashMap<String, HashMap<String, Double>> studentRec = new HashMap<>();
            try (Scanner scanner = new Scanner(System.in)) {
                  while (true) {
                        System.out.println("=== Application ===");
                        System.out.print("1. Add Student\n2. Assign Grade\n3. Calculate Average\n4. Display Record\n");
                        System.out.print(">> "); int choice = scanner.nextInt();

                        switch (choice) {
                              case 1:
                                    addStudent(scanner, studentRec);
                                    break;
                              case 2:
                                    assignGrade(scanner, studentRec);
                                    break;
                              case 3:
                                    calculateAverage(scanner, studentRec);
                                    break;
                              case 4:
                                    displayRecord(studentRec);
                                    break;
                              case ' ':
                                    System.exit(0);
                                    break;
                              default:
                                    System.out.println("Invalid");
                        }
                  }
            } catch (Exception e) {
                  e.printStackTrace();
            }
      }
      private static void addStudent(Scanner scanner, HashMap<String, HashMap<String, Double>> studentRec) {
            System.out.print("Name: "); String name = scanner.nextLine();
            if (!studentRec.containsKey(name)) {
                  studentRec.put(name, new HashMap<>());
            } else {
                  System.out.println("Already Exist");
            }
      }
      private static void assignGrade(Scanner scanner, HashMap<String, HashMap<String, Double>> studentRec) {
            System.out.print("Name: "); String name = scanner.nextLine();
            if (!studentRec.containsKey(name)) {
                  System.out.println("Not found");
                  return;
            }
            System.out.print("Subject"); String subject = scanner.nextLine();
            System.out.print("Grade: "); Double grade = scanner.nextDouble();

            studentRec.get(name).put(subject, grade);
      }
      private static void calculateAverage(Scanner scanner, HashMap<String, HashMap<String, Double>> studentRec) {
            System.out.print("Name: "); String name = scanner.nextLine();
            if (!studentRec.containsKey(name)) {
                  System.out.println("Not found");
                  return;
            }
            HashMap<String, Double> Grade = studentRec.get(name);
            double total = 0;
            int counter = 0;
            for (Double i : Grade.values()) {
                  total += i;
                  counter++;
            }
            String result = (counter == 0) ? "Null Data" : ("Average: " + total / counter);
            System.out.println(result);
      }
      private static void displayRecord(HashMap<String, HashMap<String, Double>> studentRec) {
            System.out.println("Grade Record");
            for (HashMap.Entry<String, HashMap<String, Double>> entry : studentRec.entrySet()) {
                  System.out.println("Student: " + entry.getKey());
                  System.out.println("Grades:");
                  for (HashMap.Entry<String, Double> gradeEntry: entry.getValue().entrySet()) {
                        System.out.println(gradeEntry.getKey() + ": " + gradeEntry.getValue());
                  }
                  System.out.println();
            }
      }
}