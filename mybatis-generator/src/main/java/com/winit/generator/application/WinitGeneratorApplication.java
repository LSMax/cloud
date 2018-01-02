package com.winit.generator.application;

import com.winit.generator.framework.Application;
import com.winit.generator.task.*;

public class WinitGeneratorApplication {
    public static void main(String[] args) {
        //程序入口
        Application application = new Application(WinitGeneratorApplication.class.getSimpleName());
        //多个表或实体之间用逗号隔开
        application.getContext().setAttribute("tableName","sys_city_info");
        application.getContext().setAttribute("entityNames","City");
        application.getContext().setAttribute("entityDescs","城市信息");

        application.parseArgs(args);
        application.setApplicationName(WinitGeneratorApplication.class.getName());

        application.addApplicationTask(InitTask.class)
        .addApplicationTask(CombineInfoTask.class)
        .addApplicationTask(EntityTask.class)
        .addApplicationTask(DaoTask.class)
        .addApplicationTask(MapperTask.class)
        .addApplicationTask(VoTask.class)
        .addApplicationTask(ControllerTask.class)
        .addApplicationTask(ServiceTask.class)
        .addApplicationTask(ServiceImplTask.class)
        .work();
    }
}
