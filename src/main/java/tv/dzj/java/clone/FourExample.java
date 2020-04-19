package tv.dzj.java.clone;

import org.apache.commons.lang3.SerializationUtils;

/**
 * @author dzj
 * @date 2020/4/17 17:26
 */
public class FourExample {
    public static void main(String[] args) {
        //创建对象
        Address address = new Address(110,"beijing");
        People p1 = new People(1,"Java",address);

        //调用apache.commons.lang克隆对象
        People p2 = SerializationUtils.clone(p1);

        //修改原型对象
        p1.getAddress().setCity("xian");
    }
}
