package com.winit.generator.task;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.winit.generator.Constants;
import com.winit.generator.config.Configuration;
import com.winit.generator.framework.AbstractApplicationTask;
import com.winit.generator.framework.context.ApplicationContext;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.handler.impl.EntityHandler;
import com.winit.generator.model.*;
import com.winit.generator.util.PropertyUtil;

public class EntityTask extends AbstractApplicationTask {
    private static String ENTITY_FTL = "template/Entity.ftl";
    
    private List<EntityInfo> entityInfos;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成实体");
        
        //获取实体信息
        entityInfos = (List<EntityInfo>) context.getAttribute("entityInfos");
        
        BaseHandler<EntityInfo> handler = null;
        for (EntityInfo entityInfo : entityInfos) {
            handler = new EntityHandler(ENTITY_FTL, entityInfo);
            handler.execute();
        }
        logger.info("生成实体类完成");
        return false;
    }
    
    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);
        
        List<DaoInfo> daoList = new ArrayList<DaoInfo>();
        List<VoInfo> voList = new ArrayList<VoInfo>();
        List<ControllerInfo> controllerList = new ArrayList<ControllerInfo>();
        List<ServiceInfo> serviceInfos = new ArrayList<ServiceInfo>();

        //组装Dao信息、组装Vo信息、controller、service
        DaoInfo daoInfo = null;
        VoInfo voInfo = null;
        ControllerInfo cinfo = null;
        ServiceInfo serviceInfo = null;
        for (EntityInfo entityInfo : entityInfos) {
            daoInfo = new DaoInfo();
            daoInfo.setClassName(entityInfo.getEntityName() + Constants.DAO_SUFFIX);
            daoInfo.setEntityInfo(entityInfo);
            daoInfo.setImportStr("import " + entityInfo.getEntityPackage() + "." + entityInfo.getClassName() + ";");
            daoInfo.setPackageStr(Configuration.getString("dao.package") + "."  + entityInfo.getEntityName());
            daoList.add(daoInfo);
            
            
            voInfo = new VoInfo();
            voInfo.setPackageStr(Configuration.getString("vo.package") + "." +entityInfo.getEntityName());
            voInfo.setClassName(entityInfo.getEntityName() + Constants.VO_SUFFIX);
            voInfo.setEntityInfo(entityInfo);
            voList.add(voInfo);

            cinfo = new ControllerInfo();
            cinfo.setPackageStr(Configuration.getString("controller.package") + "."  + entityInfo.getEntityName());
            cinfo.setClassName(entityInfo.getEntityName() + Constants.CONTROLLER_SUFFIX);
            cinfo.setEntityInfo(entityInfo);
            controllerList.add(cinfo);

            serviceInfo = new ServiceInfo();
            serviceInfo.setPackageStr(Configuration.getString("service.package") + "."  + entityInfo.getEntityName());
            serviceInfo.setClassName(entityInfo.getEntityName() + Constants.SERVICE_SUFFIX);
            serviceInfo.setEntityInfo(entityInfo);
            serviceInfos.add(serviceInfo);

        }
        
        context.setAttribute("daoList", daoList);
        context.setAttribute("voList", voList);
        context.setAttribute("serviceList",serviceInfos);
        context.setAttribute("cList",controllerList);
    }
    
    public static void main(String[] args) {
        File file = new File("/D:\\devsoftware\\workspace\\winit-java-generator\\target\\classes\\template\\Entity.ftl");
        System.out.println(EntityTask.class.getClassLoader().getResource("").getPath());
        System.out.println(file.exists());
        
        PropertyUtil.setProperty("name", "qyk1");
        PropertyUtil.setProperty("NAME", "qyk22");
    }

}
