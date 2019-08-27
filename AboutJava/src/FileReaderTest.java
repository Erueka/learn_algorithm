import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Ling
 * Created on 2019/8/27
 */
public class FileReaderTest {
    public static void main(String[] args) throws IOException{
        copy();
    }
    public static void copy() throws IOException {
        FileWriter fw = new FileWriter("demo_copy.txt");

        FileReader fr = new FileReader("demo.txt");

        char[] buf = new char[100];
        int num = 0;

        while((num=fr.read(buf)) != -1){
            fw.write(buf,0,num);
        }

        fw.close();
        fr.close();
    }
}
