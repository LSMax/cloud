package com.winit.generator.handler.impl;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import com.winit.generator.config.Configuration;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.EntityInfo;

public class EntityHandler extends BaseHandler<EntityInfo> {
    
    public EntityHandler(String ftlName, EntityInfo info) {
        //获取实体名称
        String name = info.getEntityName();
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir") 
                + File.separator + Configuration.getString("entity.path")+"\\"+name
                + File.separator + info.getClassName() + ".java";
        
    }
    
    @Override
    public void combileParams(EntityInfo entityInfo) {
        this.param.put("packageStr", entityInfo.getEntityPackage());
        StringBuilder sb = new StringBuilder();
        for (String str : entityInfo.getImports()) {
            sb.append("import ").append(str).append(";\r\n");
        }
        StringBuilder tableMessage = new StringBuilder();
        tableMessage.append("@Entity\r\n")
        .append("@Table(name=\""+entityInfo.getTableName()+"\")");

        this.param.put("importStr", sb.toString());
        this.param.put("entityDesc", entityInfo.getEntityDesc());
        this.param.put("className", entityInfo.getClassName());
        this.param.put("tableMessage",tableMessage.toString());
        //生成属性，getter,setter方法
        sb = new StringBuilder();
        StringBuilder sbMethods = new StringBuilder();
        Map<String, String> propRemarks = entityInfo.getPropRemarks();
        for (Entry<String, String> entry : entityInfo.getPropTypes().entrySet()) {
            String propName = entry.getKey();
            String propType = entry.getValue();

            if(propName.equals("id") || propName.equals("isDeleted") || propName.equals("creatorId") || propName.equals("createTime") || propName.equals("updaterId") || propName.equals("updateTime")){

            }else {
                //注释、类型、名称
                if(propName.equals("userPassword")){
                    sb.append("    /*").append(propRemarks.get(propName)).append("*/\r\n")
                            .append("    @Column \r\n")
                            .append("    @JsonIgnore \r\n")
                            .append("    private ").append(propType).append(" ").append(propName)
                            .append(";\r\n");
                }else{
                    sb.append("    /*").append(propRemarks.get(propName)).append("*/\r\n")
                            .append("    @Column \r\n")
                            .append("    private ").append(propType).append(" ").append(propName)
                            .append(";\r\n");
                }

                sbMethods.append("    public ").append(propType).append(" get")
                        .append(propName.substring(0, 1).toUpperCase())
                        .append(propName.substring(1)).append("() {\r\n")
                        .append("        return ").append(propName).append(";\r\n")
                        .append("    }\r\n")
                        .append("    public void set").append(propName.substring(0, 1).toUpperCase())
                        .append(propName.substring(1)).append("(").append(propType).append(" ")
                        .append(propName).append(") {\r\n")
                        .append("        this.").append(propName).append(" = ").append(propName)
                        .append(";\r\n    }\r\n").append("\r\n");
            }
        }
        
        this.param.put("propertiesStr", sb.toString());
        this.param.put("methodStr", sbMethods.toString());
        
        
    }
}
