package com.spring.controller;

import com.spring.bean.Shade;
import com.spring.bean.ShadesMove;
import com.spring.dao.IShadeDao;
import com.spring.service.IShadeService;
import com.spring.service.ShadeServiceImpl;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/4/20.
 */
@Api(value = "shades",description = "", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping(value = "/shades")
public class ShadesApi {

    @Autowired
    private IShadeService iShadeService;

    @ApiOperation(value = "Moves shades",notes = "Moves shades",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/move",method = RequestMethod.POST,produces = {"application/json;charset=UTF-8"})
    public Boolean move(@RequestBody ShadesMove shadesMove){
        return true;
    }

    @ApiOperation(value = "get shadeInfo",notes = "get shadeInfo",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public List<Shade> getShadeInfo() {
//        shadesService.setIShadeDao(new ShadeReal());
//        List<Shade> shadeList = shadesService.getShadeList();
        List<Shade> shadeList = iShadeService.getAll();
        return shadeList;
    }

    @ApiOperation(value = "get shadeInfo",notes = "get shadeInfo",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/{shadeId}",method = RequestMethod.GET,produces = {"application/json;charset=UTF-8"})
    public Shade getShadeInfo(@PathVariable Integer shadeId) {
//        shadesService.setIShadeDao(new ShadeReal());id
//        List<Shade> shadeList = shadesService.getShadeList();
        Shade shade = iShadeService.getById(shadeId);
        return shade;
    }

}
