package com.winit.generator.handler.impl;

import java.io.File;

import com.winit.generator.config.Configuration;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.DaoInfo;


public class DaoHandler extends BaseHandler<DaoInfo> {
    public DaoHandler(String ftlName, DaoInfo info) {
        //获取实体名称
//        String name = Configuration.getString("base.entityNames");
        String name = info.getEntityInfo().getEntityName();
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir") 
                + File.separator + Configuration.getString("dao.path")+"\\"+name
                + File.separator + info.getClassName() + ".java";
        
    }
    
    @Override
    public void combileParams(DaoInfo info) {
        this.param.put("packageStr", info.getPackageStr());
        this.param.put("importStr", info.getImportStr());
        this.param.put("entityDesc", info.getEntityInfo().getEntityDesc());
        this.param.put("className", info.getClassName());
        this.param.put("entityClassName", info.getEntityInfo().getClassName());
        this.param.put("entityName", info.getEntityInfo().getEntityName());
    }

}
