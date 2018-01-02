package com.winit.generator.handler.impl;

import com.winit.generator.config.Configuration;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.ServiceImpInfo;

import java.io.File;

/**
 * @version <pre>
 * Author    liusu
 * Version   1.0
 * Date      2017/11/28
 */
public class ServiceImpHandler extends BaseHandler<ServiceImpInfo> {

    public ServiceImpHandler(String ftlName, ServiceImpInfo info) {
        //获取实体名称
        String name = info.getEntityInfo().getEntityName();
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir")
                + File.separator + Configuration.getString("serviceImpl.path")+"\\"+name + "\\impl"
                + File.separator + info.getClassName() + ".java";

    }

    @Override
    public void combileParams(ServiceImpInfo info) {
        this.param.put("packageStr",info.getPackageStr());
        this.param.put("importStr", info.getImportStr());
        this.param.put("className", info.getClassName());
        this.param.put("serviceName",info.getServiceInfo().getClassName());
    }
}
