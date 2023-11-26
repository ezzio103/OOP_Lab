package hust.soict.hedspi.aims.media;

import java.util.Comparator;

class MediaComparatorByCostTitle implements Comparator<Media> {
    @Override
    public int compare(Media media1, Media media2) {
        int costComparison = Float.compare(media2.getCost(), media1.getCost());
        if (costComparison != 0) {
            return costComparison;
        }
        // Trường hợp chi phí giống nhau, so sánh theo tiêu đề
        return media1.getTitle().compareTo(media2.getTitle());
    }
}
