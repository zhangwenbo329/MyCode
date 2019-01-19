package com.yujian.service;

import com.yujian.dao.ClassInfoMapper;
import com.yujian.dao.StudentMapper;
import com.yujian.model.ClassInfo;
import com.yujian.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
@Transactional
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private ClassInfoMapper classInfoMapper;

    public List<Student> findStudentList(){
        List<Student> students=studentMapper.findeStudentList();
        return students;
    }
    public List<ClassInfo> findeClssInfoList(){
        List<ClassInfo> classInfoList=classInfoMapper.findClassInfoList();
        return classInfoList;
    }

    public void insertStudent(Student student) {
        studentMapper.insertStuent(student);
    }

    public Student findStuentById(int stuId) {
        Student student=studentMapper.findStudentById(stuId);
        return student;
    }

    public void updateStudent(Student student) {
        studentMapper.updateStudent(student);
    }

    public void deleteStudent(Integer stuId) {
        studentMapper.deleteStudent(stuId);
    }
}
