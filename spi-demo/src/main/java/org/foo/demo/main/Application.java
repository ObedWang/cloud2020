package org.foo.demo.main;

import org.foo.demo.animal.Dog;
import org.foo.demo.animal.IShout;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * @author : wangebie
 * @date : 2021/2/3 16:14
 */
public class Application {
    public static void main(String[] args) {
//        ServiceLoader<IShout> shouts = ServiceLoader.load(IShout.class);
//        for (IShout s : shouts) {
//            s.shout();
//        }

//        System.out.println(System.getProperty("sun.boot.class.path"));
//        System.out.println(System.getProperty("java.ext.dirs"));
//        System.out.println(System.getProperty("java.class.path"));
//        ClassLoader cl = Dog.class.getClassLoader();
//        System.out.println("----------");
//        System.out.println(cl.toString());
//        cl = List.class.getClassLoader();
//        System.out.println(cl.toString());
        DiskClassLoader diskClassLoader = new DiskClassLoader("F:\\project\\cloud2020\\ddd-test\\target\\classes\\com\\atguigu\\springcloud\\repository");
        try {
            Class c = diskClassLoader.loadClass("com.atguigu.springcloud.repository.Test");
            if(c != null){
                try {
                    Object obj = c.newInstance();
                    Method method = c.getDeclaredMethod("say",null);
                    //通过反射调用Test类的say方法
                    method.invoke(obj, null);
                } catch (InstantiationException | IllegalAccessException
                        | NoSuchMethodException
                        | SecurityException |
                        IllegalArgumentException |
                        InvocationTargetException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
