package cn.itcast.day17.demo05;

import java.io.FileWriter;
import java.io.IOException;

/*
* flush方法和close方法的区别：
*       - flush：刷新到缓冲区，流对象可以继续使用
*       - close：先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用。close自带刷新，可以不写flush方法
* */
public class Demo02CloseAndFlush {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("day17-IOAndProperties\\5.txt");
        fw.write(97);   //写入a
        fw.flush();
        //刷新之后流可以继续使用
        fw.write(98);   //写入b
        fw.close();

        //close方法后流已经关闭了，已经从内存中消失了，流就不能再使用了
        //fw.write(99);   //IOException: Stream closed，出现异常
    }
}
