package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class CartController {
        private Store store;
        private Cart cart;

//        public CartController(Cart cart) {
//                this.cart = cart;
//        }
@FXML
private TextField txtFilter;
        public CartController(Store store, Cart cart) {
                this.store = store;
                this.cart = cart;
        }
        @FXML
        private RadioButton rbId;
        @FXML
        private RadioButton rbTitle;
        @FXML
        private Button btnPlay;

        @FXML
        private Button btnRemove;

        @FXML
        private TableColumn<Media, String> colMediaCategory;

        @FXML
        private TableColumn<Media, Float> colMediaCost;

        @FXML
        private TableColumn<Media, Integer> colMediaId;

        @FXML
        private TableColumn<Media, String> colMediaTitle;

        @FXML
        private ToggleGroup filterCategory;

        @FXML
        private TableView<Media> tblMedia;
        @FXML
        private Button btnPlaceOrder;
        @FXML
        private Label lblTotal;
        private void updateTotalPrice() {
                float total = 0;
                for (Media media : cart.getItemsOrdered()) {
                        total += media.getCost();
                }
                lblTotal.setText(String.format("Total: %.2f $", total));
        }
        @FXML
        void btnPlaceOrderPressed(ActionEvent event) {
                // Logic to place order
                System.out.println("Order placed!");
                cart.clear(); // Clear the cart after placing the order
                updateTotalPrice();
        }
        @FXML
        void btnPlayPressed(ActionEvent event) throws PlayerException {
//      Media media = tblMedia.getSelectionModel().getSelectedItem();
                Media media = tblMedia.getSelectionModel().getSelectedItem();
                if (media instanceof Playable) {
                        Playable playableMedia = (Playable) media;
                        playableMedia.play(); // Call the play method on the media
                        System.out.println("Playing: " + media.getTitle());
                }
        }

        @FXML
        void btnRemovePressed(ActionEvent event) {
//                if (itemsOrdered.remove(media)) {
//                        System.out.println("The media has been removed.");
//                        int id = 1;
//                        for (Media m : itemsOrdered) {
//                                m.setId(id++);
//                        }
//                } else {
//                        System.out.println("The media was not found in the cart.");
//                }
                Media media = tblMedia.getSelectionModel().getSelectedItem();
                cart.removeMedia (media);
                int id = 1;
                for (Media m : cart.getItemsOrdered()) {
                        m.setId(id++);
                updateTotalPrice();
        }}

        @FXML
        void btnViewStorePressed(ActionEvent event) {
                try {
                        final String CART_FXML_FILE_PATH = "../view/Store.fxml";
                        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(CART_FXML_FILE_PATH));
                        fxmlLoader.setController(new ViewStoreController(store, cart));
                        Parent root = fxmlLoader.load();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow(); stage.setScene(new Scene(root));
                        stage.setTitle("Store");
                        stage.show();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
        private void filterMediaList(String filterText) {
                ObservableList<Media> filteredList = FXCollections.observableArrayList();
                if (filterText == null || filterText.isEmpty()) {
                        tblMedia.setItems(cart.getItemsOrdered());
                } else {
                        for (Media media : cart.getItemsOrdered()) {
                                if (rbId.isSelected() && String.valueOf(media.getId()).contains(filterText)) {
                                        filteredList.add(media);
                                } else if (rbTitle.isSelected() && media.getTitle().toLowerCase().contains(filterText.toLowerCase())) {
                                        filteredList.add(media);
                                }
                        }
                        tblMedia.setItems(filteredList);
                }
        }
        @FXML
        public void initialize() {
                colMediaId.setCellValueFactory(
                        new PropertyValueFactory<Media, Integer>("id"));
                colMediaTitle.setCellValueFactory(
                        new PropertyValueFactory<Media, String>("title"));
                colMediaCategory.setCellValueFactory(
                        new PropertyValueFactory<Media, String>("category"));
                colMediaCost.setCellValueFactory(
                        new PropertyValueFactory<Media, Float>("cost"));
                if(cart.getItemsOrdered() != null)
//                        tblMedia.setItems();
                        tblMedia.setItems(cart.getItemsOrdered());

                btnPlay.setVisible(false);
                btnRemove.setVisible(false);
                tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
                        @Override
                        public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
                                updateButtonBar(newValue);
                        }
                        void updateButtonBar(Media media) {
                                if (media == null) {
                                        btnPlay.setVisible(false); btnRemove.setVisible(false);
                                }
                                else {
                                        btnRemove.setVisible(true);
                                        if(media instanceof Playable) { btnPlay.setVisible(true);
                                        }
                                        else {
                                                btnPlay.setVisible(false);
                                        }
                                }
                        }
                });
                txtFilter.textProperty().addListener((observable, oldValue, newValue) -> filterMediaList(newValue));
                updateTotalPrice();
        }

}
