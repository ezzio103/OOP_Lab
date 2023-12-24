package hust.soict.hedspi.aims.Aims;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.exception.PlayerException;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.media.Playable;
import hust.soict.hedspi.aims.store.Store;

import javax.naming.LimitExceededException;
import java.util.Scanner;

//public class Aims {
//
//        public static void main(String[] args) {
//            DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion", "Animation","Roger Allers",87,19.95f);
//            DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars","Science Fiction","George Lucas",87,24.95f);
//            DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin","Animation",18.99f);
//			Cart anOrder = new Cart();
//
//
//            anOrder.addMedia(dvd1);
//            anOrder.addMedia(dvd2);
//			anOrder.addMedia(dvd3);
//			anOrder.totalCost();
//			anOrder.removeMedia(dvd2);
//
//			anOrder.removeMedia(dvd3);
//            anOrder.totalCost();
//
//			 DigitalVideoDisc[] itemOrdered2 = new DigitalVideoDisc[2];
//            itemOrdered2[0]=dvd2;
//            itemOrdered2[1]=dvd3;
//            anOrder.addMedia(itemOrdered2);
//            anOrder.totalCost();
//
//			anOrder.removeMedia(dvd2);
//
//			anOrder.removeMedia(dvd3);
//			anOrder.totalCost();
//
//			 anOrder.addMedia(dvd2,dvd3);
//			 anOrder.totalCost();
//        }
//
//}

///////////////////////////////////////
public class Aims {
    public static void main(String[] args) throws PlayerException, LimitExceededException {
        Store store = new Store();
        Cart cart = new Cart();
//        Store store = new Store();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Add DVDs to the store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    viewStore(store, cart, scanner);
                    break;
                case 2:
                    updateStore(store, scanner);
                    break;
                case 3:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 0);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("- ");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println(". -");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore(Store store, Cart cart, Scanner scanner) throws PlayerException, LimitExceededException {
        storeMenu();
        int choice;
        do {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    seeMediaDetails(store,cart, scanner);
                    break;
                case 2:
                    addMediaToCart(store, cart, scanner);
                    break;
                case 3:
                    playMedia(store, scanner);
                    break;
                case 4:
                    seeCurrentCart(cart, scanner);
                    break;
                case 0:
                    System.out.println("Back to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 0);
    }

    public static void storeMenu() {
        System.out.println("Options: ");
        System.out.println(". -");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("- -");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails(Store store, Cart cart, Scanner scanner) throws PlayerException, LimitExceededException {
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);




        if (media != null) {
            System.out.println(media);
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    addMediaToCart(store, cart, media);

                    break;

                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("Cannot play this type of media.");
                    }
                    break;
                case 0:
                    System.out.println("Back to store menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println(". -");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addMediaToCart(Store store, Cart cart, Scanner scanner) throws LimitExceededException {
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart. Current cart size: " + cart.size());
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void addMediaToCart(Store store, Cart cart, Media media) throws LimitExceededException {
        cart.addMedia(media);
        System.out.println("Media added to cart. Current cart size: " + cart.size());
    }

    public static void playMedia(Store store, Scanner scanner) throws PlayerException {
        System.out.println("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("Media not found or cannot be played.");
        }
    }

    public static void updateStore(Store store, Scanner scanner) {
        // Implement the logic to add or remove a media from the store
        // You can use similar patterns as in the viewStore method
    }

    public static void seeCurrentCart(Cart cart, Scanner scanner) {
        cartMenu();
        int choice;
        do {
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    filterMediaInCart(cart, scanner);
                    break;
                case 2:
                    sortMediaInCart(cart, scanner);
                    break;
                case 3:
                    removeMediaFromCart(cart, scanner);
                    break;
                case 4:
                    playMediaInCart(cart, scanner);
                    break;
                case 5:
                    placeOrder(cart);
                    break;
                case 0:
                    System.out.println("Back to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }

        } while (choice != 0);
    }

    public static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("- ");
        System.out.println("1. Filter media in cart");
        System.out.println("2. Sort media in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("- ");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterMediaInCart(Cart cart, Scanner scanner) {
        // Implement the logic to filter media in cart by id or title
    }

    public static void sortMediaInCart(Cart cart, Scanner scanner) {
        // Implement the logic to sort media in cart by title or cost
    }

    public static void removeMediaFromCart(Cart cart, Scanner scanner) {
        // Implement the logic to remove media from cart
    }

    public static void playMediaInCart(Cart cart, Scanner scanner) {
        // Implement the logic to play a media in the cart
    }

    public static void placeOrder(Cart cart) {
        // Implement the logic to notify the user that an order is created and empty the current cart
        System.out.println("Order created. Cart emptied.");
        cart.clear();
    }
}
