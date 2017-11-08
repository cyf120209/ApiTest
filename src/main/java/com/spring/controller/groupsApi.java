package com.spring.controller;

import com.spring.bean.ShadeGroup;
import com.spring.service.IGroupService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lenovo on 2017/4/20.
 */
@Api(value = "groups" ,description = "",produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping(value = "/groups")
public class groupsApi {

    @Autowired
    private IGroupService groupService;

    @ApiOperation(value = "move",notes = "move",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/move",method = RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
    public String operator(@ApiParam(value = "端口号", required = true) @RequestParam String operator){
        return null;
    }

    @ApiOperation(value = "group",notes = "group",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET,produces ={"application/json;charset=UTF-8"})
    public List<ShadeGroup> getGroup(){
        return groupService.getAll();
    }

    @ApiOperation(value = "group",notes = "group",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/{id}",method = RequestMethod.GET,produces ={"application/json;charset=UTF-8"})
    public ShadeGroup getGroup(@PathVariable Integer id){
        return groupService.getById(id);
    }

//    @ApiOperation(value = "group",notes = "group",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    @RequestMapping(value = "groupShadeMap",method = RequestMethod.GET,produces ={"application/json;charset=UTF-8"})
//    public Map<Integer,List<Shade>> getGroupShadeMap(){
////        return groupService.getGroupShadeMap();
//        return new HashMap<>();
//    }
}
