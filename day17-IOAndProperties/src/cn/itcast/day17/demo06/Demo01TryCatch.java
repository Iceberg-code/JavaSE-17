package cn.itcast.day17.demo06;

import java.io.FileWriter;
import java.io.IOException;

/*
* 在JDK 1.7之前使用try...catch...finally处理流中的异常
* 格式：
*       try{
*           可能会产生异常的代码
*       } catch(异常类变量 变量名){
*           异常处理逻辑
*       } finally{
*           一定会执行的代码
*           一般是释放资源
*       }
*
* */
public class Demo01TryCatch {
    public static void main(String[] args) {
        //提高变量fw的作用域，让finally中的代码可以使用fw变量
        //因为fw是局部变量，而变量在定义的时候，可以没有值，但是使用的时候必须有值
        //fw = new FileWriter("day17-IOAndProperties\\7.txt", true); 执行失败，因为fw没有初始值，fw.close会报错
        FileWriter fw;
        fw = null;
        try{
            //可能会产生异常的代码
            fw = new FileWriter("day17-IOAndProperties\\7.txt", true);
            for (int i = 0; i < 10; i++) {
                fw.write("HelloWorld" + i + "\r\n");
            }
        }catch (IOException e){
            //异常处理逻辑
            System.out.println(e);
        }finally {
            //一定会执行的代码
            //如果创建对象失败了，fw的默认值就是null，null是不能调用方法的，会抛出NullPointerException，需要增加一个判断，
            //不是null再把资源释放了
            if(fw != null){
                try {
                    //fw.close方法声明抛出了IOException异常对象，所以我们就要处理这个异常对象。
                    //要么throws，要么try...catch
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
