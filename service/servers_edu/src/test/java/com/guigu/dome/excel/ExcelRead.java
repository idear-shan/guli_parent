package com.guigu.dome.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * 读取表格类
 */
public class ExcelRead extends AnalysisEventListener<Exceldome> {
   //一行一行读取表格内容
    @Override
    public void invoke(Exceldome exceldome, AnalysisContext analysisContext) {
        System.out.println("**"+exceldome);
    }
    //读取表头
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("**"+headMap);
    }
    //读取完之后做的事
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
