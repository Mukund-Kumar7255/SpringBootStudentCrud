package studentcrud.example.student.Controller;

//import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import studentcrud.example.student.Entity.StudentEntity;
import studentcrud.example.student.Service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Operation(summary = "Create a new student")
//    @ApiResponse(responseCode="201",description="User created successfully")
    @PostMapping("/")
    public StudentEntity createStudent(@RequestBody StudentEntity student) {
        return studentService.createStudent(student);
    }
    @Operation(summary = "Get All Student",description = "Returns all students")
    @GetMapping("/")
    public List<StudentEntity> getAllStudent()
    {
        return studentService.getAllStudent();
    }
    @Operation(summary = "Get a student by id",description = "Get a single student")
    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getStudentById(@PathVariable Integer id)
    {
        StudentEntity studentEntity=studentService.getStudentById(id);
        return ResponseEntity.ok(studentEntity);
    }
    @Operation(summary = "Delete student by id",description = "Delete a particular student")
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Integer id)
    {
        studentService.deleteById(id);
       // return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentEntity> updateStudent(@PathVariable Integer id, @RequestBody StudentEntity updatedStudent)
    {
        StudentEntity student=studentService.updateStudent(id, updatedStudent);
        return ResponseEntity.ok(student);
    }
    @DeleteMapping("/")
    public void deleteStudent()
    {
        studentService.deleteStudent();
    }
}
