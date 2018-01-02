package com.winit.generator.task;

import com.winit.generator.framework.AbstractApplicationTask;
import com.winit.generator.framework.context.ApplicationContext;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.handler.impl.ServiceImpHandler;
import com.winit.generator.model.ServiceImpInfo;

import java.util.List;

/**
 * @version <pre>
 * Author    liusu
 * Version   1.0
 * Date      2017/11/27
 */
public class ServiceImplTask  extends AbstractApplicationTask {

    private static String SERVICEIMPL_FTL = "template/ServiceImp.ftl";

    private List<ServiceImpInfo> serviceInfo;

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成serviceImpl");

        serviceInfo = (List<ServiceImpInfo>) context.getAttribute("serviceImplInfos");

        BaseHandler<ServiceImpInfo> handler = null;
        for (ServiceImpInfo info : serviceInfo) {
            handler = new ServiceImpHandler(SERVICEIMPL_FTL, info);
            handler.execute();
        }

        logger.info("生成serviceImpl完成");
        return false;
    }
}
