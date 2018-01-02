package com.winit.generator.handler.impl;

import com.winit.generator.config.Configuration;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.ControllerInfo;
import com.winit.generator.model.DaoInfo;
import com.winit.generator.model.EntityInfo;

import java.io.File;

/**
 * @version <pre>
 * Author    liusu
 * Version   1.0
 * Date      2017/11/27
 */
public class ControllerHandler extends BaseHandler<ControllerInfo>{

    public ControllerHandler(String ftlName, ControllerInfo info) {
        //获取实体名称
        String name = info.getEntityInfo().getEntityName();
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir")
                + File.separator + Configuration.getString("controller.path")+"\\"+name
                + File.separator + info.getClassName() + ".java";

    }

    @Override
    public void combileParams(ControllerInfo info) {
        EntityInfo entityInfo = info.getEntityInfo();
        this.param.put("packageStr", info.getPackageStr());
        StringBuilder sb = new StringBuilder();
//        for (String str : entityInfo.getImports()) {
//            sb.append("import ").append(str).append(";\r\n");
//        }
        //导入包
        sb.append("import org.springframework.beans.factory.annotation.Autowired;\r\n" +
                "import io.swagger.annotations.Api;\r\n" +
                "import io.swagger.annotations.ApiOperation;\r\n" +
                "import io.swagger.annotations.ApiParam;\r\n");

        this.param.put("importStr", sb.toString());
//        类名
        this.param.put("className", info.getClassName());
//        依赖
        sb = new StringBuilder();
        sb.append("@Autowired\r\n");
        sb.append("private ");
//        方法

    }
}
