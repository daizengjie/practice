package tv.dzj.java.clone;

import java.io.*;

/**
 * @author dzj
 * @date 2020/4/14 16:21
 */
public class ThirdExample {
    public static void main(String[] args) {
        //创建对象
        Address address = new Address(110,"beijing");
        People p1 = new People(1,"Java",address);

        //通过字节流实现深克隆
        People p2 = StreamClone.clone(p1);

        //修改原型对象
        p1.getAddress().setCity("xian");
    }

    static class StreamClone {
        public static <T extends Serializable> T clone(People obj) {
            T cloneObj = null;
            try {
                //写入字节流
                ByteArrayOutputStream bo = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(bo);
                oos.writeObject(obj);
                oos.close();
                //获取上面的输出字节流
                ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
                ObjectInputStream oi = new ObjectInputStream(bi);
                //返回生成的新对象
                cloneObj = (T)oi.readObject();
                oi.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return cloneObj;
        }
    }

}
