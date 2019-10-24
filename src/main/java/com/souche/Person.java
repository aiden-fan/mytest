package com.souche;

import com.alibaba.excel.annotation.ExcelColumnNum;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;




@Data
public class Person extends BaseRowModel {
    @ExcelProperty(value = "id",index = 0)
    //@ExcelColumnNum(0)
    private Integer id;

    @ExcelProperty(value = "姓名",index = 1)
   // @ExcelColumnNum(1)
    private String name;

    @ExcelProperty(value = "地址",index = 2)
   // @ExcelColumnNum(2)
    private String addr;


    public Person() {
    }

    public Person(Integer id, String name, String addr) {
        this.id = id ;
        this.name = name;
        this.addr = addr;
    }
}
