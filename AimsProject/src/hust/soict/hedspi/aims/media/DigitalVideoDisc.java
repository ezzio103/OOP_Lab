package hust.soict.hedspi.aims.media;
public class DigitalVideoDisc extends Media {


    private String director;
    private int length;

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

    public DigitalVideoDisc(String title, String category, String director, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost);
        this.director = director;

    }

    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(++nbDigitalVideoDiscs, title, category, cost);
        this.director = director;
        this.length = length;

    }


    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }



    @Override
    public String toString() {
        return "DVD" +
                "id=" + getId() +
                ", title='" + getTitle() + '\'' +
                ", category='" + getCategory() + '\'' +
                ", cost=" + getCost() +
                ", director='" + this.director + '\'' +
                ", length=" + this.length +
                '}';
    }
}
