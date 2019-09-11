package InnerClass;

/**
 * @author Ling
 * Created on 2019/9/11
 */
public class Outter {
    private int num = 10;
/*
    public class Inner{
        public void show(){
            System.out.println(num);
        }
    }
*/
     private class Inner{
         public void show(){
             System.out.println(num);
         }
    }

    public void showMethod(){
         Inner i = new Inner();
         i.show();
    }

}
