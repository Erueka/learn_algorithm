import java.util.Random;

/**
 * @author Ling
 * Created on 2019/8/28
 */
public class Counter {
    private String name;
    private int count = 0;

    public Counter(String id){
        name=id;
    }

    public void increment(){
        count++;
    }

    public int total(){
        return count;
    }

    public String toString(){
        return count +" "+ name;
    }

    public boolean equals(Object x){
        if (this == x) return true;                //自反性
        if (x == null) return false;               //非空性
        if (this.getClass() != x.getClass())
            return false;
        Counter that = (Counter)x;
        if (this.name != that.name)     return false;
        if (this.count != that.count)   return false;
        return true;
    }

    public static void main(String[] args) {
        Counter heads = new Counter("heads");
        Counter tails = new Counter("tails");
        Integer times = Integer.parseInt(args[0]);
        Random r = new Random();
        int toss;


        for (int i=0;i<times;i++){
            toss = r.nextInt(2);
            if (toss == 0)
                heads.increment();
            else
                tails.increment();
        }

        System.out.println("total "+times+" times:\n"+heads+"\n"+tails);

    }
}
