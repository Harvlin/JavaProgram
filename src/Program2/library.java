package Program2;
import java.util.HashMap;
import java.util.Scanner;

class Book {
    private String title;
    private String author;
    private int id;
    public String getTitle() {
        return title;
    }
    public int getId() {
        return id;
    }
    public String getAuthor() {
        return author;
    }
    Book(String title, String author, int id) {
        this.title = title;
        this.author = author;
        this.id = id;
    }
}

class BookSystem {
    public HashMap<String, Book> bookMap = new HashMap<>();
    public void addBook(String title, String author, int id) {
        Book obj = new Book(title, author, id);
        if (bookMap.containsKey(title)) {
            System.out.printf("%s Already Exist\n", title);
        } else {
            bookMap.put(title, obj);
            System.out.printf("%s Added\n", title);
        }
    }
    public void removeBook(String title) {
        if (bookMap.containsKey(title)) {
            bookMap.remove(title);
            System.out.printf("%s Deleted\n", title);
        } else {
            System.out.println("Not exist");
        }
    }
    public void bookList() {
        if (bookMap.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (Book obj : bookMap.values()){
                System.out.printf("Title: %s, Author: %s, ID: %d\n", obj.getTitle(), obj.getAuthor(), obj.getId());
            }
        }
    }
    // For BorrowSystem
    public boolean isBookExist(String title) {
        return bookMap.containsKey(title);
    }
}

class BorrowSystem {
    private HashMap<String, Book> borrowedMap;
    private BookSystem bookSystem;
    public BorrowSystem(BookSystem bookSystem) {
        borrowedMap = new HashMap<>();
        this.bookSystem = bookSystem;
    }
    public void borrowBook(String title) {
        if (bookSystem.isBookExist(title)) {
            borrowedMap.put(title, bookSystem.bookMap.get(title));
            bookSystem.removeBook(title);
            System.out.printf("%s Borrowed\n", title);
        } else {
            System.out.println("Book does not exist");
        }
    }
    public void returnBook(String title) {
        if (borrowedMap.containsKey(title)) {
            bookSystem.bookMap.put(title, borrowedMap.get(title));
            borrowedMap.remove(title);
            System.out.printf("%s Returned\n", title);
        } else {
            System.out.println("Book not borrowed");
        }
    }
    public void borrowedList() {
        for (Book obj : borrowedMap.values()) {
            System.out.printf("Title: %s, Author: %s, ID: %d\n", obj.getTitle(), obj.getAuthor(), obj.getId());
        }
    }
}

class Library {
    public void Library() {
        BookSystem bookSystem = new BookSystem();
        BorrowSystem borrowSystem = new BorrowSystem(bookSystem);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("---Library---");
            System.out.println("1. Add Book\n2. Remove Book\n3. Book List\n4. Borrow Book\n5. Return Book\n6. Borrowed Book List\n(E)xit");
            System.out.print("Enter your choice: "); short choice = sc.nextShort();
            switch (choice) {
                case 1:
                    System.out.print("Title: "); String title = sc.nextLine();
                    System.out.println("Author: "); String author = sc.nextLine();
                    System.out.println("ID: "); int id = sc.nextInt();
                    sc.nextLine();
                    bookSystem.addBook(title, author, id);
                    break;
                case 2:
                    System.out.print("Title: "); String removeTitle = sc.nextLine();
                    bookSystem.removeBook(removeTitle);
                    break;
                case 3:
                    bookSystem.bookList();
                    break;
                case 4:
                    System.out.print("Title: "); String borrowTitle = sc.nextLine();
                    borrowSystem.borrowBook(borrowTitle);
                    break;
                case 5:
                    System.out.print("Title: "); String returnTitle = sc.nextLine();
                    borrowSystem.returnBook(returnTitle);
                    break;
                case 6:
                    borrowSystem.borrowedList();
                    break;
                default:
                    sc.close();
                    System.exit(0);
                    break;
            }
        }
    }
}

public class library {
    public static void main(String[] args) {
        Library library = new Library();
        library.Library();
    }
}