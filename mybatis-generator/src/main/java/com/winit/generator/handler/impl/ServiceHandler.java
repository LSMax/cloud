package com.winit.generator.handler.impl;

import com.winit.generator.config.Configuration;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.DaoInfo;
import com.winit.generator.model.ServiceInfo;

import java.io.File;

/**
 * @version <pre>
 * Author    liusu
 * Version   1.0
 * Date      2017/11/27
 */
public class ServiceHandler extends BaseHandler<ServiceInfo> {

    public ServiceHandler(String ftlName, ServiceInfo info) {
        //获取实体名称
        String name = info.getEntityInfo().getEntityName();
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir")
                + File.separator + Configuration.getString("service.path")+"\\"+name
                + File.separator + info.getClassName() + ".java";

    }

    @Override
    public void combileParams(ServiceInfo info) {
        this.param.put("packageStr", info.getPackageStr());
        this.param.put("className", info.getClassName());
    }
}
