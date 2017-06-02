package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * 客户端查找远程对象，并调用远程方法
 */
public class HelloClient {
    /**
     * 查找远程对象并调用远程方法
     * @param args
     */
    public static void main(String[] args) {
        try {
            /**
             * 如果要从另一台启动了RMI注册服务的机器上查找hello实例
             * HelloInterface hello=(HelloInterface)Naming.lookup("//192.168.1.105:1099/Hello");
             */
            IApi hello = (IApi) Naming.lookup("hello");
            System.out.println(hello.say());
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
