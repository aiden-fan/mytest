package com.souche.excel.Import;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/***
 *@author fanmiao
 *@date 2020/5/17 2:28 下午 
 */
public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("src/解约退款测试.xlsx");
        AnalysisEventListener listener = getListener();
        Sheet sheet = new Sheet(1, 0);
        EasyExcelFactory.readBySax(fileInputStream,sheet,listener);

    }


    public static AnalysisEventListener getListener() {
        AnalysisEventListener analysisEventListener = new AnalysisEventListener<List<String>>() {
            @Override
            public void invoke(List<String> list, AnalysisContext analysisContext) {
                System.out.println(list);
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext analysisContext) {
                System.out.println("结束");
            }
        };
        return analysisEventListener;
    }
}
