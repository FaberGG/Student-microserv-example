package co.unicauca.apireststudent.controllers;

import co.unicauca.apireststudent.entities.Student;
import co.unicauca.apireststudent.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")

@RequestMapping(path = "api/v1/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("")
    public ResponseEntity<?> getAllStudents() throws Exception{
        try {
            return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. por favor intente mas tarde\"}");
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable Long id) throws Exception{
        try {
            Student student = studentService.findById(id);
            return ResponseEntity.status(HttpStatus.OK).body(student);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. por favor intente mas tarde\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> createStudent(@RequestBody Student student) throws Exception{
        try {
            Student newStudent = studentService.create(student);
            return ResponseEntity.status(HttpStatus.CREATED).body(newStudent);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error. por favor intente mas tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable Long id, @RequestBody Student student) throws Exception{
        try {
            Student updatedStudent = studentService.update(id, student);
            return ResponseEntity.status(HttpStatus.OK).body(updatedStudent);
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error. por favor intente mas tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable Long id) throws Exception{
        try {
            boolean deleted = studentService.delete(id);
            if(deleted){
                return ResponseEntity.status(HttpStatus.OK).body("{\"message\":\"Estudiante eliminado correctamente\"}");
            }else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"Error\":\"Error. por favor intente mas tarde\"}");
            }
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"Error\":\"Error. por favor intente mas tarde\"}");
        }
    }
}
