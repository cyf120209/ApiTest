package com.spring.controller;

import com.spring.service.InitService;
import com.spring.utils.ComPortutils;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2017/3/20.
 */
@Api(value = "init" ,description = "",produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping(value = "/init")
public class InitController {

//    @Resource(name = "initService")
    private InitService service;

    /**
     * 获取端口
     * @return
     */
    @ApiOperation(value = "ports",notes = "ports",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/ports",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public List<String> getPorts(){
        return ComPortutils.listPort();
    }

    /**
     * 初始化bacnet/ip
     * @param port 端口
     * @return
     */
    @ApiOperation(value = "init",notes = "init",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @RequestMapping(value = "/init",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public boolean init(@ApiParam(value = "端口号", required = true) @RequestParam String port){
        return service.init(port);
    }

}
