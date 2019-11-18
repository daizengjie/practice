package tv.dzj.java.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Author: <a href="daizengjie@gmail.com">dzj</a>
 */
public class NIOServer {
    public static void main(String[] args) throws IOException{
        //创建选择器
        Selector selector = Selector.open();

        //设置通道为非阻塞
        //将通道注册到选择器上
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        ssChannel.configureBlocking(false);
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);

        //监听TCP连接
        ServerSocket serverSocket = ssChannel.socket();
        InetSocketAddress address = new InetSocketAddress("127.0.0.1",8888);
        serverSocket.bind(address);

        while(true){
            //监听到达的事件
            selector.select();
            //获取到达的事件
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> keyIterator = keys.iterator();

            while(keyIterator.hasNext()){
                SelectionKey key = keyIterator.next();
                if(key.isAcceptable()){
                    ServerSocketChannel ssChannel1 = (ServerSocketChannel)key.channel();

                    //服务器会为每一个新连接创建一个SocketChannel
                    SocketChannel sChannel = ssChannel1.accept();
                    sChannel.configureBlocking(false);

                    //这个新连接主要用于从客户都读取数据
                    sChannel.register(selector,SelectionKey.OP_READ);
                }else if(key.isReadable()){
                    SocketChannel sChannel = (SocketChannel)key.channel();
                    System.out.println(readDataFromSocketChannel(sChannel));
                    sChannel.close();
                }
                keyIterator.remove();
            }
        }

    }

    private static String readDataFromSocketChannel(SocketChannel sChannel) throws IOException{
        //缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder data = new StringBuilder();

        while(true){
            buffer.clear();
            //从通道读取数据到缓冲区
            int n = sChannel.read(buffer);
            //read返回-1 表示EOF
            if(n == -1){
                break;
            }
            //切换读写
            buffer.flip();
            //三要素：limit，capacity,position
            int limit = buffer.limit();
            char[] dst = new char[limit];
            for(int i = 0; i < limit;i++){
                dst[i] = (char)buffer.get(i);
            }
            data.append(dst);
            buffer.clear();
        }
        return data.toString();
    }
}
