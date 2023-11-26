package hust.soict.hedspi.test.store;


import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store store = new Store();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // Add DVDs to the store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);

        // Print the current state of the store
        System.out.println("Current state of the store:");
        printStoreItems(store);

        // Remove a DVD from the store
        store.removeMedia(dvd2);

        // Print the updated state of the store
        System.out.println("Updated state of the store:");
        printStoreItems(store);
    }

    private static void printStoreItems(Store store) {
        for (Media dvd : store.getItemsInStore()) {
            if (dvd != null) {
                System.out.println(dvd.getTitle());
            }
        }
        System.out.println("--------------");
    }
}

