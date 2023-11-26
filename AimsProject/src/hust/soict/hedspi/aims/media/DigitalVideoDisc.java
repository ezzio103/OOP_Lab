package hust.soict.hedspi.aims.media;
public class DigitalVideoDisc extends Disc implements Playable {



    private static int nbDigitalVideoDiscs = 0;


    public DigitalVideoDisc(String title) {
        super();
        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
        setTitle(title);


    }

    public DigitalVideoDisc(String title, String category, float cost) {
        super();

        nbDigitalVideoDiscs++;
        setId(nbDigitalVideoDiscs);
        setTitle(title);
        setCategory(category);
        setCost(cost);

    }

    public DigitalVideoDisc(String title, String category, float cost, String director) {
        super(++nbDigitalVideoDiscs, title, category, cost,director);


    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category,director,length, cost);


    }






    @Override
    public String toString() {
        return "DVD" +
                "id=" +  getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", cost=" + getCost() +
                ", director='" + getDirector()+ '\'' +
                ", length=" + getLength() +
                '}';
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

}
