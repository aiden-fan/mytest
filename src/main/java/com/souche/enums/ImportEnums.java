package com.souche.enums;

import com.alibaba.excel.metadata.BaseRowModel;
import com.souche.pojo.OfflineTerminationEventLhqEO;

/***
 *@author fanmiao
 *@date 2020/5/17 2:50 下午 
 */
public enum  ImportEnums {

    OFFLINE("OFFLINE",OfflineTerminationEventLhqEO.class);

    private String type;
    private Class<? extends BaseRowModel> model;


    ImportEnums(String type, Class<? extends BaseRowModel> model) {
        this.type = type;
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public Class<? extends BaseRowModel> getModel() {
        return model;
    }
}
