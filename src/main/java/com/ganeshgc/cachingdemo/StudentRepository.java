package com.ganeshgc.cachingdemo;

import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student,Integer> {

}
