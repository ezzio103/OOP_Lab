//import java.util.Scanner;
//
//public class bai26 {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Nhập giá trị của a: ");
//        double a = scanner.nextDouble();
//
//        if (a == 0) {
//            System.out.println("Đây không phải là phương trình bậc hai.");
//        } else {
//            System.out.print("Nhập giá trị của b: ");
//            double b = scanner.nextDouble();
//            System.out.print("Nhập giá trị của c: ");
//            double c = scanner.nextDouble();
//
//            double discriminant = b * b - 4 * a * c;
//
//            if (discriminant > 0) {
//                double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
//                double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
//                System.out.println("Phương trình có hai nghiệm phân biệt:");
//                System.out.println("Nghiệm 1: " + root1);
//                System.out.println("Nghiệm 2: " + root2);
//            } else if (discriminant == 0) {
//                double root = -b / (2 * a);
//                System.out.println("Phương trình có một nghiệm kép: " + root);
//            } else {
//                System.out.println("Phương trình không có nghiệm thực.");
//            }
//        }
//
//        scanner.close();
//    }
//}
//
import java.util.Scanner;

public class bai26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập giá trị của a11: ");
        double a11 = scanner.nextDouble();
        System.out.print("Nhập giá trị của a12: ");
        double a12 = scanner.nextDouble();
        System.out.print("Nhập giá trị của b1: ");
        double b1 = scanner.nextDouble();
        System.out.print("Nhập giá trị của a21: ");
        double a21 = scanner.nextDouble();
        System.out.print("Nhập giá trị của a22: ");
        double a22 = scanner.nextDouble();
        System.out.print("Nhập giá trị của b2: ");
        double b2 = scanner.nextDouble();

        double determinant = a11 * a22 - a21 * a12;

        if (determinant == 0) {
            System.out.println("Hệ phương trình không có nghiệm hoặc có vô số nghiệm.");
        } else {
            double x = (a22 * b1 - a12 * b2) / determinant;
            double y = (a11 * b2 - a21 * b1) / determinant;
            System.out.println("Nghiệm của hệ phương trình:");
            System.out.println("x = " + x);
            System.out.println("y = " + y);
        }

        scanner.close();
    }
}
