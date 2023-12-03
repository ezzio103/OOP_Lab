package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StoreManagerScreen extends JFrame{
    Store store;
    public StoreManagerScreen (Store store) { this.store = store;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);
        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    JPanel createNorth(){
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north,BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        return north;
    };
    JMenuBar createMenuBar() {
         JMenu menu = new JMenu("Options");
        menu.add(new JMenuItem("View store"));
        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));
        menu.add(smUpdateStore);
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }
    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font. PLAIN, 50)); title.setForeground(Color.CYAN);
        header.add(Box.createRigidArea (new Dimension (10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea (new Dimension (10, 10)));
        return header;
    }
    JPanel createCenter() {
        JPanel center = new JPanel(); center.setLayout(new GridLayout(3, 3, 2, 2));
        ArrayList<Media> mediaInStore = store.getItemsInStore(); for (int i = 0; i < 9; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i)); center.add(cell);
        }
        return center;
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
//        Store store = new Store();

        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Aladin1", "Animation", 18.99f);
        DigitalVideoDisc dvd5 = new DigitalVideoDisc("Aladin2", "Animation", 18.99f);
        DigitalVideoDisc dvd6 = new DigitalVideoDisc("Aladin3", "Animation", 18.99f);
        DigitalVideoDisc dvd7 = new DigitalVideoDisc("Aladin4", "Animation", 18.99f);
        DigitalVideoDisc dvd8 = new DigitalVideoDisc("Aladin5", "Animation", 18.99f);
        DigitalVideoDisc dvd9 = new DigitalVideoDisc("Aladin6", "Animation", 18.99f);

        // Add DVDs to the store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(dvd4);
        store.addMedia(dvd5);
        store.addMedia(dvd6);
        store.addMedia(dvd7);
        store.addMedia(dvd8);
        store.addMedia(dvd9);
        new StoreManagerScreen(store);
    }
}
