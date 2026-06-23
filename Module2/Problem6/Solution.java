class Book {
    private int bookId;
    private String title;
    private String author;

    public Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return bookId + " " + title + " " + author;
    }
}

public class Solution {
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int left = 0;
        int right = books.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;
            int comparison = books[middle].getTitle().compareToIgnoreCase(title);

            if (comparison == 0) {
                return books[middle];
            }

            if (comparison < 0) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Book[] books = {
                new Book(1, "Algorithms", "Robert"),
                new Book(2, "Clean Code", "Martin"),
                new Book(3, "Java Basics", "James")
        };

        System.out.println("Linear Search: " + linearSearch(books, "Clean Code"));
        System.out.println("Binary Search: " + binarySearch(books, "Java Basics"));
        System.out.println("Linear Search: O(n)");
        System.out.println("Binary Search: O(log n)");
    }
}
