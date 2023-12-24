package hust.soict.hedspi.aims.screen.customer.controller;

        import hust.soict.hedspi.aims.cart.Cart.Cart;
        import hust.soict.hedspi.aims.exception.PlayerException;
        import hust.soict.hedspi.aims.media.Media;
        import hust.soict.hedspi.aims.media.Playable;
        import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
        import javafx.geometry.Insets;
        import javafx.scene.control.Button;
        import javafx.scene.control.Label;
        import javafx.scene.layout.HBox;

public class ItemController {

    @FXML
    private Button btnAddToCart;

    @FXML
    private Button btnPlay;

//    @FXML
//    private Button btnAddToCart;
    @FXML
    private Label lblTitle;
    @FXML
    private Label lblCost;

    private Media media;
    private Cart cart; // Reference to the Cart

    public ItemController(Cart cart) {
        this.cart = cart;
    }

//    public void setData(Media media) {
//        this.media = media;
//        lblTitle.setText(media.getTitle());
//        lblCost.setText(media.getCost() + " $");
//    }

    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        if (!cart.getItemsOrdered().contains(media)) {
            media.setId(cart.getItemsOrdered().size() + 1);
            cart.getItemsOrdered().add(media);
            System.out.println("The media has been added to the cart.");
        } else {
            System.out.println("The media is already in the cart.");
        }
    }

//    @FXML
//    void btnAddToCartClicked(ActionEvent event) {
//
//
//    }

    @FXML
    void btnPlayClicked(ActionEvent event) throws PlayerException {
        if (media instanceof Playable) {
            Playable playableMedia = (Playable) media;
            playableMedia.play(); // Call the play method on the media
            System.out.println("Playing: " + media.getTitle());
        }
    }
//      private Media media;
      public void setData(Media media) {
          this.media = media;
          lblTitle.setText(media.getTitle());
          lblCost.setText(media.getCost()+" $");
          if(media instanceof Playable) {
              btnPlay.setVisible(true);
          }
          else {
              btnPlay.setVisible(false);
//              HBox.setMargin (btnAddToCart, new Insets(0, 0, 0, 60));
          }
      }
}