package cn.itcast.day17.demo07;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
* java.util.Properties集合 extends Hashtable<key, value> implements Map<key, value>
* Properties类表示了一个持久的属性集。Properties可以保存在流中或从流中加载
* Properties集合是一个唯一和IO流相结合的集合
*       可以使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
*       可以使用Properties集合中的方法load，把硬盘中保存的文件(键值对)，读取到集合中使用
*
* 属性列表中每个键及对应的值都是一个字符串
*       Properties集合是一个双列集合，key和value默认都是字符串
* */
public class Demo01Properties {
    public static void main(String[] args) throws IOException {
        //show01();
        //show02();
        show03();
    }

    /*
    * 使用Properties集合存储数据，遍历读取Properties集合中的数据
    * Properties集合是一个双列集合，key和value默认都是字符串
    * Properties集合有一些操作字符串的特有方法：
    *       Object setProperty(String key, String value)：调用Hashtable的方法put
    *       String getProperty(String key)：通过key找到value值，此方法相当于Map集合中的get(key)方法
    *       Set<String> stringPropertyNames()：返回属性列表中的键集，其中该键及其对应的值是字符串，此方法相当于Map集合中的keySet方法
    * */
    private static void show01(){
        //创建一个Properties集合对象。他的泛型就不用写了，默认就是字符串
        Properties prop = new Properties();

        //使用setProperty方法，往集合中添加数据
        prop.setProperty("源氏", "161");
        prop.setProperty("半藏", "163");
        prop.setProperty("安娜", "159");

        //使用stringPropertyNames方法，把集合中的键取出，存储到一个Set集合中
        Set<String> set = prop.stringPropertyNames();

        //遍历Set集合，取出Properties集合的每一个键
        for (String key : set) {
            //使用getProperty方法，通过key来获取value
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }

    /*
    * 可以使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
    *   void store(OutputStream out, String comments)
    *   void store(Writer writer, String comments)
    *   参数：
    *       OutputStream out：字节输出流，不能写中入文
    *       Writer writer：字符输出流，可以写中文
    *       String comments：注释，用来解释说明保存的文件是做什么用的
    *                       不能使用中文，会产生乱码，因为默认是Unicode编码
    *                       一般使用""空字符串
    * 使用步骤：
    *       1、创建Properties集合对象，添加数据
    *       2、创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
    *       3、使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
    *       4、释放资源
    * */
    private static void show02() throws IOException {
        //1、创建Properties集合对象，添加数据
        Properties prop = new Properties();
        prop.setProperty("路霸", "168");
        prop.setProperty("麦克雷", "156");
        prop.setProperty("狂鼠", "170");

        //2、创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地
        FileWriter fw = new FileWriter("day17-IOAndProperties\\prop.txt");

        //3、使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
        prop.store(fw, "save data");

/*
        //用字节输出流时：
        //prop.store(new FileOutputStream("day17-IOAndProperties\\prop2.txt"), "save date");
        //用字节输出流写入中文时，会出现乱码。 传入的匿名对象new FileOutputStream不用关闭，这个流使用完自己就会关闭
        //所以字节输出流不能写中文
*/

        //4、释放资源
        fw.close();
    }

    /*
    * 可以使用Properties集合中的方法load，把硬盘中保存的文件(键值对)，读取到集合中使用
    *   void load(InputStream inStream)
    *   void load(Reader reader)
    *       参数：
    *           InputStream inStream：字节输入流，不能读取含有中文的键值对
    *           Reader reader：字符输入流，可以读取含有中文的键值对
    * 使用步骤：
    *       1、创建Properties集合对象
    *       2、使用Properties集合对象中的方法load读取保存键值对的文件
    *       3、遍历Properties集合
    * 注意：
    *       1、存储键值对的文件中，键与值默认的连接符可以使用：=、空格、或其他符号
    *       2、存储键值对的文件中，可以使用#进行注释，被注释的键值对不会再被读取
    *       3、存储键值对的文件中，键与值默认都是字符串，不用再加引号
    * */
    private static void show03() throws IOException {
        //1、创建Properties集合对象
        Properties prop = new Properties();

        //2、使用Properties集合对象中的方法load读取保存键值对的文件
        prop.load(new FileReader("day17-IOAndProperties\\prop.txt"));
        //如果使用 prop.load(new FileInputStream("day17-IOAndProperties\\prop.txt"));   输出会乱码
        //所以load方法一般使用字节书输入流

        //3、遍历Properties集合
        Set<String> set = prop.stringPropertyNames();
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }
}
