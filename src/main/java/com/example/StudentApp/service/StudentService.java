package com.example.StudentApp.service;

import com.example.StudentApp.dao.StudentDaoImpl;
import com.example.StudentApp.entity.StudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentDaoImpl studentDao;

    public void saveStudent(StudentEntity studentEntity){
        studentDao.save(studentEntity);
    }

    public List<StudentEntity> getStudentList(){
        return studentDao.findAll();
    }

    public StudentEntity getStudentById(int id){
        return studentDao.getStudentById(id);
    }

    public void studentdelete(int id){
        studentDao.delete(id);
    }

    public void studentupdate(int id,StudentEntity student){
        StudentEntity updateEntity =getStudentById(id);
        updateEntity.setName(student.getName());
        updateEntity.setEmail(student.getEmail());
        updateEntity.setBranch(student.getBranch());
        updateEntity.setCity(student.getCity());
        updateEntity.setCourse(student.getCourse());
        updateEntity.setFees(student.getFees());
        studentDao.update(updateEntity);
    }
}

