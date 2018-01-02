package com.winit.generator.task;

import com.winit.generator.framework.AbstractApplicationTask;
import com.winit.generator.framework.context.ApplicationContext;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.handler.impl.ControllerHandler;
import com.winit.generator.handler.impl.VoHandler;
import com.winit.generator.model.ControllerInfo;
import com.winit.generator.model.VoInfo;

import java.util.List;

/**
 * @version <pre>
 * Author    liusu
 * Version   1.0
 * Date      2017/11/27
 */
public class ControllerTask extends AbstractApplicationTask {
    private static String CONTROLLER_FTL = "template/controller.ftl";

    @SuppressWarnings("unchecked")
    @Override
    protected boolean doInternal(ApplicationContext context) throws Exception {
        logger.info("开始生成controller");
        List<ControllerInfo> voList = (List<ControllerInfo>) context.getAttribute("cList");

        BaseHandler<ControllerInfo> handler = null;
        for (ControllerInfo info : voList) {
            handler = new ControllerHandler(CONTROLLER_FTL,info);
            handler.execute();
        }
        logger.info("结束生成controller");
        return false;
    }
}
