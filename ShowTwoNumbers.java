import javax.swing.*;

public class ShowTwoNumbers {
    public static void main(String[] args) {
        String strNum1, strNum2;
        String strNotification= "you've just entered: ";
        strNum1 = JOptionPane.showInputDialog(null,
                "Please input the first number: ",
                "input the first number",
                JOptionPane.INFORMATION_MESSAGE);
        strNotification +=strNum1 +" and ";
        strNum2 = JOptionPane.showInputDialog(null,
                "please input the second number: ",
                "In put the second number",
                JOptionPane.INFORMATION_MESSAGE);
        strNotification+=strNum2;
        JOptionPane.showMessageDialog(null,strNotification,
                "show two numbers",JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}
