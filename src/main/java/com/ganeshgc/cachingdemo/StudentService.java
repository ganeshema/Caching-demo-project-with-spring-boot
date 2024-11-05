package com.ganeshgc.cachingdemo;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    @Cacheable(key = "#id", value = "StudentCache")
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }
    public boolean deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return true;
    }
    @CacheEvict(value = "StudentCache", allEntries = true)
    public void clearCache(){
        System.out.println("clearing all cache===============================");

    }
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    //just comment

}
