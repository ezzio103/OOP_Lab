package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {

    private TextField titleInput;
    private TextField categoryInput;
    private TextField directorInput;
    private TextField lengthInput;
    private TextField costInput;

    public AddDigitalVideoDiscToStoreScreen( Store store) {
        super(store);
    }

    @Override
    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(6, 2, 2, 2));

        titleInput = new TextField(10);
        categoryInput = new TextField(10);
        directorInput = new TextField(10);
        lengthInput = new TextField(10);
        costInput = new TextField(10);

        center.add(new Label("Enter a Title: "));
        center.add(titleInput);
        center.add(new Label("Enter a Category: "));
        center.add(categoryInput);
        center.add(new Label("Enter a Director: "));
        center.add(directorInput);
        center.add(new Label("Enter a Length: "));
        center.add(lengthInput);
        center.add(new Label("Enter a Cost: "));
        center.add(costInput);

        JButton addDVD = new JButton("Add");
        addDVD.addActionListener(new AddDVDTFInputListener());
        center.add(addDVD);

        return center;
    }

    protected class AddDVDTFInputListener extends TFInputListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            DigitalVideoDisc dvd = new DigitalVideoDisc(
                    titleInput.getText(),
                    categoryInput.getText(),
                    directorInput.getText(),
                    Integer.parseInt(lengthInput.getText()),
                    Float.parseFloat(costInput.getText())
            );
//            System.out.println("vua tao DVD");

//            ((StoreManagerScreen) SwingUtilities.getWindowAncestor(cp)).addMediaToStore(dvd);
            store.addMedia(dvd);
            System.out.println("da them DVD");

            super.actionPerformed(evt);
        }
    }
}
