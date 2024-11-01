package studentcrud.example.student.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import studentcrud.example.student.Entity.StudentEntity;
import studentcrud.example.student.Repo.StudentRepo;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;
    @Override
    public StudentEntity createStudent(StudentEntity studentEntity) {

        return  this.studentRepo.save(studentEntity);
    }

    @Override
    public List<StudentEntity> getAllStudent() {
        List<StudentEntity> studentEntity=this.studentRepo.findAll();
        return studentEntity;
    }

    @Override
    public StudentEntity getStudentById(Integer id) {

        return this.studentRepo.findById(id).orElseThrow(()->new RuntimeException("Id can't be find"+id));    }

    @Override
    public void deleteStudent() {
        this.studentRepo.deleteAll();
    }

    @Override
    public void deleteById(Integer id) {
        this.studentRepo.deleteById(id);
    }

    @Override
    public StudentEntity updateStudent(Integer id, StudentEntity studentEntity) {
        StudentEntity student=getStudentById(id);
        if(student!=null){
            student.setName(studentEntity.getName());
            student.setEmail(studentEntity.getEmail());
            student.setAddress(studentEntity.getAddress());
            return this.studentRepo.save(student);
        }
        return null;
    }
}
