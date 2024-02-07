import java.util.Scanner;

public class math_implementation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print(
        "1. Circumference of rectangula prism\n 2. Circumference of cube\n 3. Area of Circle\n 4. Area of triangle\n Enter the number of your choice: ");
    short input = sc.nextShort();
    switch (input) {
      case 1:
        System.out.println("Enter the length: ");
        short length = sc.nextShort();
        System.out.println("Enter the wide: ");
        short wide = sc.nextShort();
        System.out.println("Enter the height: ");
        short height = sc.nextShort();
        System.out.println(Circumference_of_rectangular_prism(length, wide, height));
        break;
      case 2:
        System.out.println("Enter the side: ");
        short side = sc.nextShort();
        System.out.println(Circumference_of_cube(side));
        break;
      case 3:
        System.out.println("Enter the radius: ");
        short radius = sc.nextShort();
        System.out.println(3.14 * Area_of_circle(radius));
        break;
      case 4:
        System.out.println("Enter the bottom: ");
        short bottom = sc.nextShort();
        System.out.println("Enter the height: ");
        short h = sc.nextShort();
        System.out.println(0.5 * Area_of_triangle(bottom, h));
        break;
    }
    sc.close();
  }

  static int Circumference_of_rectangular_prism(short l, short w, short h) {
    return 4 * (l + w + h);
  }

  static int Circumference_of_cube(short s) {
    return s * 12;
  }

  static int Area_of_circle(short r) {
    return r * r;
  }

  static int Area_of_triangle(short b, short h) {
    return b * h;
  }
}