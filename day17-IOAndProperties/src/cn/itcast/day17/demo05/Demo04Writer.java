package cn.itcast.day17.demo05;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
* 续写和换行：
* 续写，追加写：使用两个参数的构造方法
*   FileWriter(File file, boolean append)
*   FileWriter(String fileName, boolean append)
*       构造方法的参数：
*           File file：是一个文件
*           String fileName：文件的路径
*           boolean append：续写开关
*               true：不会创建新的文件覆盖源文件，可以续写
*               false：创建新的文件覆盖源文件
* 换行符号：
*   windows：\r\n
*   linux：/n
*   mac：/r
* */
public class Demo04Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("day17-IOAndProperties\\7.txt", true);
        for (int i = 0; i < 10; i++) {
            fw.write("HelloWorld" + i + "\r\n");
        }
        fw.close();
    }
}
