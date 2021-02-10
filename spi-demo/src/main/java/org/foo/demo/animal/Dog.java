package org.foo.demo.animal;

/**
 * @author : wangebie
 * @date : 2021/2/3 16:11
 */
public class Dog implements IShout{
    @Override
    public void shout() {
        System.out.println(System.getProperty("sun.boot.class.path"));
    }
}
