package com.spring.controller;

import com.spring.bean.Device;
import com.spring.bean.Shade;
import com.spring.bean.ShadeGroup;
import com.spring.service.IDeviceService;
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
@Api(tags = "device", description = "device controller", produces = MediaType.APPLICATION_JSON_VALUE)
@Controller
@RequestMapping(value = "/device")
public class DeviceApi {

    @Autowired
    private IDeviceService iDeviceService;

    @ApiOperation(value = "get deviceInfo", notes = "get deviceInfo", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "", method = RequestMethod.GET, produces = {"application/json;charset=UTF-8"})
    public List<Device> getDeviceList(@ApiParam(value = "deviceIds",allowMultiple=true) @RequestParam(required = false) Integer[] deviceId,
                                    @ApiParam(value = "deviceNames",allowMultiple=true) @RequestParam(required = false) String[] deviceName,
                                    @ApiParam(value = "mac") @RequestParam(required = false) String mac,
                                    @ApiParam(value = "modelName") @RequestParam(required = false) String modelName,
                                    @ApiParam(value = "version") @RequestParam(required = false) String version){
        List<Device> deviceList = iDeviceService.getDeviceList(deviceId,deviceName,mac,modelName,version);
        return deviceList;
    }

    @ApiOperation(value = "update",notes = "update",httpMethod = "POST",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @RequestMapping(value = "/update",method = RequestMethod.POST,produces ={"application/json;charset=UTF-8"})
    public Boolean updateDevice(@ApiParam(value = "update device") @RequestBody Device device){
        Boolean b = iDeviceService.updateDevice(device);
        return b;
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
