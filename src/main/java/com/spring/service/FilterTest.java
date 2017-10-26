package com.spring.service;

import com.spring.bean.Shade;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/5/4.
 */
public class FilterTest {

    public static void main(String[] args) {
        List<Shade> shadeList = new ArrayList<>();
        shadeList.add(new Shade(1,"1",1,1,"1"));
        shadeList.add(new Shade(2,"2",1,1,"1"));
        shadeList.add(new Shade(3,"3",1,1,"0"));
        shadeList.add(new Shade(4,"4",1,1,"0"));
        shadeList.add(new Shade(5,"5",2,1,"0"));
        shadeList.add(new Shade(6,"6",2,1,"0"));
        shadeList.add(new Shade(7,"7",2,1,"1"));
        shadeList.add(new Shade(8,"8",2,1,"1"));
        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(4);
        integerList.add(6);
        integerList.add(8);
        List<String> stringList = new ArrayList<>();
        stringList.add("2");
        stringList.add("3");
        stringList.add("4");

        rx.Observable.from(shadeList)
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        System.out.println("integerList"+shade.getShadeId());
                        return integerList.contains(shade.getShadeId());
                    }
                })
                .filter(new Func1<Shade, Boolean>() {
                    @Override
                    public Boolean call(Shade shade) {
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("stringList"+shade.getShadeId());
                        return stringList.contains(shade.getShadeName());
                    }
                })
                .subscribe(new Action1<Shade>() {
                    @Override
                    public void call(Shade shade) {
                        System.out.println(shade.getShadeId());
                    }
                });
//        System.out.println(shadeList.size());
    }
}
