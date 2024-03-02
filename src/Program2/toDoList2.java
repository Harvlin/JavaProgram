package Program2;
import java.util.HashMap;
import java.util.Scanner;
class list {
      private String Title;
      private String Task;
      private boolean Done;
      public String getTask() {
            return Task;
      }
      public String getTitle() {
            return Title;
      }
      public boolean isDone() {
            return Done;
      }
      public void setTask(String task) {
            Task = task;
      }
      public void setTitle(String title) {
            Title = title;
      }
      public void setDone(boolean done) {
            Done = done;
      }
      public list(String title, String task, boolean done) {
            this.Title = title;
            this.Task = task;
            this.Done = done;
      }
}
class function {
      public static HashMap<String, list> toDoList = new HashMap<String, list>();
      Scanner sc = new Scanner(System.in);
      public void Create(String title, String Task) {
            if (!toDoList.containsKey(title)) {
                  list task = new list(title, Task, false);
                  toDoList.put(title, task);
            } else {
                  return;
            }
      }

      public void markDone(String title, boolean isDone) {
            if (toDoList.containsKey(title)) {
                  if (isDone) {
                        toDoList.remove(title);
                        System.out.println("Completed");
                  }
            } else {
                  System.out.println("Not available");
            }
      }

      public void changeTask(String title, String Task) {
            if (toDoList.containsKey(title)) {
                  list task = toDoList.get(title);
                  System.out.println("New Task: "); Task = sc.nextLine();
                  task = new list(task.getTitle(), Task, task.isDone());
                  System.out.println("Updated");
            } else {
                  return;
            }
      }

      public void viewList() {
            if (!toDoList.isEmpty()) {
                  for (list task : toDoList.values()) {
                        System.out.printf("\nTitle: %s\nTask: %s\nStatus: %s\n", task.getTitle(), task.getTask(), task.isDone());
                  } 
            } else {
                  System.out.println("Empty");
            }
      }
}
public class toDoList2 {
      public static void main(String[] args) {
            
      }
}
