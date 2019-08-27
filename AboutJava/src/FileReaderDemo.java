import java.io.FileReader;
import java.io.IOException;

/**
 * @author Ling
 * Created on 2019/8/27
 * 读取文件
 */
public class FileReaderDemo {
    public static void main(String[] args) throws IOException {
        //要保证文件是已经存在的，否则会报FileNotFoundException
        FileReader fr = new FileReader("demo.txt");

        char[] buf = new char[1024];
        int num = 0;

        while((num=fr.read(buf)) != -1){
            System.out.println(new String(buf, 0, num));
        }
    }
}
