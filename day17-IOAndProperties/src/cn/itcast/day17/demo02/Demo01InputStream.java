package cn.itcast.day17.demo02;

import java.io.FileInputStream;
import java.io.IOException;

/*
* java.io.InputStream：字节流输入
* 此抽象类是表示字节输入流的所有类的超类
*
* 定义了所有子类共性的方法：
*       int read()：从输入流中读取数据的下一个字节
*       int read(byte[] b)：从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中
*       void close()：关闭此输入流并释放与该流关联的所有系统资源
* 注意：int read()与int read(byte[] b)返回值都是int类型，但是表示的意义不一样！
*       int read()返回每个每个字符的ASCII码；int read(byte[] b)返回的是每次读取的有效字节的个数。
*
* java.io.FileInputStream 继承了(extends) InputStream
* FileInputStream：文件字节输入流
* 作用：把硬盘文件中的数据，读取到内存中使用
*
* 构造方法：
*       FileInputStream(String name)
*       FileInputStream(File file)
*           构造方法的参数：读取文件的数据源
*               String name：文件的路径
*               File file：文件
*           构造方法的作用：
*               1、会创建一个FileInputStream对象
*               2、会把FileInputStream对象指向构造方法中要读取的文件
*
* 读取数据的原理(硬盘 --> 内存)
*       java程序 --> JVM --> OS -->OS读取数据的方法 --> 读取文件
*
* 字节输入流的使用步骤(重点)：
*       1、创建FileInputStream对象，构造方法中绑定要读取的数据源
*       2、使用FileInputStream对象中的方法read，读取文件
*       3、释放资源
*
* 注意：使用字节流读取中文文件，可能会发生乱码
*       UTF-8编码时一个中文占3个字节；GBK编码时一个中文占2个字节
* */
public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
        //1、创建FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("day17-IOAndProperties\\1.txt");  //1.txt中为：abc

        //2、使用FileInputStream对象中的方法read，读取文件
        //int read()：读取文件中的一个字节并返回，读取到文件的末尾返回-1
/*
        int len = fis.read();
        System.out.println(len);    //97 (a)

        len = fis.read();
        System.out.println(len);    //98 (b)，int read()方法读取一个之后，会把指针向后移动

        len = fis.read();
        System.out.println(len);    //99 (c)

        len = fis.read();
        System.out.println(len);    //-1
*/
        /*
        * 发现以上读取文件是一个重复的过程，所以可以使用循环优化
        * 不知道文件中中有多少字节，使用while循环
        * while循环结束条件，读取到-1的时候结束
        * */
        int len = 0;    //记录读取到的字节
        while ((len = fis.read()) != -1){
            System.out.println(len);
            System.out.println((char) len);
        }
/*      //注意：上面的循环不能这样写，因为fis.read()执行一次，指针就后移一位
        while (fis.read() != -1){
            System.out.println(fis.read()); //输出：98，-1
        }
*/

        //3、释放资源
        fis.close();
    }
}
