package tv.dzj.java.clone;
/**
 * @author dzj
 * @date 2020/4/14 2:07
 */
public class Address implements Cloneable{

    private Integer id;
    private String city;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Address(Integer id, String city){
        this.id = id;
        this.city = city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
