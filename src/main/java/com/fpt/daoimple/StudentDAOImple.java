package com.fpt.daoimple;

import com.fpt.dao.StudentDAO;
import com.fpt.entities.Student;
import com.fpt.utils.XJpa;

import java.util.HashMap;
import java.util.List;

public class StudentDAOImple implements StudentDAO {

    @Override
    public List<Student> findAll() {
        String jpql = "select s from Student s";
        return XJpa.getResultList(Student.class,jpql,new HashMap<>());
    }

    @Override
    public Student findById(Integer id) {
        String jpql = "select s from Student s where s.id = ?1";
        return XJpa.getSingleResult(Student.class,jpql,id);
    }

    @Override
    public Student create(Student item) {
        return XJpa.excuteUpdate(item,1);
    }

    @Override
    public Student update(Student item) {
        return XJpa.excuteUpdate(item,0);
    }

    @Override
    public Student deleteById(Integer id) {
        return XJpa.excuteDUpdate(id,Student.class);
    }
}
