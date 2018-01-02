package com.winit.generator.task;

import com.winit.generator.Constants;
import com.winit.generator.config.Configuration;
import com.winit.generator.framework.AbstractApplicationTask;
import com.winit.generator.framework.context.ApplicationContext;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.handler.impl.ServiceHandler;
import com.winit.generator.model.ServiceImpInfo;
import com.winit.generator.model.ServiceInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @version <pre>
 * Author    liusu
 * Version   1.0
 * Date      2017/11/27
 */
public class ServiceTask extends AbstractApplicationTask {

    private static String SERVICE_FTL = "template/Service.ftl";

    private List<ServiceInfo> serviceInfos;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成service");

        serviceInfos = (List<ServiceInfo>) context.getAttribute("serviceList");

        BaseHandler<ServiceInfo> handler = null;
        for (ServiceInfo info : serviceInfos) {
            handler = new ServiceHandler(SERVICE_FTL, info);
            handler.execute();
        }

        logger.info("生成service完成");
        return false;
    }

    @Override
    protected void doAfter(ApplicationContext context) throws Exception {
        super.doAfter(context);

        List<ServiceImpInfo> infos = new ArrayList<ServiceImpInfo>();
        ServiceImpInfo info = null;
        for (ServiceInfo serviceInfo : serviceInfos) {
            info = new ServiceImpInfo();
            info.setServiceInfo(serviceInfo);
            info.setClassName(serviceInfo.getEntityInfo().getEntityName() + Constants.SERVICE_IMPL_SUFFIX);
            info.setEntityInfo(serviceInfo.getEntityInfo());
            info.setPackageStr(Configuration.getString("serviceImpl.package") + "."  + serviceInfo.getEntityInfo().getEntityName());
            infos.add(info);
        }
        context.setAttribute("serviceImplInfos", infos);

    }

}
