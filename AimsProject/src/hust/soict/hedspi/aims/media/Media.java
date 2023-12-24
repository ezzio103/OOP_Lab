package hust.soict.hedspi.aims.media;

import java.util.Comparator;

public abstract class Media {
    private int id;
    private String title;
    private String category;
    private float cost;
    public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
    public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
    public Media(int id, String title, String category, float cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    public Media() {
    }
// Phương thức accessor cho các trường

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public float getCost() {
        return cost;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }
// Các phương thức khác của lớp Media (nếu cần)

    @Override
    public boolean equals(Object o) {
        try {
            // Object compare with itself
            if (o == this) {
                return true;
            }
            // Check if the object is an instance of Media
            if (!(o instanceof Media other)) {
                return false;
            }
            // Compare the titles and return accordingly
            return this.getTitle().equals(other.getTitle()) && this.getCost() == other.getCost();
        } catch (NullPointerException | ClassCastException e) {
            return false;
        }
    }


}
