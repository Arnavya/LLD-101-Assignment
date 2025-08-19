public class Book {
    private String title;
    private String author;
    private double User_Rating;
    private int Reviews;
    private int Price;
    private int Year;
    private String Genre;
    public Book(String title, String author, double User_Rating, int Reviews, int Price, int Year, String Genre){
        this.title = title;
        this.author = author;
        this.User_Rating = User_Rating;
        this.Reviews = Reviews;
        this.Price = Price;
        this.Year = Year;
        this.Genre = Genre;
    }
    public String getTitle(){
        return title;
    }
    public String getAuthor(){
        return author;
    }
    public double getUserRating(){
        return User_Rating;
    }
    public int getReviews(){
        return Reviews;
    }
    public int getPrice(){
        return Price;
    }
    public int getYear(){
        return Year;
    }
    public String getGenre(){
        return Genre;
    }
    public void printDetails(){
        System.out.println("Title: " + title+"\nAuthor: " + author+"\nRating: " + User_Rating+"\nReviews: " + Reviews+"\nPrice: " + Price+"\nYear: " + Year
        +"\nGenre: " + Genre);
    }
}
