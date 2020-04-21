package tv.dzj.java.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dzj
 * @date 2020/4/21 21:37
 */
public class CustomQueue {
    /**
     * 定义消息队列
     */
    private static Queue<String> queue = new LinkedList<String>();

    public static void main(String[] args) {
        producer();
        consumer();
    }

    private static void producer() {
        queue.add("first");
        queue.add("second");
    }

    private static void consumer() {
        while(!queue.isEmpty()){
            queue.poll();
        }
    }
}
