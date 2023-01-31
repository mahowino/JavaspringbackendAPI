package com.example.demo.ServiceLayer;

import com.example.demo.Models.Student;
import com.example.demo.Models.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getListOfStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> userByEmail=studentRepository.findStudentByEmail(student.getEmail());
        if (userByEmail.isPresent()){
            throw new IllegalStateException("email is taken");
        }
        studentRepository.save(student);
    }


    public void deleteStudent(Long studentID) {
       boolean b=studentRepository.existsById(studentID);
       if (!b){
           throw new IllegalStateException("student with ID "+studentID+" does not exist");
       }
       studentRepository.deleteById(studentID);
    }

    public void updateStudent(Long studentID, String name, String email) {
        boolean b=studentRepository.existsById(studentID);
        if (!b)
            throw new IllegalStateException("student with ID "+studentID+" does not exist");

        studentRepository.updateByStudentID(name,email,studentID);
    }
}
   /*
}*/
