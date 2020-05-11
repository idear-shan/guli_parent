package com.guigu.dome.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Exceldome {
    //设置表头注解
    @TableId(type = IdType.ID_WORKER_STR)
    @ExcelProperty(value = "课程编号",index = 0)
    private Integer sno;
    @ExcelProperty(value = "课程名称",index = 1)
    private  String sname;
}
