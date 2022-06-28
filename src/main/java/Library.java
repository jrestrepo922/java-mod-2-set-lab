import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Library {
    private HashMap<String, Book> collectionOfBooks;
    private Set<String> uniqueGenres; 

    public Library() {
        this.collectionOfBooks = new HashMap<String, Book>();
        this.uniqueGenres = new HashSet<String>();
    }


    public HashMap<String, Book> getCollectionOfBooks() {
        return collectionOfBooks;
    }


    public void setCollectionOfBooks(HashMap<String, Book> collectionOfBooks) {
        this.collectionOfBooks = collectionOfBooks;
    }


    public Set<String> getUniqueGenres() {
        return uniqueGenres;
    }


    public void setUniqueGenres(Set<String> uniqueGenres) {
        this.uniqueGenres = uniqueGenres;
    }

    

    
}

