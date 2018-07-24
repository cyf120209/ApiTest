package com.spring.controller;

import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;
import com.spring.service.ILogService;
import com.spring.service.IShadeService;
import entity.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by lenovo on 2017/4/20.
 */
@Api(tags = "log", description = "log", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping(value = "/log")
public class LogApi {

    @Autowired
    private ILogService iLogService;

    @ApiOperation(value = "get log", notes = "get log", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public List<Log> getLogList(@ApiParam(value = "source to filter by",allowMultiple=true) @RequestParam(required = false) Integer[] source,
                                    @ApiParam(value = "frametype to filter by",allowMultiple=true) @RequestParam(required = false) Integer[] frametype,
                                    @ApiParam(value = "destination to filter by",allowMultiple=true) @RequestParam(required = false) Integer[] destination,
                                    @ApiParam(value = "number of records to return") @RequestParam(required = false) Integer pageSize,
                                    @ApiParam(value = "record number to start at") @RequestParam(required = false,defaultValue = "1") Integer pageStartIndex) {
        List<Log> logList = iLogService.getLogList(source,frametype,destination,pageSize,pageStartIndex);
        return logList;
    }


}
