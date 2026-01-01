package com.example.StudentApp.dao;

import com.example.StudentApp.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDaoImpl implements StudentDao{
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void save(StudentEntity studentEntity){
        entityManager.persist(studentEntity);
    }

    @Override
    public List<StudentEntity> findAll() {
       List<StudentEntity> list=entityManager.createQuery("select s from StudentEntity s",StudentEntity.class).getResultList();
       return list;
    }

    @Override
    public StudentEntity getStudentById(int id) {
        return entityManager.find(StudentEntity.class,id);
    }

    @Override
    @Transactional
    public void delete(int id){
        StudentEntity entity=getStudentById(id);
        entityManager.remove(entity);
    }

    @Override
    @Transactional
    public void update(StudentEntity studentEntity){
        entityManager.merge(studentEntity);
    }
}

