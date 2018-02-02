package com.spring.controller;

import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;
import com.spring.service.IShadeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by lenovo on 2017/4/20.
 */
@Api(tags = "shades", description = "shades controller", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping(value = "/shades")
public class ShadesApi {

    @Autowired
    private IShadeService iShadeService;

    @ApiOperation(value = "get shadeInfo", notes = "get shadeInfo", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public List<Shade> getShadeInfo(@ApiParam(value = "ids to filter by",allowMultiple=true) @RequestParam(required = false) Integer[] id,
                                    @ApiParam(value = "names to filter by",allowMultiple=true) @RequestParam(required = false) String[] name,
                                    @ApiParam(value = "priority that the shade is currently operating at to filter by") @RequestParam(required = false) Integer priority,
                                    @ApiParam(value = "status of shades to filter by") @RequestParam(required = false) String status,
                                    @ApiParam(value = "number of records to return") @RequestParam(required = false) Integer pageSize,
                                    @ApiParam(value = "record number to start at") @RequestParam(required = false,defaultValue = "1") Integer pageStartIndex) {
        List<Shade> shadeList = iShadeService.getShadeList(id,name,priority,status,pageSize,pageStartIndex);
        return shadeList;
    }

    @ApiOperation(value = "Moves shades", notes = "Moves shades", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/move", method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    public List<Shade> move(@ApiParam(value = "ids to filter by",allowMultiple=true) @RequestParam(required = false) Integer[] id,
                        @ApiParam(value = "names to filter by",allowMultiple=true) @RequestParam(required = false) String[] name,
                        @ApiParam(value = "group id to filter by",allowMultiple=true) @RequestParam(required = false) Integer[] groupId,
                        @ApiParam(value = "group name to filter by",allowMultiple=true) @RequestParam(required = false) String[] groupName,
                        @ApiParam(value = "position to move the shades to in meters") @RequestParam(required = false) Integer position,
                        @ApiParam(value = "position to move the shades to as a percentage") @RequestParam(required = false) Integer percentage,
                        @ApiParam(value = "command to send to the shade. Commands include move full open, closed and stop.") @RequestParam(required = false) Integer command,
                        @ApiParam(value = "priority that the shade will be moved at") @RequestParam(required = true) Integer priority) {
        List<Shade> shadeList = iShadeService.getMoveList(id,name,groupId,groupName,position,percentage,command,priority);
        return shadeList;
    }

    @ApiOperation(value = "group",notes = "group",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/groups",method = RequestMethod.GET,produces ={"application/json;charset=UTF-8"})
    public List<ShadeGroup> getGroup(@ApiParam(value = "group ids to filter by",allowMultiple=true) @RequestParam(required = false, defaultValue = "0") Integer[] groupId,
                                     @ApiParam(value = "names to filter by",allowMultiple=true) @RequestParam(required = false,defaultValue = "") String[] groupName){
        List<ShadeGroup> shadeGroupList = iShadeService.getShadeGroupList(groupId, groupName);
        return shadeGroupList;
    }

//    @ApiOperation(value = "get shadeInfo", notes = "get shadeInfo", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    @RequestMapping(value = "/{shadeId}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
//    public Shade getShadeInfo(@PathVariable Integer shadeId) {
////        shadesService.setIShadeDao(new ShadeReal());id
////        List<Shade> shadeList = shadesService.getShadeList();
//        Shade shade = iShadeService.getById(shadeId);
//        return shade;
//    }

}
