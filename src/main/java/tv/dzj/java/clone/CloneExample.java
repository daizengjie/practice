package tv.dzj.java.clone;

/**
 * @author dzj
 * @date 2020/4/14 1:39
 */
public class CloneExample {
    public static void main(String[] args) throws Exception{
        People p = new People();
        p.setId(1);
        p.setName("Java");
        People p2 = (People)p.clone();
        System.out.println(p2.getName());
    }

    static class People implements Cloneable{
        //属性
        private Integer id;
        private String name;

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
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
    }
}
