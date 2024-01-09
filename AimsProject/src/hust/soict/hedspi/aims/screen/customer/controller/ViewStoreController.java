package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewStoreController {
    private Store store;
    private Cart cart;

    public ViewStoreController(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
    }

//    public ViewStoreController(Store store) {
//        this.store = store;
//    }
    @FXML
    private GridPane gridPane;

    @FXML
    void btnViewCartPressed(ActionEvent event) {
        try {
//            hust/soict/hedspi/aims/screen/customer/view/Cart.fxml
//            hust/soict/hedspi/aims/screen/customer/controller/ViewStoreController.java
            final String CART_FXML_FILE_PATH = "../view/Cart.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
            fxmlLoader.setController(new CartController(store, cart));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Cart");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize() {
        final String ITEM_FXML_FILE_PATH = "../view/Item.fxml"; // Đường dẫn chính xác tới Item.fxml

        int column = 0;
        int row = 0;
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        for (int i = 0; i < store.getItemsInStore().size(); i++) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource(ITEM_FXML_FILE_PATH));

                ItemController itemController = new ItemController(cart);
                fxmlLoader.setController(itemController);

                AnchorPane anchorPane = fxmlLoader.load();

                itemController.setData(store.getItemsInStore().get(i));

                gridPane.add(anchorPane, column, row);
//                GridPane.setMargin(anchorPane, new Insets(10));
                column++;

                // Chuyển sang hàng mới nếu cần thiết
                if (column > 2) {
                    column = 0;
                    row++;
                }
                ColumnConstraints columnConstraints = new ColumnConstraints();
                columnConstraints.setHgrow(Priority.ALWAYS); // Tự động mở rộng chiều ngang
                gridPane.getColumnConstraints().add(columnConstraints);

                RowConstraints rowConstraints = new RowConstraints();
                rowConstraints.setVgrow(Priority.ALWAYS); // Tự động mở rộng chiều dọc
                gridPane.getRowConstraints().add(rowConstraints);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
