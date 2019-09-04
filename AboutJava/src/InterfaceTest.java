/**
 * @author Ling
 * Created on 2019/9/4
 */
interface Output{
    int MAX_CATCH = 50;
    void output();
    void getData(String data);
}
interface Product{
    String getProduceTime();
}
class Priter implements Output, Product{
    private String[] printData = new String[MAX_CATCH];
    private int dataNum = 0;
    public void output(){
        while (dataNum>0){
            System.out.println(printData[0]);
            System.arraycopy(printData, 1, printData, 0, --dataNum);
        }
    }
    public void getData(String data){
        if (dataNum>MAX_CATCH){
            System.out.println("输入队列已满，添加失败。");
        }
        else {
            printData[dataNum++] = data;
            System.out.println("添加成功。");
        }
    }
    public String getProduceTime(){
        return "打印"+dataNum+"个文件需耗时"+(45*dataNum)+"ms。";
    }
    public String getDataNum(){
        return "还有"+dataNum+"个文件待打印。";
    }
}
public class InterfaceTest {
    public static void main(String[] args) {
        Output p = new Priter();
        p.getData("第一句话。");
        p.getData("第二句话。");
        p.getData("第三句话。");
        p.getData("第四句话。");
        System.out.println(((Priter)p).getDataNum());
        System.out.println(((Priter)p).getProduceTime());
        p.output();
        System.out.println(((Priter)p).getDataNum());

    }
}
/*
接口与抽象类

同：
都不能实例化，都位于继承树的顶端。
都可以包含抽象方法，实现或继承的普通类必须实现这些方法。
异：
设计目的不同，接口作为交互的窗口，体现的是一种规范。接口对于实现者，规定了必须
提供哪些服务；对于调用者，接口规定了可以调用哪些服务。接口是多个模块间的耦合标准，
是多个程序之间的通信标准。
抽象类作为多个子类的共同父类，体现的是一种模式设计，相当于一个中间产品，这个产品可能
已经实现了一部分功能，但不能当作最终产品，其没完成的部分还需要由其子类完善。
还有用法上的不同，比如接口只能定义静态常量Field、接口不提供已实现的方法等等，这里不深究。
 */