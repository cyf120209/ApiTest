package com.spring.upgrade;

import com.spring.utils.FileUtils;
import model.FirmWareInformation;
import model.FirmWareResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping(value = "/upgrade")
public class UpgradeApi {

    @Resource(name = "upgradeService")
    UpgradeService upgradeService;

    @RequestMapping(value = "/chooseFirmware",produces = {"application/json;charset=UTF-8"})
    public FirmWareResult chooseFirmware(HttpServletRequest request){
        FileUtils fileUtils = new FileUtils();
        try {
            fileUtils.uploadFile(request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FirmWareResult firmWareResult = upgradeService.chooseFirmware(fileUtils.getPath());
        return firmWareResult;
    }

    @RequestMapping(value = "/upgrade",produces = {"application/json;charset=UTF-8"})
    public void startUpdate() {
        upgradeService.startUpdate();
    }
}
