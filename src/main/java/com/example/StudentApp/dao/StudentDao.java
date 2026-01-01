package com.example.StudentApp.dao;

import com.example.StudentApp.entity.StudentEntity;

import java.util.List;

public interface StudentDao {
    public void save(StudentEntity studentEntity);
    public List<StudentEntity> findAll();
    public StudentEntity getStudentById(int id);
    public void delete(int id);
    public void update(StudentEntity student);
}
