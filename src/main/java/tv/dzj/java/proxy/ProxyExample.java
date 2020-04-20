package tv.dzj.java.proxy;

import jdk.nashorn.internal.scripts.JD;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author dzj
 * @date 2020/4/20 3:51
 */
public class ProxyExample {
    static interface Car{
        void running();
    }

    static class Bus implements Car{
        public void running(){
            System.out.println("bus running");
        }
    }

    static class Taxi implements Car{
        public void running(){
            System.out.println("taxi running");
        }
    }

    static class JDKProxy implements InvocationHandler{

        //代理对象
        private Object target;

        //获取代理对象
        public Object getInstance(Object target){
             this.target = target;
             return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
        }

        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //执行调用方法
            Object result = method.invoke(target,args);
            return result;
        }

    }

    public static void main(String[] args) {
        JDKProxy jdkProxy = new JDKProxy();

        Car car = (Car)jdkProxy.getInstance(new Taxi());

        car.running();
    }
}
