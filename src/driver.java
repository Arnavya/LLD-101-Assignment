import java.io.IOException;
import java.util.*;

public class driver {
    public static void main(String[] args) throws IOException {
        DatasetReader ds = new DatasetReader();

        List<Book> books = ds.loadBooks("/Users/arnavya/Desktop/LLD/Kshitij/Library_Management/src/amazon-books.csv");

        Service service = new Service(books);

        Scanner sc = new Scanner(System.in);
        System.out.println("1. Total number of books by an author");
        System.out.println("2. Print all authors");
        System.out.println("3. Print all books by an author");
        System.out.println("4. Classify books by rating");
        System.out.println("5. Print price of all books by an author");
        System.out.println("6. Exit");

        while (true) {
            System.out.print("Enter number of the query you want to perform ");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice == 1) {
                System.out.println("Enter name of the author");
                String author = sc.nextLine();
                int count = service.NoOfBooks(author);
                System.out.println(count);
            }
            else if(choice == 2) {
                List<String> list = service.ListOfAuthors();
                System.out.println(list);
            }
            else if(choice == 3) {
                System.out.println("Enter name of the author");
                String author = sc.nextLine();
                List<String> list = service.ListOfBooks(author);
                System.out.println(list);
            }
            else if(choice == 4) {
                System.out.println("Enter rating: ");
                double rating = sc.nextDouble();
                List<Book> list = service.getBooks(rating);
                System.out.println(list);
            }
            else if(choice == 5) {
                System.out.println("Enter name of Author: ");
                String author = sc.nextLine();
                HashMap<String,Integer> map = service.getNamePrice(author);
                System.out.println(map);
            }
            else if(choice == 6) {
                break;
            }
        }
    }
}
