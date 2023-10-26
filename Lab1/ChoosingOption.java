import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ChoosingOption {
    public static void main(String[] args) {
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        int option = JOptionPane.showConfirmDialog(null,"do you want to " +
                "change to the first class ticket?");
        JOptionPane.showMessageDialog(null,"you've choosen:"
        +(option==JOptionPane.YES_OPTION?"yes":"no"));
    System.exit(0);

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.

    }
}