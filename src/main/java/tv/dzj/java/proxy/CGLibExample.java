package tv.dzj.java.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author dzj
 * @date 2020/4/20 10:26
 */
public class CGLibExample {
    static class Car{
        public void running(){
            System.out.println("car running");
        }
    }

    static class CGLibProxy implements MethodInterceptor{
        //代理对象
        private Object target;

        public Object getInstance(Object target){
            this.target = target;
            Enhancer enhancer = new Enhancer();
            //设置父类为实现类
            enhancer.setSuperclass(this.target.getClass());
            //设置回调方法
            enhancer.setCallback(this);
            return enhancer.create();
        }

        public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
            Object result = methodProxy.invokeSuper(o, objects);
            return result;
        }
    }

    public static void main(String[] args) {
        CGLibProxy proxy = new CGLibProxy();
        Car car = (Car)proxy.getInstance(new Car());
        car.running();
    }
}
