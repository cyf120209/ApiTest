package com.spring.controller;

import com.spring.bean.Result;
import com.spring.bean.Shade;
import com.spring.bean.ShadesMove;
import com.spring.service.ShadesService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by lenovo on 2017/4/20.
 */
@Api(value = "shades",description = "", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping(value = "/shades")
public class ShadesApi {

    @Resource(name = "shadeService")
    private ShadesService shadesService;

    @ApiOperation(value = "Moves shades",notes = "Moves shades",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/move",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public Result<String> operator(@RequestBody ShadesMove shadesMove){
        Result<String> result = new Result<>();
        result.setCode(200);
        return result;
    }

    @ApiOperation(value = "get shades",notes = "get shades",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public Result<List<Integer>> getShades(){
        List<Integer> shades = shadesService.getShades();
        Result<List<Integer>> result = new Result<>();
        result.setCode(200);
        result.setData(shades);
        return result;
    }

    @ApiOperation(value = "get shadeInfo",notes = "get shadeInfo",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/info",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public Shade getShadeInfo(@RequestParam(value = "id",required = false) Integer[] id,
                              @RequestParam(value = "name",required = false) String name){
        Shade info = shadesService.getShadeInfo(id[0]);
        return info;
    }

}
