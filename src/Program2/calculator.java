import java.util.Scanner;

class calculator {
    public static void main(String[] calculator) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Select operator (+)  (-)  (*)  (/): ");
        String operator = sc.nextLine();
        System.out.print("Enter the first number: ");
        short first_num = sc.nextShort();
        System.out.print("Enter the second number: ");
        short second_num = sc.nextShort();
        double total;
        switch (operator) {
            case "+":
                total = first_num + second_num;
                System.out.println("Total = " + total);
                break;
            case "-":
                total = first_num - second_num;
                System.out.println("Total = " + total);
                break;
            case "*":
                total = first_num * second_num;
                System.out.println("Total = " + total);
                break;
            case "/":
                total = first_num / second_num;
                System.out.println("Total = " + total);
                break;
        }
        sc.close();
    }
}
