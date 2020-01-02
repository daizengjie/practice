package tv.dzj.java.data_structure;

import java.util.Iterator;

/**
 * 数组实现栈
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class ArrayStack<Item> implements MyStack<Item> {

    /**
     * 栈元素数组
     * 只能通过转型来创建泛型数组
     */
    private Item[] a = (Item[]) new Object();

    /**
     * 元素数量
     */
    private int N = 0;

    public MyStack<Item> push(Item item) {

        return null;
    }

    public Item pop() throws Exception {
        return null;
    }

    public boolean isEmpty() {
        return false;
    }

    public int size() {
        return 0;
    }

    public Iterator<Item> iterator() {
        return null;
    }

    private void check(){
        if(N >= a.length){

        }
    }

    /**
     * 调整数组大小
     * @param size 大小
     */
    private void resize(int size){

    }
}
