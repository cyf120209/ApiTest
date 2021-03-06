package com.spring.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value = "device" ,description = "device")
public class Device implements Serializable{

    @ApiModelProperty(value = "id",required = true)
    private Integer id;

    @ApiModelProperty(value = "deviceId")
    private Integer deviceId;

    @ApiModelProperty(value = "deviceName")
    private String deviceName;

    @ApiModelProperty(value = "mac")
    private String mac;

    @ApiModelProperty(value = "modelName")
    private String modelName;

    @ApiModelProperty(value = "version")
    private String version;

    @ApiModelProperty(value = "remarks")
    private String remarks;


    public Device() {
        super();
    }

    public Device(Integer id, Integer deviceId, String deviceName, String mac, String modelName, String version, String remarks) {
        this.id = id;
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.mac = mac;
        this.modelName = modelName;
        this.version = version;
        this.remarks = remarks;
    }

    public Device(Integer deviceId, String deviceName, String mac, String modelName, String version) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.mac = mac;
        this.modelName = modelName;
        this.version=version;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
