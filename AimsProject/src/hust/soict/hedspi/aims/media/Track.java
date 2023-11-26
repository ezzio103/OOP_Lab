package hust.soict.hedspi.aims.media;

public class Track implements Playable{
    private String title;
    private int length;

    // Constructors
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getter methods
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    @Override
    public void play() {
        System.out.println("Playing track: " + this.getTitle());
        System.out.println("Track length: " + this.getLength());
    }
    @Override
    public boolean equals(Object obj) {
        // Check if the reference is the same
        if (this == obj) {
            return true;
        }

        // Check if the passed object is null or of a different class
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Cast the object to Track
        Track otherTrack = (Track) obj;

        // Check if titles and lengths are equal
        return title.equals(otherTrack.title) && length == otherTrack.length;
    }
}
