package com.spring.controller;

import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;
import com.spring.service.IShadeService;
import entity.DraperInformation;
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

    @ApiOperation(value = "group",notes = "group",httpMethod = "GET",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/groups",method = RequestMethod.GET,produces ={"application/json;charset=UTF-8"})
    public List<ShadeGroup> getGroup(@ApiParam(value = "group ids to filter by",allowMultiple=true) @RequestParam(required = false, defaultValue = "0") Integer[] groupId,
                                     @ApiParam(value = "names to filter by",allowMultiple=true) @RequestParam(required = false,defaultValue = "") String[] groupName){
        List<ShadeGroup> shadeGroupList = iShadeService.getShadeGroupList(groupId, groupName);
        return shadeGroupList;
    }

    @ApiOperation(value = "identify", notes = "identify", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/identify/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public void identify(@PathVariable Integer id) {
        iShadeService.identify(id);
    }

    @ApiOperation(value = "move shade", notes = "move shade", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/move/{id}/{cmd}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public void move(@PathVariable Integer id,
                     @PathVariable Integer cmd,
                     @ApiParam(value = "cmdService") @RequestParam(required = false) Integer cmdService ){
        if(cmdService==null || cmdService.intValue()==0){
            iShadeService.move(id,cmd);
        }else {
            iShadeService.move(id,cmd,cmdService);
        }
    }

    @ApiOperation(value = "limitAndStopOperation", notes = "limitAndStopOperation", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/limitAndStopOperation/{id}/{cmd}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public DraperInformation limitAndStopOperation(@PathVariable Integer id,
                                                   @PathVariable Integer cmd,
                                                   @ApiParam(value = "cmdService") @RequestParam(required = false) Integer cmdService ) {
        DraperInformation draperInformation=null;
        if(cmdService==null || cmdService.intValue()==0){
            draperInformation = iShadeService.limitAndStopOperation(id, cmd);
        }else {
            draperInformation = iShadeService.limitAndStopOperation(id, cmd,cmdService);
        }
        return draperInformation;
    }

    @ApiOperation(value = "getDraperInformation", notes = "getDraperInformation", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/draperInformation/{id}", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public DraperInformation getDraperInformation(@PathVariable Integer id) {
        DraperInformation draperInformation = iShadeService.getDraperInformation(id);
        return draperInformation;
    }

}
