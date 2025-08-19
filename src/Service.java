import java.util.*;

public class Service {
    List<Book> books;
    HashMap<String, HashSet<Book>> map;
    public Service(List<Book> books) {
        books = books;
        map = new HashMap<>();
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                double r1 = o1.getUserRating();
                double r2 = o2.getUserRating();
                if(r1 > r2) return 1;
                else if(r1 < r2) return -1;
                else return 0;
            }
        });
        for(Book book : books) {
            String author = book.getAuthor();
            if(map.containsKey(author)) map.get(author).add(book);
            else{
                map.put(author, new HashSet<>());
                map.get(author).add(book);
            }
        }
    }
    public int NoOfBooks(String author) {
        return map.get(author).size();
    }
    public List<String> ListOfAuthors() {
        List<String> list = new ArrayList<>();
        for(String author : map.keySet()) {
            list.add(author);
        }
        return list;
    }
    public List<String> ListOfBooks(String author) {
        List<String> list = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(Book book : map.get(author)) {
            String name = book.getTitle();
            if(set.contains(name)) continue;
            else{
                set.add(name);
                list.add(name);
            }
        }
        set.clear();
        return list;
    }
    public List<Book> getBooks(double rating) {
        List<Book> list = new ArrayList<>();
        int l = 0;
        int r = books.size() - 1;
        int idx = 0;
        while(l<=r){
            int mid = l + (r - l)/2;
            if(books.get(mid).getUserRating() > rating) r=mid-1;
            else if(books.get(mid).getUserRating() < rating) l=mid+1;
            else{
                idx = mid;
                r=mid-1;
            }
        }
        while(idx<books.size() && books.get(idx).getUserRating()==rating){
            list.add(books.get(idx));
            idx++;
        }
        return list;
    }
    public HashMap<String , Integer> getNamePrice(String author) {
        HashMap<String , Integer> ans = new HashMap<>();
        for(Book book : map.get(author)) {
            String name = book.getTitle();
            int price = book.getPrice();
            ans.put(name, price);
        }
        return ans;
    }
}
