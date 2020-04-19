package tv.dzj.java.clone;

import com.google.gson.Gson;

/**
 * @author dzj
 * @date 2020/4/17 17:35
 */
public class Five {
    public static void main(String[] args) {
        //创建对象
        Address address = new Address(110,"beijing");
        People p1 = new People(1,"Java",address);

        //调用Gson克隆对象
        Gson gson = new Gson();
        People p2 = gson.fromJson(gson.toJson(p1),People.class);

        //修改原版对象
        p1.getAddress().setCity("xian");
    }
}
