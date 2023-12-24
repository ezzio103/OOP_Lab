package hust.soict.hedspi.aims.media;

import hust.soict.hedspi.aims.exception.PlayerException;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable{
    private String artist;
    private ArrayList<Track> tracks;

    // Constructors
    public CompactDisc(int id, String title, String category, float cost, String director, ArrayList<Track> tracks) {
        super(id, title, category, cost, director);
        if(tracks!=null){
            this.tracks = new ArrayList<>(tracks);
        }


    }

    // Getter methods
    public String getArtist() {
        return artist;
    }

    // Other methods
    public void addTrack(Track track) {


        if (tracks.contains(track)) {
            System.out.println("The track is already in the list.");
        } else {
            tracks.add(track);
        }
    }

    public void removeTrack(Track track) {
        if(tracks!=null)

        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("The track is not in the list.");
        }
    }

    public ArrayList<Track> getTracks() {
        return tracks;
    }

    public int getLength() {
        int totalLength = 0;
        if(tracks!=null)
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }
    @Override
    public void play() throws PlayerException{
        if(this.getLength() > 0) {
// TODO Play all tracks in the CD as you have implemented
            System.out.println("Playing CD: " + this.getTitle());
            System.out.println("CD length: " + this.getLength());
            for (Track track : tracks) {
                try {
                    track.play();
                } catch (PlayerException e) {
                    e.printStackTrace();
                }
            }
        }else {
            throw new PlayerException("ERROR: CD length is non-positive!"); }
    }
//    @Override
//    public void play() throws PlayerException {
//        System.out.println("Playing CD: " + this.getTitle());
//        System.out.println("CD artist: " + this.getArtist());
//        System.out.println("CD length: " + this.getLength());
//
//        // Loop through each track and play
//        for (Track track : tracks) {
//            track.play();
//        }
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CompactDisc - ");
        sb.append("Title: ").append(getTitle()).append(", ");
        sb.append("Category: ").append(getCategory()).append(", ");
        sb.append("Cost: ").append(getCost()).append(", ");
        sb.append("Director: ").append(getDirector()).append(", ");
        sb.append("Artist: ").append(getArtist()).append(", ");
        if(getTracks()!=null)
        sb.append("Tracks: ").append(getTracks().size()).append(" tracks");
        return sb.toString();
    }
}
