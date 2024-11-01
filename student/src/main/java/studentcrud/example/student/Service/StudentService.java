package studentcrud.example.student.Service;

import studentcrud.example.student.Entity.StudentEntity;

import java.util.List;

public interface StudentService {
    //create a new student
     StudentEntity createStudent(StudentEntity studentEntity);

    //get the all students
     List<StudentEntity> getAllStudent();
    //get the single student
     StudentEntity getStudentById(Integer id);
    //delete the single student
     void deleteStudent();
    //delete the single student
    void deleteById(Integer id);
    StudentEntity updateStudent(Integer id, StudentEntity studentEntity);
}
