package com.yujian.dao;

import com.yujian.model.ClassInfo;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassInfoMapper {
    @Select("select * from classinfo where classId=#{classId}")
    ClassInfo findListClassInfoById(int classId);
    @Select("select * from classInfo")
    List<ClassInfo> findClassInfoList();
}
