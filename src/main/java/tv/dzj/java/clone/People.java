package tv.dzj.java.clone;

import java.io.Serializable;

/**
 * @author dzj
 * @date 2020/4/14 2:06
 */
public class People implements Cloneable, Serializable {
    private Integer id;
    private String name;
    private Address address;

    public static void main1(String[] args) throws Exception{
        Address address = new Address(110,"beijing");
        People people = new People(1,"Java",address);
        People p2 = (People)people.clone();
        people.getAddress().setCity("xian");
    }

    public static void main(String[] args) {
        //创建对象
        Address address = new Address(110,"beijing");
        People p1 = new People(1,"java",address);
        //调用构造函数克隆对象
        People p2 = new People(p1.getId(),p1.getName(),new Address(p1.getAddress().getId(),p1.getAddress().getCity()));
        //修改原型对象
        p1.getAddress().setCity("西安");
    }


    @Override
    protected Object clone() throws CloneNotSupportedException {
        People prople = (People)super.clone();
        prople.setAddress(address);
        return prople;
    }

    public People(Integer id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
