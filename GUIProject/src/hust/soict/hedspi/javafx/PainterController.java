package hust.soict.hedspi.javafx;


import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;
        import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML
    private Pane drawingAreaPane;

    @FXML
    void clearButtonPressed(ActionEvent event) {
        System.out.println("Btn click");
    drawingAreaPane.getChildren().clear();
    }
    @FXML
    private RadioButton penRadioButton;
    private ToggleGroup toggle1 = new ToggleGroup();
    @FXML
    private void initialize() {
        penRadioButton.setToggleGroup(toggle1);
        eraseRadioButton.setToggleGroup(toggle1);


        // Cài đặt RadioButton mặc định nếu cần
        penRadioButton.setSelected(true);
    }
    @FXML
    private RadioButton eraseRadioButton;
    @FXML
    void drawingAreaMouseDragged(MouseEvent event) {


        if (penRadioButton.isSelected()) {
            // Bút được chọn, vẽ hình tròn mới
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.BLACK);
            drawingAreaPane.getChildren().add(newCircle);
        } else  {
            // Cục tẩy được chọn, xóa hình tròn đã vẽ
            Circle newCircle = new Circle(event.getX(), event.getY(), 4, Color.WHITE);
            drawingAreaPane.getChildren().add(newCircle);
        }
}}