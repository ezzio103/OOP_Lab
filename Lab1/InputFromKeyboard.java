import java.util.Scanner;

public class InputFromKeyboard {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("what's your name?");
        String strName= sc.nextLine();
        System.out.println("how old are you?");
        int iAge = sc.nextInt();
        System.out.println("how tall are you (m)?");
        double dHeight = sc.nextDouble();
        System.out.println("Mrs/ms. "+strName+", "+iAge+" years old. "
        +"Yours height is "+dHeight+".");
    }
}
