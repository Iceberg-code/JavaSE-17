package cn.itcast.day17.demo03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* 文件复制练习：
*
* 明确：
*       数据源：F:\W.jpg
*       数据的目的地：F:\abc\W.jpg
*
* 文件复制的步骤：
*       1、创建一个字节输入流对象，构造方法中绑定要读取的数据源
*       2、创建一个字节输出流对象，构造方法中绑定要写入的目的地
*       3、使用字节输入流对象中的方法read读取文件
*       4、使用字节输出流中的方法write，把读取到的字节写入到目的地的文件中
*       5、释放资源
* */
public class Demo01CopyFile {
    public static void main(String[] args) throws IOException {
        //1、创建一个字节输入流对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("F:\\W.jpg");

        //2、创建一个字节输出流对象，构造方法中绑定要写入的目的地
        FileOutputStream fos = new FileOutputStream("F:\\abc\\wp.jpg");

/*
        //方法1：一次读取一个字节，写入一个字节的方式
        //3、使用字节输入流对象中的方法read读取文件
        int len = 0;
        while ((len = fis.read()) != -1){
            //4、使用字节输出流中的方法write，把读取到的字节写入到目的地的文件中
            fos.write(len);
        }
*/
        //方法2：使用数组缓冲读取多个字节，写入多个字节
        byte[] bytes = new byte[1024];  //数组大小或者是1024的整数倍
        //3、使用字节输入流对象中的方法read读取文件
        int len = 0;    //每次读取的有效字节个数
        while((len = fis.read(bytes)) != -1){
            //4、使用字节输出流中的方法write，把读取到的字节写入到目的地的文件中
            fos.write(bytes, 0, len);
        }

        //5、释放资源(先关闭写的，后关闭读的；因为如果写完了，一定就读完了，而读完了不一定写完)
        fos.close();
        fis.close();
    }
}
