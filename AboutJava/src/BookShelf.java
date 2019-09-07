import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Ling
 * Created on 2019/9/7
 * 据我观察，总的来说，default的用法不多，只有两种:
 *
 *     在switch语句的时候使用default
 *     在定义接口的时候使用default来修饰具体的方法,也就是
 *     接口内部包含了一些默认的方法实现，这打破了Java之前版本对接口的语法限制。
 */
class Book{
    private String name;
    public Book(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public String toString(){
        return getName();
    }
}

interface BookShelfIterable{
    Iterator iterater();
}

class BookShelfIterator implements Iterator {
    private BookShelf bsf;
    private int index;
    public BookShelfIterator(BookShelf bsf){
        this.bsf = bsf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index<bsf.getLength();
    }

    @Override
    public Book next() {
            Book book = bsf.getBookAt(index++);
            return book;
    }
    /*
    reMove和forEach不用重写，他们在接口中是用default定义的；
     */
}

public class BookShelf implements BookShelfIterable{
    private Book[] books;
    private int length = 0;

    public BookShelf(int Max){
        this.books = new Book[Max];
    }

    public boolean append(Book book){
        if (length >= books.length){
            return false;
        }else {
            books[length++] = book;
            return true;
        }
    }

    public Book getBookAt(int index){
        return books[index];
    }

    public int getLength(){
        return length;
    }

    @Override
    public Iterator iterater() {
        return new BookShelfIterator(this);
    }

    public static void main(String[] args) {
        BookShelf bs = new BookShelf(5);
        bs.append(new Book("Book1"));
        bs.append(new Book("Book2"));
        bs.append(new Book("Book3"));
        bs.append(new Book("Book4"));
        bs.append(new Book("Book5"));

        Iterator i = bs.iterater();
        while (i.hasNext())
            System.out.println(i.next());
    }
}
