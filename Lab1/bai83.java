package Lab1;

import java.util.Scanner;

public class bai83 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số dòng của tam giác: ");
        int n = scanner.nextInt();

        // In tam giác sao
        for (int i = 1; i <= n; i++) {
            // In các khoảng trắng
            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            // In các sao
            for (int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }

            // Xuống dòng sau khi in xong một dòng
            System.out.println();
        }

        scanner.close();
    }
}
