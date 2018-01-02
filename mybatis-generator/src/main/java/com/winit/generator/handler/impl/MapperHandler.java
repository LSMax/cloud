package com.winit.generator.handler.impl;

import java.io.File;
import java.util.Map;
import java.util.Map.Entry;

import com.winit.generator.config.Configuration;
import com.winit.generator.handler.BaseHandler;
import com.winit.generator.model.MapperInfo;

public class MapperHandler extends BaseHandler<MapperInfo> {
    public MapperHandler(String ftlName, MapperInfo info) {
        this.ftlName = ftlName;
        this.info = info;
        this.savePath = Configuration.getString("base.baseDir") 
                + File.separator + Configuration.getString("mapperXml.path")
                + File.separator + info.getFileName() + ".xml";
        
    }
    
    @Override
    public void combileParams(MapperInfo info) {
        this.param.put("namespace", info.getNamespace());
        this.param.put("entityType", info.getEntityInfo().getPackageClassName());
        this.param.put("tableName", info.getEntityInfo().getTableName());
        this.param.put("entityName", info.getEntityInfo().getEntityName());
        
        StringBuilder resultMap = new StringBuilder();
        //resultMap
        //<result column="SU_ROUTE_CODE" jdbcType="VARCHAR" property="suRouteCode" />
        Map<String, String> propJdbcTypes = info.getEntityInfo().getPropJdbcTypes();
        for (Entry<String, String> entry : info.getEntityInfo().getPropNameColumnNames().entrySet()) {
            String propName = entry.getKey();
            String columnName = entry.getValue();
            
            if (!("id".equals(propName))) {
                resultMap.append("    <result column=\"").append(columnName).append("\" jdbcType=\"")
                .append(propJdbcTypes.get(propName)).append("\" property=\"").append(propName)
                .append("\" />\r\n");
            }
        }
        this.param.put("resultMap", resultMap.toString());
    }

}
