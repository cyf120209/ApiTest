package manager.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by lenovo on 2017/4/17.
 */

/**
 *  创建远程接口及声明远程方法
 *  远程接口必须扩展java.manager.rmi.remote
 */
public interface IApi extends Remote {

    /**
     * 远程接口方法必须抛出* java.manager.rmi.RemoteException
     * @return
     * @throws RemoteException
     */
    public String say() throws RemoteException;

}
