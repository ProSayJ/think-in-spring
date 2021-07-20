package prosayj.transfer.tx;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import prosayj.handwritingspring.spring.Autowired;
import prosayj.handwritingspring.spring.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 代理对象工厂：生成代理对象的
 *
 * @author yangjian
 * @date 2021-05-13
 */
@Component("proxyFactory")
public class ProxyFactory {
    @Autowired
    private TransactionManager transactionManager;


    /**
     * Jdk动态代理
     *
     * @param obj 委托对象
     * @return 代理对象
     */
    public Object getJdkProxy(Object obj) {
        // 获取代理对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result;
                        try {
                            transactionManager.beginTransaction();
                            result = method.invoke(obj, args);
                            transactionManager.commit();
                        } catch (Exception e) {
                            transactionManager.rollback();
                            throw e;
                        }
                        return result;
                    }
                });
    }


    /**
     * 使用cglib动态代理生成代理对象
     *
     * @param obj 委托对象
     * @return Object
     */
    public Object getCglibProxy(Object obj) {
        return Enhancer.create(obj.getClass(), new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result;
                try {
                    // 开启事务(关闭事务的自动提交)
                    transactionManager.beginTransaction();
                    result = method.invoke(obj, objects);
                    // 提交事务
                    transactionManager.commit();
                } catch (Exception e) {
                    e.printStackTrace();
                    // 回滚事务
                    transactionManager.rollback();

                    // 抛出异常便于上层servlet捕获
                    throw e;
                }
                return result;
            }
        });
    }
}