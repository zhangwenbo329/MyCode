package com.yujian.dao;

import com.yujian.model.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentMapper {
    @Select("select s.*,c.* from student s inner join classinfo c on s.classid=c.classid order by s.stuId")
    @Results(id = "student",value = {
//            @Result(column = "stuName",property = "stuName1"),
            /*@Result(column = "classId",property = "classInfo.classId"),
            @Result(column = "className",property = "classInfo.className"),*/
            @Result(property = "classInfo",column = "classId",one=@One(select = "com.yujian.dao.ClassInfoMapper.findListClassInfoById"))
            /*@Result(column = "className",property = "classInfo.className") ,
            @Result(column = "classId",property = "classInfo.classId")*/
            /* @Result(column = "stuId",property = "stuId"),
            @Result(column = "stuBirth",property = "stuBirth"),
            @Result(column = "stuSex",property = "stuSex")
            列不需要字段写全，只要不同名字段属性，给一一匹配就好
            */

    })
    List<Student> findeStudentList();
    @Select("select s.*,c.* from student s inner join classinfo c on s.classid=c.classid order by s.stuId limit #{param1},#{param2}")
    @ResultMap("student")
    List<Student> findStudentListLimit(int pageNoSize,int pageSize);
    @Insert("insert into student(stuName,stuSex,stuBirth,classId)values(#{stuName},#{stuSex},#{stuBirth},#{classInfo.classId})")
    void insertStuent(Student student);
    @Select("select s.*,c.* from student s inner join classInfo c on s.classId=c.classId where s.stuId=#{stuId}")
    @ResultMap("student")
    Student findStudentById(int stuId);
    @Update("update student set stuName=#{stuName},stuSex=#{stuSex},stuBirth=#{stuBirth},classId=#{classInfo.classId} where stuId=#{stuId}")
    void updateStudent(Student student);
    @Delete("delete from student where stuId=#{stuId}")
    void deleteStudent(Integer stuId);
}
