import java.util.Scanner;

public class bai84 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int daysInMonth = 0;

        // Nhập tháng từ người dùng
        System.out.print("Nhập tháng (số, tên đầy đủ hoặc tên viết tắt): ");
        String month = scanner.nextLine().toLowerCase();
        System.out.print("Nhập năm: ");
        int year = scanner.nextInt();

        // Kiểm tra tháng và xác định số ngày trong tháng
        switch (month) {
            case "1":
            case "January":
            case "Jan.":
            case "Jan":
                daysInMonth = 31;
                break;
            case "2":
            case "February":
            case "Feb.":
            case "Feb":
                if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
                    daysInMonth = 29; // Năm nhuận, tháng 2 có 29 ngày
                }else{
                daysInMonth = 28;};
                break;
            case "3":
            case "March":
            case "Mar.":
            case "Mar":
                daysInMonth = 31;
                break;
            case "4":
            case "April":
            case "Apr.":
            case "Apr":
                daysInMonth = 30;
                break;
            case "5":
            case "May":

                daysInMonth = 31;
                break;
            case "6":
            case "June":
            case "Jun":

                daysInMonth = 30;
                break;
            case "7":
            case "July":
            case "Jul":

                daysInMonth = 31;
                break;
            case "8":
            case "August":
            case "Aug.":
            case "Aug":
                daysInMonth = 31;
                break;
            case "9":
            case "September":
            case "Sept.":
            case "Sep":
                daysInMonth = 30;
                break;
            case "10":
            case "October":
            case "Oct.":
            case "Oct":
                daysInMonth = 31;
                break;
            case "11":
            case "November":
            case "Nov.":
            case "Nov":
                daysInMonth = 30;
                break;
            case "12":
            case "December":
            case "Dec.":
            case "Dec":
                daysInMonth = 31;
                break;
            default:
                System.out.println("Tháng không hợp lệ.");
                break;
        }

        // Kiểm tra nếu là năm nhuận và tháng là tháng 2


        // Hiển thị số ngày trong tháng
        if (daysInMonth > 0) {
            System.out.println("Tháng " + month +" năm " +year + " có " + daysInMonth + " ngày.");
        }

        scanner.close();
    }
}
