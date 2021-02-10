package org.foo.demo.animal;

/**
 * @author : wangebie
 * @date : 2021/2/3 16:12
 */
public class Cat implements IShout{
    @Override
    public void shout() {
        System.out.println("miao miao");
    }
}
