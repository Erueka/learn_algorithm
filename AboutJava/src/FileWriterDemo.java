import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Ling
 * Created on 2019/8/27
 */
public class FileWriterDemo {
    public static void main(String[] args) throws IOException {
        //创建一个FileWriter对象，一被初始化就要明文件
        //该文件会被创建在指定目录下，如果该目录下已有将覆盖。
        FileWriter fw = new FileWriter("demo.txt");
        //调用wirte将字符串写入到流中。
        fw.write("abcde");
        //将数据刷入目的地中
        fw.flush(); //fw.close() 关闭流前也会刷新
        fw.close();
    }
}
