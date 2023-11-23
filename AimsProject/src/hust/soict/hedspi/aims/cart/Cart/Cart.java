package hust.soict.hedspi.aims.cart.Cart;

import hust.soict.hedspi.aims.media.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;
    

    public Cart() {
        itemOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
        qtyOrdered = 0;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemOrdered[i] != null && itemOrdered[i].getTitle() == disc.getTitle()) {
                itemOrdered[i] = null;
                qtyOrdered--;
                System.out.println("The disc has been removed.");
                return;
            }
        }
        System.out.println("The disc was not found in the cart.");
    }

    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {

            if (itemOrdered[i] != null) {
                System.out.println(i+" "+ this.itemOrdered[i].getTitle()+" "+this.itemOrdered[i].getCost() );
                total += itemOrdered[i].getCost();
            }
        }
        System.out.println("total cost: "+ total );

        return total;
    }
    
	 public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList) {
        for (DigitalVideoDisc disc : dvdList) {
            if (disc != null) {
                addDigitalVideoDisc(disc);
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
	public void addDigitalVideoDisc(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    public void printList(){
        int i=1;
        float total=0;
        for (DigitalVideoDisc disc : this.itemOrdered
        ) {
            if(disc!=null){
                System.out.println(i+"."+ disc.toString()+"\n");
                i++;
                total +=disc.getCost();
            }



        }
        System.out.println("Total: "+ total+"\n");
    }
    public DigitalVideoDisc searchById(int id) {
        for (DigitalVideoDisc disc : itemOrdered) {
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
        for (DigitalVideoDisc disc : itemOrdered) {
            if (disc != null && disc.getTitle().equalsIgnoreCase(title)) {
                System.out.println("DVD : " + disc.getTitle() + " (ID: " + disc.getId() + ")");
                found = true;
            }
        }

        if (!found) {
            System.out.println("khong tim thay '" + title );
        }
    }

}
