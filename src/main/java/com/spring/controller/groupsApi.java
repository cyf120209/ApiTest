package com.spring.controller;

import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;
import com.spring.service.GroupService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lenovo on 2017/4/20.
 */
@Api(value = "groups" ,description = "",produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping(value = "/groups")
public class groupsApi {

    @Resource(name = "groupService")
    private GroupService groupService;

    @ApiOperation(value = "move",notes = "move",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/move",method = RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
    public String operator(){
        return null;
    }

    @ApiOperation(value = "group",notes = "group",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "",method = RequestMethod.GET,produces ={"application/json;charset=UTF-8"})
    public List<ShadeGroup> getGroup(){
        return new ArrayList<>();
    }

    @ApiOperation(value = "group",notes = "group",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "group/{groupId}",method = RequestMethod.GET,produces ={"application/json;charset=UTF-8"})
    public List<Shade> getGroup(@PathVariable Integer groupId){
//        List<Shade> group = groupService.getGroup(groupId);
        return new ArrayList<>();
    }

    @ApiOperation(value = "group",notes = "group",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "groupShadeMap",method = RequestMethod.GET,produces ={"application/json;charset=UTF-8"})
    public Map<Integer,List<Shade>> getGroupShadeMap(){
//        return groupService.getGroupShadeMap();
        return new HashMap<>();
    }
}
