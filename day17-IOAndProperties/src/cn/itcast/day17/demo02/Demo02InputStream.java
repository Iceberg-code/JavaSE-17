package cn.itcast.day17.demo02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
* 字节输入流一次读取多个字节的方法：
*       int read(byte[] b)：从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中
* 明确2件事情：
*       1、方法的参数byte[]的作用？
*           起到缓冲作用，存储每次读取到的多个字节
*           数组的长度一般定义为1024(1kb)，或者1024的整数倍
*       2、方法的返回值int是什么？
*           是每次读取的有效字节的个数。      注意与int read()方法的区别，返回值不一样！！！
*
* String类的构造方法：
*       String(byte[] bytes)：把字节数组转换为字符串
*       String(byte[] bytes, int offset, int length)：把字节数组的一部分转换为字符串
*           int offset：数组的开始索引
*           int length：转换的字节个数
* */
public class Demo02InputStream {
    public static void main(String[] args) throws IOException {
        //创建FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("day17-IOAndProperties\\2.txt");  //2.txt中为：ABCDE

/*
        //使用FileInputStream对象中的方法read读取文件
        //int read(byte[] b)：从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。每执行一次，指针也会向后移
        byte[] bytes = new byte[2];
        int len = fis.read(bytes);
        System.out.println(len);    //2，是每次读取的有效字节的个数
        //输出数组用Arrays里面的toString方法输出
        System.out.println(Arrays.toString(bytes)); //[65, 66]
        System.out.println(new String(bytes));  //AB

        len = fis.read(bytes);
        System.out.println(len);    //2
        //输出数组用Arrays里面的toString方法输出
        System.out.println(Arrays.toString(bytes)); //[67, 68]
        System.out.println(new String(bytes));  //CD

        len = fis.read(bytes);
        System.out.println(len);    //1
        //输出数组用Arrays里面的toString方法输出
        System.out.println(Arrays.toString(bytes)); //[69, 68]
        System.out.println(new String(bytes));  //ED

        len = fis.read(bytes);
        System.out.println(len);    //-1
        //输出数组用Arrays里面的toString方法输出
        System.out.println(Arrays.toString(bytes)); //[69, 68]
        System.out.println(new String(bytes));  //ED
*/

        /*
        * 发现以上读取是一个重复的过程，可以使用循环优化
        * 不知道文件中有多少字节，所以使用while循环
        * while循环结束的条件，读取到-1结束
        * */
        byte[] bytes = new byte[1024];  //存储读取到的多个字节。注意：文件中的数据是以字节形式来存储的(我理解为里面存储ASCII码)
        int len = 0;        //记录每次读取的有效字节个数
        while ((len = fis.read(bytes)) != -1){

            //bytes中存储了[65, 66, 67, 68, 69, 0, 0,...]，共1024个数据
            //System.out.println(Arrays.toString(bytes));   //打印数组bytes。注：后面都是打印0

            //注意new String(bytes)的写法，用String的构造方法
            //System.out.println(new String(bytes));  //注：打印不出byte[]数组中后面的0，这里输出的是一串的空格

            //使用String的构造方法：String(byte[] bytes, int offset, int length)：把字节数组的一部分转换为字符串
            //把bytes数组中存储的字节(我理解为存储ASCII码)，通过String的构造方法转换为字符，打印输出
            System.out.println(new String(bytes, 0, len));  //后面没空格了
            //System.out.println(len);  //5

            //字节和ASCII码的关系，再研究！！！
        }

        //释放资源
        fis.close();
    }
}
