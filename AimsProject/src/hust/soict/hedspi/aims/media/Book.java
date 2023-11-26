package hust.soict.hedspi.aims.media;



import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    public Book(int id, String title, String category, float cost) {
        super( id, title, category,  cost);

// TODO Auto-generated constructor stub
    }

    public Book() {
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    public void addAuthor(String authorName) {
        // Kiểm tra xem tác giả đã có trong danh sách chưa trước khi thêm
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' added to the book.");
        } else {
            System.out.println("Author '" + authorName + "' is already in the list.");
        }
    }

    public void removeAuthor(String authorName) {
        // Kiểm tra xem tác giả có trong danh sách không trước khi xóa
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author '" + authorName + "' removed from the book.");
        } else {
            System.out.println("Author '" + authorName + "' is not in the list.");
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book - ");
        sb.append("Title: ").append(getTitle()).append(", ");
        sb.append("Category: ").append(getCategory()).append(", ");
        sb.append("Cost: ").append(getCost()).append(", ");
        sb.append("Authors: ").append(getAuthors());
        return sb.toString();
    }
}