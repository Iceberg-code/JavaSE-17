package cn.itcast.day17.demo01;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
* 一次写多个字节的方法
*       public void write(byte[] b)：将b.length字节从指定的字节数组写入此输出流
*       public void write(byte[] b, int off, int len) ：从指定的字节数组写入len字节，从偏移量off开始输出到此输出流
* */
public class Demo02OutputStream {
    public static void main(String[] args) throws IOException {
        //创建FileOutputStream对象，构造方法中绑定要写入数据的目的地
        FileOutputStream fos = new FileOutputStream(new File("day17-IOAndProperties\\2.txt"));

        //调用FileOutputStream对象中的write方法，把数据写入到文件中
        //在文件中显示100，写3个字节
        fos.write(49);  //1
        fos.write(48);  //0
        fos.write(48);  //0

        /*
         * public void write(byte[] b)：将b.length字节从指定的字节数组写入此输出流
         * 一次写多个字节
         *       如果写的第一个字节是正数(0-127)，那么显示的时候会查询ASCII码表。
         *       如果写的第一个字节是负数，那么第一个字节会和第二个字节，两个字节组成一个中文显示，查询系统默认码表(简体中文默认是GBK)
         * */
        byte[] bytes = {65, 66, 67, 68, 69};    //ABCDE
        //byte[] bytes = {-65, -66, -67, 68, 69};    //烤紻E
        fos.write(bytes);

        /*
        * public void write(byte[] b, int off, int len) ：把字节数组的一部分写入到文件中
        * int off：数组的开始索引
        * int len：写几个字节
        * */
        fos.write(bytes, 1, 2); //BC

        /*
        * 写入字符的方法：可以使用String中的方法把字符串，转换为字节数组
        *       byte[] getBytes()   把字符串转换为字节数组
        *
        * 注：可以将"a".getBytes()理解为将a转换为ASCII码数组
        * */
        byte[] bytes2 = "你好".getBytes();    //转换为字节数组，因为文件是以字节形式来存储的
        //注意下面的写法
        System.out.println(Arrays.toString(bytes2));    //[-28, -67, -96, -27, -91, -67]
        //UTF-8中3个字节表示一个中文，GBK中2两字节表示一个中文

        //System.out.println(bytes2); //[B@50cbc42f，打印的是一个地址
        fos.write(bytes2);


        //释放资源
        fos.close();



    }
}
