package cn.itcast.day17.demo04;

import java.io.FileInputStream;
import java.io.IOException;
/*
* 注意：使用字节流读取中文文件，可能会发生乱码
*       UTF-8编码时一个中文占3个字节；GBK编码时一个中文占2个字节
* */
public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("day17-IOAndProperties\\3.txt");  //3.txt为：你好
        int len = 0;
        while ((len = fis.read()) != -1){
            System.out.println(len);
            System.out.println((char) len);
        }
        fis.close();
    }
}
