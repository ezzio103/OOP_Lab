package hust.soict.hedspi.aims.store;


import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Media;

import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();
    private int currentIndex;

    public Store() {

    }

    public ArrayList<Media> getItemsInStore() {
        return itemsInStore;
    }
//    public DigitalVideoDisc[] getItemsInStore() {
//
//        return itemsInStore;
//    }


    public void setItemsInStore(ArrayList<Media> itemsInStore) {
        this.itemsInStore = itemsInStore;
    }

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media has been added to the store.");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media has been removed from the store.");
        } else {
            System.out.println("The media was not found in the store.");
        }
    }

    public Media searchByTitle(String title) {
        if(title!=null){
            for (Media m : this.getItemsInStore()
            ) {
                if(m.getTitle().equals(title)){
                    return m;
                }
            }
        }
    return null;
    }
}

