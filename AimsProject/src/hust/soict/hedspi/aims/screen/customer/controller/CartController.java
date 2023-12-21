package hust.soict.hedspi.aims.screen.customer.controller;
import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

        public CartController(Store store, Cart cart) {
                this.store = store;
                this.cart = cart;
        }

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
        void btnPlayPressed(ActionEvent event) {
//
        }

        @FXML
        void btnRemovePressed(ActionEvent event) {
                Media media = tblMedia.getSelectionModel().getSelectedItem();
                cart.removeMedia (media);
        }

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

        }

}
