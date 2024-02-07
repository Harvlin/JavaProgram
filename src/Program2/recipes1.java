/*
 * recipes CRUD
 * Users should be able to perform basic CRUD (Create, Read, Update, Delete) operations on recipes. 
 */
import java.util.HashMap;
import java.util.Scanner;
      public class recipes1{
            private static HashMap<String, String>recipes = new HashMap<String, String>();

            public static void create(String dish, String detail){
                  if(recipes.containsKey(dish)) {
                        System.out.println("Already exist\n");
                  } else {
                        recipes.put(dish, detail);
                        System.out.println("Created");
                  }
            }

            public static void read() {
                  if (recipes.isEmpty()) {
                        System.out.println("Empty\n");
                  } else {
                        for(String i:recipes.keySet()){
                              System.out.println("Dish: " + i + "  Details: " + recipes.get(i));
                        }
                  }
            }

            public static void update(String dish, String detail){
                  if (recipes.isEmpty()) {
                        System.out.println("There's nothing to update to the dish recipe list\n");
                  } else {
                        recipes.remove(dish);
                        recipes.put(dish, detail);
                        System.out.println("Updated\n");
                  }
            }

            public static void delete(String dish) {
                  if (!recipes.containsValue(dish)) {
                        System.out.println("There's no such recipe");
                  } else {
                        recipes.remove(dish);
                        System.out.println("Deleted");
                  }
            }

            public static void main(String[] recipes){
                  Scanner sc = new Scanner(System.in);
                  while(true) {                        
                        System.out.println("1. Create a dish recipe\n2. Show dish reccipe\n3. Update dish recipe\n4. Delete dish recipe\n5. Quit");
                        System.out.print("Enter your choice: ");
                        int choice = sc.nextInt();
                              switch(choice) {
                                    case 1:
                                          System.out.print("Enter the dish name: ");
                                          String dish = sc.nextLine();
                                          sc.next();
                                          System.out.print("Enter the dish detail: ");
                                          String detail = sc.nextLine();
                                          sc.next();
                                          create(dish, detail);
                                          break;
                                    case 2:
                                          read();
                                          break;
                                    case 3:
                                          System.out.print("Enter the name of dish you want to update the detail: ");
                                          String dish2 = sc.nextLine();
                                          sc.next();
                                          System.err.print("Enter the new detail: ");
                                          String detail2 = sc.nextLine();
                                          sc.next();
                                          update(dish2, detail2);
                                          break;
                                    case 4:
                                          System.out.print("Enter the name of dish you want to delete: ");
                                          String dish3 = sc.nextLine();
                                          sc.next();
                                          delete(dish3);
                                          break;
                                    case 5:
                                          System.exit(0);
                                          sc.close();
                                          break;
                              }
                  }
            }
      }