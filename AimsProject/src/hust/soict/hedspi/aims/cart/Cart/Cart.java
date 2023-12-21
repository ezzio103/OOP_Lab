package hust.soict.hedspi.aims.cart.Cart;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.ArrayList;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
//    private ArrayList<Media> itemsOrdered = new ArrayList<Media>();

    private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();

    public Cart() {


    }

    public void addMedia(Media media) {
        if (!itemsOrdered.contains(media)) {
            itemsOrdered.add(media);
            System.out.println("The media has been added to the cart.");
        } else {
            System.out.println("The media is already in the cart.");
        }
    }

    public void removeMedia(Media media) {
        if (itemsOrdered.remove(media)) {
            System.out.println("The media has been removed.");
        } else {
            System.out.println("The media was not found in the cart.");
        }
    }

    public float totalCost() {
        float total = 0;
        int i=0;
        for (Media media : itemsOrdered) {
            total += media.getCost();
            System.out.println(i+" "+ media.getTitle()+" "+ media.getCost());
            i++;


        }
        System.out.println("Total cost: " + total);
        return total;


    }
    
	 public void addMedia(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (disc != null) {
                addMedia(disc);
            }
        }
    }
//    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
//        for (DigitalVideoDisc dvd : dvds) {
//            if (qtyOrdered < MAX_NUMBERS_ORDERED) {
//                itemOrdered[qtyOrdered++] = dvd;
//                System.out.println("The disc '" + dvd.getTitle() + "' has been added.");
//            } else {
//                System.out.println("The cart is full. Cannot add more discs.");
//            }
//        }
//    }
	public void addMedia(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addMedia(dvd1);
        addMedia(dvd2);
    }
    public void print(){
        int i=1;
        float total=0;
        for (Media disc : this.itemsOrdered
        ) {
            if(disc!=null){
                System.out.println(i+"."+ disc.toString()+"\n");
                i++;
                total +=disc.getCost();
            }



        }
        System.out.println("Total: "+ total+"\n");
    }
    public Media searchById(int id) {
        for (Media disc : itemsOrdered) {
            if (disc != null && disc.getId() == id) {
                System.out.println("DVD found: " + disc.getTitle() + " (ID: " + disc.getId() + ")");
                return disc;
            }
        }
        System.out.println("DVD with ID " + id + " not found in the cart.");
        return null;
    }
    public void searchByTitle(String title) {
        boolean found = false;
        for (Media disc : itemsOrdered) {
            if (disc != null && disc.getTitle().equalsIgnoreCase(title)) {
                System.out.println("DVD : " + disc.getTitle() + " (ID: " + disc.getId() + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("khong tim thay '" + title );
        }
    }

    public int size() {
        return this.itemsOrdered.size();
    }

    public void clear() {
        itemsOrdered.clear();
        System.out.println("The cart has been cleared.");
    }

    public ObservableList<Media> getItemsOrdered() {
        return itemsOrdered;
    }
//    public void sapXepItemOrdered(){
//        int f=-1;
//        for(int i=0;i<qtyOrdered;i++){
//            if(itemsOrdered[i]==null){
//                f=i;
//            }else {
//                if(f==-1){
//                    continue;
//                }
//                itemsOrdered[f]= itemsOrdered[i];
//                itemsOrdered[i]=null;
//                f=i;
//            }
//        }
//        qtyOrdered=f;
//    }
}
