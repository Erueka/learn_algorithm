import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Ling
 * Created on 2019/9/7
 *
 * 右键generate可以让IDEA自动生成方法，例如getter和setter
 *
 * 对于List的遍历，ArraryList应使用get()随机访问方法。
 * LinkedList应使用迭代器，应为其以列表保存元素。
 *
 * LinkedList可以当作队列和栈来使用，因为它实现了Deque接口，
 * 即双端队列。
 */
class User{
    private int id;
    private String account;
    private String password;
    private String name;

    public void setId(int id) {
        this.id = id;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getAccount() {
        return account;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public User(int id, String account, String password, String name){
        this.id = id;
        this.name = name;
        this.account = account;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", account=" + account + ", " +
                "password=" + password + ", name=" + name + "]";
    }
}


public class LinkedListTest {
    static User user1 = new User(1, "账号1", "密码1", "姓名1");
    static User user2 = new User(2, "账号2", "密码2", "姓名2");
    static User user3 = new User(3, "账号3", "密码3", "姓名3");
    static User user4 = new User(4, "账号4", "密码4", "姓名4");
    static User user5 = new User(5, "账号5", "密码5", "姓名5");
    public static void main(String[] args) {
        System.out.println("________栈测试________");
        stackTest();
        System.out.println("\n\n_______队列测试_______");
        queueTest();
    }

    public static void stackTest(){
        LinkedList ls = new LinkedList();
        ls.addFirst(user1);
        ls.addFirst(user2);
        ls.addFirst(user3);
        System.out.println("一二三号用户依次入栈。");
        System.out.println("栈顶元素是："+ls.getFirst());
        System.out.println("出栈一个。");
        ls.removeFirst();
        System.out.println("栈顶元素是："+ls.getFirst());
        ls.addFirst(user3);
        ls.addFirst(user4);
        ls.addFirst(user5);
        System.out.println("三四五号用户入栈。");
        ls.addFirst(user5);
        System.out.println("五号再次入栈。\n栈为："+ls);
        System.out.println("可见LinkedList可添加重复元素。");
        ls.clear();
        System.out.println("清空栈，释放内存。"+"\n栈为："+ls);
    }

    public static void queueTest(){
        LinkedList ls = new LinkedList();
        ls.addLast(user1);
        ls.addLast(user2);
        ls.addLast(user3);
        ls.addLast(user4);
        ls.addLast(user5);
        System.out.println("一二三四五用户依次入队列。");
        System.out.println("两名用户出队列。");
        ls.removeFirst();
        ls.removeFirst();
        for (Iterator i = ls.listIterator();i.hasNext();){
            System.out.println(i.next());
        }
    }
}
