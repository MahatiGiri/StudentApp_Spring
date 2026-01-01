package com.example.StudentApp.controllers;

import com.example.StudentApp.entity.StudentEntity;
import com.example.StudentApp.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class MyController {
    public MyController() {
    }

    @Autowired
    StudentService studentService;

    public MyController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/studentform")
    public String studentform(Model model){
        StudentEntity studentEntity= new StudentEntity();
        model.addAttribute("studentEntityObj",studentEntity);
        return "studentform";
    }

    @RequestMapping("/studentsubmit")
    public String studentsubmit(@Valid @ModelAttribute("studentEntityObj") StudentEntity studentEntity,
                                BindingResult result, Model model){
        if(result.hasErrors()){
            return "studentform";
        }
        model.addAttribute("studentdata",studentEntity);
        studentService.saveStudent(studentEntity);
        return "studentsubmit";
    }

    @RequestMapping("/studentlist")
    public String studentlist(Model model){
        List<StudentEntity> studentList=studentService.getStudentList();
        model.addAttribute("studentList",studentList);
        return "studentlist";
    }
    @RequestMapping("/studentdelete/{studid}")
    public String studentdeletebyid(@PathVariable String studid, RedirectAttributes redirectAttributes){
        int stud_id=Integer.parseInt(studid);
        studentService.studentdelete(stud_id);
        redirectAttributes.addFlashAttribute("successMsg","student deleted successfully...");
        return "redirect:/studentlist";
    }
    @RequestMapping("/studentupdate/{studid}")
    public String studentupdate(@PathVariable String studid,Model model){
       int stud_id=Integer.parseInt(studid);
       StudentEntity studentEntity=studentService.getStudentById(stud_id);
       model.addAttribute("studentEntity",studentEntity);
       return "studentupdate";
    }
    @RequestMapping("/updatesucceed")
    public String studentupdate(@Valid @ModelAttribute("studentEntity") StudentEntity student,
                                BindingResult result,RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "redirect:/studentupdate/{studid}";
        }
        studentService.studentupdate(student.getId(),student);
        redirectAttributes.addFlashAttribute("updateMsg","student updated successfully...");
        return "redirect:/studentlist";
    }
    @RequestMapping("/searchstudent")
    public String searchstudent(){
        return "searchstudent";
    }
    @RequestMapping("/searchsubmit")
    public String searchsubmit(@RequestParam("keyword") String keyword,Model model){
        int stud_id=Integer.parseInt(keyword);
        StudentEntity studentEntity=studentService.getStudentById(stud_id);
        model.addAttribute("studentEntity",studentEntity);
        return "searchstudent";
    }
}
