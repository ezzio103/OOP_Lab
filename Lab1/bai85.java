import java.util.Scanner;
import java.util.Arrays;

public class bai85
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Nhập kích thước của mảng từ người dùng
        System.out.print("Nhập kích thước của mảng: ");
        int size = scanner.nextInt();

        // Khởi tạo mảng với kích thước đã nhập
        double[] arr = new double[size];

        // Nhập các phần tử của mảng từ người dùng
        for (int i = 0; i < size; i++) {
            System.out.print("Nhập phần tử thứ " + (i + 1) + ": ");
            arr[i] = scanner.nextDouble();
        }

        // Sắp xếp mảng
        Arrays.sort(arr);

        // Tính tổng các phần tử của mảng
        double sum = 0;
        for (int i = 0; i < size; i++) {
            sum += arr[i];
        }

        // Tính giá trị trung bình
        double average = sum / size;

        // In mảng sau khi sắp xếp
        System.out.print("Mảng sau khi sắp xếp: ");
        System.out.println(Arrays.toString(arr));

        // In tổng và giá trị trung bình
        System.out.println("Tổng các phần tử trong mảng: " + sum);
        System.out.println("Giá trị trung bình của các phần tử trong mảng: " + average);

        scanner.close();
    }
}
