package com.example.demo.APILayer;

import com.example.demo.Models.Student;
import com.example.demo.ServiceLayer.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/students")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getListOfStudents(StudentService service){
        return studentService.getListOfStudents();
    }

    @PostMapping("/register")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "/{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long id){
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "/{studentID}")
    public void updateStudent(
            @PathVariable("studentID") Long studentID,
            @RequestParam String email,
            @RequestParam String name
    ){
        studentService.updateStudent(studentID,name,email);
    }

}
