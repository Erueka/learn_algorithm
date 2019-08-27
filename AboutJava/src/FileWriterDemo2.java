import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Ling
 * Created on 2019/8/27
 * FileWriter的标准写法
 */
public class FileWriterDemo2 {
    public static void main(String[] args) {
        FileWriter fw = null;
        try{
            fw = new FileWriter("demo.txt", true);

            fw.write("12345");
            fw.write("nihao\nxiexie");
        }
        catch (IOException e){
            System.out.println(e.toString());
        }
        finally {
            try{
                if(fw != null)
                    fw.close();
            }
            catch (IOException e){
                System.out.println(e.toString());
            }
        }
    }
}
