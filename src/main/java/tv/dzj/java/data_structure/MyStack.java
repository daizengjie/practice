package tv.dzj.java.data_structure;

/**
 * 栈
 * @author dzj
 */
public interface MyStack<Item> extends Iterable<Item>{

    MyStack<Item> push (Item item);

    Item pop() throws Exception;

    boolean isEmpty();

    int size();
}
