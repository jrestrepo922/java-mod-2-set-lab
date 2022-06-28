import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // create a try with resources
        try (Scanner scanner = new Scanner(System.in)) {
            // define a shouldLoop variable
            Boolean moreBooks = true; 
            // Instantiate the library
            Library library = new Library(); 

            System.out.println("========== CREATE A BOOKS AND ADD TO THE LIBRARY ==========");


            // do  a while loop if should loop is set to true
            while(moreBooks){
                
                // ask user if they want to search a book or create one
                System.out.println("Would you like to create a book or search for one? ");
                System.out.println("To create type: 1");
                System.out.println("To search by title type: 2");
                System.out.println("To search all books by genre type: 3");
                String searchOrCreate = scanner.nextLine();


                if(searchOrCreate.equals("1")){

                    // create a scanner that ask for all the construtor values
                    System.out.println("Please provide title");
                    String title = scanner.nextLine();

                    System.out.println("Please provide genre");
                    String genre = scanner.nextLine();

                    System.out.println("Please provide the number of pages");
                    String numberOfPages = scanner.nextLine();

                    // create the book and insert them into library; 
                    Book newBook = new Book(title, genre, Integer.valueOf(numberOfPages)); 
                    library.getCollectionOfBooks().put(newBook.getTitle(), newBook); 
                    library.getUniqueGenres().add(newBook.getGenre()); 

                    System.out.println("Book was created and added to library");
                    // once all the values are entered create another scanner
                    // asking if the user wants to add another book
                    moreBooks = Main.loopAgain(scanner);
                    
                }  else if (searchOrCreate.equals("2")){
                    System.out.println("Please provide the title of the book you would like to search?");
                    String searchByName = scanner.nextLine(); 
                    Book searchedBook = library.getCollectionOfBooks().get(searchByName);
                    if(searchedBook != null){
                        System.out.println("Title: " + searchedBook.getTitle() + ", Genre: " + searchedBook.getGenre() + ", Number of Pages: " + searchedBook.getNumberOfPages());
                    } else {
                        System.out.println("The library does not have that book");
                    }

                    moreBooks = Main.loopAgain(scanner);

                } else if(searchOrCreate.equals("3")){
                    System.out.println("Please provide the genre to search for the books?");
                    String searchByGenre = scanner.nextLine();  
                    Boolean isGenrePresent = library.getUniqueGenres().contains(searchByGenre); 
                    if(isGenrePresent){
                        System.out.println("The library does carry books of that Genre");
                    } else {
                        System.out.println("No books avaliable for that Genre");
                    }

                    moreBooks = Main.loopAgain(scanner);
                    
                } else {
                    System.out.println("please type either search or create");
                    return; 
                }            
            } 
        } 
        // catch (Exception e) {
        //     System.out.println("Something when wrong");
        // }
    }


    private static Boolean loopAgain(Scanner scanner){
        System.out.println("Would you like to create a book or search for one or check if genre exist? ");
        String loopAgainScanner = scanner.nextLine();
        // if users types no than change shouldLoop to false;
        if(loopAgainScanner.equals("no")){
            return false;
        } else {
            return true; 
        }
    } 
}

