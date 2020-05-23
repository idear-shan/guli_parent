package com.guigu.dome.excel;
import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.RandomUtil;
import com.alibaba.excel.EasyExcel;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;


public class Texcel {
    @Test
    public void writes() {
        //设置文件路径
        String filename ="D:\\write.xlsx";
        //调用阿里的表格操作 第一个参数时路径名称，第二个是实体类
        EasyExcel.write(filename,Exceldome.class)
                .sheet("学生列表")
                .doWrite(getdata());

    }
    private static List<Exceldome> getdata(){
        List list =new ArrayList();
        for (int i = 0; i < 20; i++) {
            Exceldome exceldome =new Exceldome();
            exceldome.setSno(i);
            exceldome.setSname("jj"+i);
            list.add(exceldome);

        }
            return list;
        }
        @Test
        public void read(){
            //设置读取文件路径
            String filename ="D:\\write.xlsx";
           EasyExcel.read(filename,Exceldome.class,new ExcelRead()).sheet().doRead();
        }
        @Test
        public void  ss(){
       Integer s = 128;
       Integer d =128;
            System.out.println(s == d);

        }



}
