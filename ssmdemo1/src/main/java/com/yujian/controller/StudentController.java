package com.yujian.controller;

import com.yujian.model.ClassInfo;
import com.yujian.model.Student;
import com.yujian.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StudentController {
    @Autowired(required = false)
//    @Resource
    private StudentService studentService;
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder){
        binder.registerCustomEditor(Date.class,new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"),true));
    }
    @RequestMapping(value = "/login")
    public String login(Model model){
        List<Student> students=studentService.findStudentList();
        model.addAttribute("students",students);
        return "studentList";
    }
    @RequestMapping("/studentAddEdit")
    public String studentEdit(Model model){
        List<ClassInfo> classInfoList=studentService.findeClssInfoList();
        model.addAttribute("classInfoList",classInfoList);
        /*if(stuId!=null&&!stuId.equals("")){
            Student student=studentService.findStuentById(stuId);
            model.addAttribute("student",student);
        }*/
        return "studentAddEdit";
    }
    @RequestMapping("/studentUpdateEdit")
    public String studentUpdateEdit(Model model,Integer stuId){
        List<ClassInfo> classInfoList=studentService.findeClssInfoList();
        model.addAttribute("classInfoList",classInfoList);
        Student student=studentService.findStuentById(stuId);
        model.addAttribute("student",student);
        return "studentUpdateEdit";
    }
    @RequestMapping("/studentAddSave")
    public String save(Student student/*,HttpServletRequest request*/){
        /*String stuId=request.getParameter("stuId");
        String stuName=request.getParameter("stuName");
        String stuBirth=request.getParameter("stuBirth");
        String stuSex=request.getParameter("stuSex");
        String classId=request.getParameter("classInfo.classId");
        Student student=new Student();
        if(stuName!=null&&!stuName.equals("")){
            student.setStuName(stuName);
        }
        DateFormat format=new DateFormat();
        if(stuBirth!=null&&!stuBirth.equals("")){
            student.setStuBirth(format.format(stuBirth));
        }
        if(stuSex!=null&&!stuSex.equals("")){
            student.setStuSex(Integer.parseInt(stuSex));
        }
        if(classId!=null&&!classId.equals("")){
            ClassInfo classInfo=new ClassInfo();
            classInfo.setClassId(Integer.parseInt(classId));
            student.setClassInfo(classInfo);
        }*/
//        if(stuId!=null&&!stuId.equals("")){
//            student.setStuId(Integer.parseInt(stuId));
//            studentService.updateStudent(student);
//        }else {
            studentService.insertStudent(student);
//        }
        return "redirect:login";
    }
    @RequestMapping("/studentUpdateSave")
    public String updateSave(Student student/*,HttpServletRequest request*/){
        /*String stuId=request.getParameter("stuId");
        String stuName=request.getParameter("stuName");
        String stuBirth=request.getParameter("stuBirth");
        String stuSex=request.getParameter("stuSex");
        String classId=request.getParameter("classInfo.classId");
        Student student=new Student();
        if(stuName!=null&&!stuName.equals("")){
            student.setStuName(stuName);
        }
        DateFormat format=new DateFormat();
        if(stuBirth!=null&&!stuBirth.equals("")){
            student.setStuBirth(format.format(stuBirth));
        }
        if(stuSex!=null&&!stuSex.equals("")){
            student.setStuSex(Integer.parseInt(stuSex));
        }
        if(classId!=null&&!classId.equals("")){
            ClassInfo classInfo=new ClassInfo();
            classInfo.setClassId(Integer.parseInt(classId));
            student.setClassInfo(classInfo);
        }*/
//        if(stuId!=null&&!stuId.equals("")){
//            student.setStuId(Integer.parseInt(stuId));
//            studentService.updateStudent(student);
//        }else {
        studentService.updateStudent(student);
//        }
        return "redirect:login";
    }
    @RequestMapping("/delete")
    public String deleteStudent(Integer stuId){
        studentService.deleteStudent(stuId);
        return "redirect:login";
    }
}
