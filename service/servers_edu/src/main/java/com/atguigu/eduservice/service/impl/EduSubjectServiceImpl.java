package com.atguigu.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.eduservice.entity.EduSubject;
import com.atguigu.eduservice.entity.excel.SubjectData;
import com.atguigu.eduservice.entity.subject.OneSubject;
import com.atguigu.eduservice.entity.subject.TwoSubject;
import com.atguigu.eduservice.listener.SubjectExcelListener;
import com.atguigu.eduservice.mapper.EduSubjectMapper;
import com.atguigu.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-05-07
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {
    //添加课程分类
    @Override
    public void saveobject(MultipartFile file, EduSubjectService eduSubjectService) {
        try {
            //得到文件流对象
            System.out.println("得到文件流对象");
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class, new SubjectExcelListener(eduSubjectService)).sheet().doRead();
            System.out.println("结束");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<OneSubject> findAllsubject() {
        //查询一级分类
        QueryWrapper<EduSubject> onequeryWrapper = new QueryWrapper();
        onequeryWrapper.eq("parent_id", "0");
        List dbonelist = baseMapper.selectList(onequeryWrapper);
        //查询二级分类
        QueryWrapper<EduSubject> towqueryWrapper = new QueryWrapper<>();
        towqueryWrapper.ne("parent_id", "0");
        List dbtwolist = baseMapper.selectList(towqueryWrapper);
        //放一级分类的集合
        List<OneSubject> finalSubjectList = new ArrayList<>();
        for (int i = 0; i < dbonelist.size(); i++) {
            OneSubject oneSubject = new OneSubject();
            EduSubject eduSubject = (EduSubject) dbonelist.get(i);
            //oneSubject.setId(eduSubject.getId());
            //oneSubject.setTitle(eduSubject.getTitle());
            //第一个get 第二个set
            BeanUtils.copyProperties(eduSubject, oneSubject);
            finalSubjectList.add(oneSubject);
            //在一级分类里循环遍历二级分类
            List<TwoSubject> twoFinalSubjectList = new ArrayList();
            for (int j = 0; j < dbtwolist.size(); j++) {

                //获取每个二级分类
                EduSubject tSubject  = (EduSubject) dbtwolist.get(j);

                if (tSubject.getParentId().equals(eduSubject.getId())) {
                    TwoSubject twoSubject = new TwoSubject();
                    BeanUtils.copyProperties(tSubject , twoSubject);
                    twoFinalSubjectList.add(twoSubject);
                }
            }
            //把一级下的所有二级分类放在一级分类里
            oneSubject.setChildren(twoFinalSubjectList);
            System.out.println(twoFinalSubjectList);
        }
          return finalSubjectList;
    }
}
