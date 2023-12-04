package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.Media;
import hust.soict.hedspi.aims.store.Store;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddBookToStoreScreen extends AddItemToStoreScreen{

    private TextField idInput;
    private TextField titleInput;
    private TextField catInput;
    private TextField costInput;

    public AddBookToStoreScreen(Store store) {
        super(store);
    }
    @Override
    JPanel createCenter(){
//        Book book = new Book(1,"book 1","cat 1",18.99f);
        JPanel center = new JPanel();
        JButton a = new JButton("addBook");
        center.setLayout(new GridLayout(5, 2, 2, 2));
//        setLayout(new GridLayout(4, 2));

        idInput = new TextField(10);

        titleInput = new TextField(10);
        catInput = new TextField(10);
        costInput = new TextField(10);
        center.add(new Label("Enter an Id: "));

        center.add(idInput);
        center.add(new Label("Enter an Title: "));

        center.add(titleInput);
        center.add(new Label("Enter an cat: "));

        center.add(catInput);
        center.add(new Label("Enter an cost: "));

        center.add(costInput);
        JButton addBook = new JButton("Add");
        addBook.addActionListener(new AddBookTFInputListener());
//        cp.add(addBook);
        center.add(addBook);

        return center;
    };

    protected class AddBookTFInputListener extends TFInputListener{
        @Override
        public void actionPerformed(ActionEvent evt) {
            Book book = new Book(Integer.parseInt(idInput.getText()),titleInput.getText(), catInput.getText(), Float.parseFloat(costInput.getText()));
//            System.out.println("vua tao sach");
//            ((StoreManagerScreen) SwingUtilities.getWindowAncestor(cp)).addMediaToStore(book);
            store.addMedia(book);
            System.out.println("da them sach");
            super.actionPerformed(evt);
        }
    }
}
