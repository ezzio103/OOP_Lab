package hust.soict.hedspi.test.cart.CartTest;


import hust.soict.hedspi.aims.cart.Cart.Cart;
import hust.soict.hedspi.aims.media.*;

import javax.naming.LimitExceededException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartTest {
    public static void main(String[] args) throws LimitExceededException {
        // Create a new cart
        Cart cart = new Cart();

        // Create new dvd objects and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        // Test the print method
        cart.print();

        ArrayList<Track> track1 = new ArrayList<Track>();
        Track t1 = new Track("t1",13);
        Track t2 = new Track("t2",12);

        track1.add(t1);
        track1.add(t2);
        CompactDisc cd = new CompactDisc(1,"cd_title","cat1",10.5f,"dc",
                track1);
        List<Media> mediae = new ArrayList<Media>();
        DigitalVideoDisc dvd = new DigitalVideoDisc("Movie Title", "Action", "Film Director",12 , 120);

        // Tạo Book
        Book book = new Book(2, "Java Programming", "Programming", 29.99f);
        book.addAuthor("John Doe");
        book.addAuthor("Jane Smith");
         // tạo một số phương tiện ở đây
         // ví dụ: cd, dvd, book

        mediae.add(cd);
         mediae.add(dvd);
         mediae.add(book);

         for (Media m: mediae) {
             System.out.println("\n123."+m.toString());
            }

        System.out.println("Original Order:");
        for (Media media : mediae) {
            System.out.println(media);
        }

        // Sắp xếp theo tiêu đề, sau đó theo chi phí
        Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);

        System.out.println("\nSorted by Title then Cost:");
        for (Media media : mediae) {
            System.out.println(media);
        }

        // Sắp xếp theo chi phí, sau đó theo tiêu đề
        Collections.sort(mediae, Media.COMPARE_BY_COST_TITLE);

        System.out.println("\nSorted by Cost then Title:");
        for (Media media : mediae) {
            System.out.println(media);
        }
    }


}
