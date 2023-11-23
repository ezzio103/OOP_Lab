package hust.soict.hedspi.aims.store;


import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Store {
    private DigitalVideoDisc[] itemsInStore;
    private int currentIndex;

    public Store(int maxSize) {
        itemsInStore = new DigitalVideoDisc[maxSize];
        currentIndex = 0;
    }

    public DigitalVideoDisc[] getItemsInStore() {
        return itemsInStore;
    }

    public void setItemsInStore(DigitalVideoDisc[] itemsInStore) {
        this.itemsInStore = itemsInStore;
    }

    public void addDVD(DigitalVideoDisc dvd) {
        if (currentIndex < itemsInStore.length) {
            itemsInStore[currentIndex] = dvd;
            currentIndex++;
            System.out.println("DVD added to the store.");
        } else {
            System.out.println("The store is full. Cannot add more DVDs.");
        }
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        for (int i = 0; i < currentIndex; i++) {
            if (itemsInStore[i] != null && itemsInStore[i].getTitle().equals(dvd.getTitle())) {
                // Found the DVD, remove it
                for (int j = i; j < currentIndex - 1; j++) {
                    itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[currentIndex - 1] = null;
                currentIndex--;
                System.out.println("DVD removed from the store.");
                return;
            }
        }
        System.out.println("DVD not found in the store.");
    }
}

