package GenericDemo;

/**
 * @author Ling
 * Created on 2019/9/10
 */
public class Teacher<T> {
    private T age;

    public Teacher(){}

    public Teacher(T age){
        this.age = age;
    }

    public T getAge() {
        return age;
    }

    public void setAge(T age) {
        this.age = age;
    }

    public void info(){
        System.out.println("age:"+age);
    }
}
