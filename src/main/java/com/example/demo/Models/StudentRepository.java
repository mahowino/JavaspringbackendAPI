package com.example.demo.Models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    @Transactional
    @Modifying
    @Query("update Student s set s.name = ?1, s.email = ?2 where s.id = ?3")
    int updateByStudentID(String name, String email, Long id);

   // @Query("SELECT s FROM STUDENT s WHERE s.email=?1")
    Optional<Student> findStudentByEmail(String email);

}
