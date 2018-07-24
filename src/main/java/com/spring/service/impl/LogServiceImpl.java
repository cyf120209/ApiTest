package com.spring.service.impl;

import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;
import com.spring.dao.ILogDao;
import com.spring.dao.IShadeDao;
import com.spring.dao.impl.LogRmi;
import com.spring.dao.impl.ShadeRmi;
import com.spring.service.ILogService;
import com.spring.service.IShadeService;
import entity.Log;
import org.springframework.stereotype.Service;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/3/21.
 */
@Service
public class LogServiceImpl implements ILogService {


    private ILogDao logDao;

    public LogServiceImpl() {
        logDao = new LogRmi();
    }

    private Boolean getShadeById(Integer shadeId, Integer[] id) {
        for (Integer i : id) {
            if (i.intValue() == shadeId.intValue()) {
                return true;
            }
        }
        return false;
    }

    private Boolean getShadeByName(String shadeName, String[] name) {
        for (String i : name) {
            if (i.equals(shadeName)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Log> getLogList(Integer[] source,Integer[] frametype,Integer[] destination,Integer pageSize, Integer pageStartIndex) {
        List<Log> logList=new ArrayList<>();
        List<Log> list = logDao.queryAll();
//        List<Shade> list = iShadeDao.queryAll();
        if(pageSize!=null){
            list=list.subList((pageStartIndex-1) * pageSize,(list.size()<=(pageStartIndex * pageSize))?(list.size()-1):pageStartIndex * pageSize);
        }
        Observable.from(list)
                .filter(new Func1<Log, Boolean>() {
                    @Override
                    public Boolean call(Log log) {
                        if (source == null || source.length == 0) {
                            return true;
                        } else {
                            return getLogBySource(log.getSource(), source);
                        }
                    }
                })
                .filter(new Func1<Log, Boolean>() {
                    @Override
                    public Boolean call(Log log) {
                        if (frametype == null || frametype.length == 0) {
                            return true;
                        } else {
                            return getLogByFrametype(log.getFrametype(), frametype);
                        }
                    }
                })
                .filter(new Func1<Log, Boolean>() {
                    @Override
                    public Boolean call(Log log) {
                        if (destination == null || destination.length == 0) {
                            return true;
                        } else {
                            return getLogByDestination(log.getDestination(), destination);
                        }
                    }
                })
                .subscribe(new Action1<Log>() {
                    @Override
                    public void call(Log log) {
                        logList.add(log);
                    }
                });
        return logList;
    }

    private Boolean getLogByDestination(Integer destination, Integer[] destinationArr) {
        for (Integer d:destinationArr){
            if(d.intValue()==destination.intValue()){
                return true;
            }
        }
        return false;
    }

    private Boolean getLogByFrametype(Integer frametype, Integer[] frametypeArr) {
        for (Integer f:frametypeArr){
            if(f.intValue()==frametype.intValue()){
                return true;
            }
        }
        return false;
    }

    private Boolean getLogBySource(Integer source, Integer[] sourceArr) {
        for (Integer s:sourceArr){
            if(s.intValue()==source.intValue()){
                return true;
            }
        }
        return false;
    }
}
