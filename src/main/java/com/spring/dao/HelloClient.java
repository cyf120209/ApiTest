package com.spring.dao;

import manager.rmi.IApi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by lenovo on 2017/4/17.
 */
public class HelloClient {

    public static void main(String[] args) {
        try {
            IApi hello = (IApi)Naming.lookup("hello");
            String say = hello.say();
            System.out.println(say);
        } catch (NotBoundException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
