package studentcrud.example.student.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import studentcrud.example.student.Entity.StudentEntity;

public interface StudentRepo extends JpaRepository<StudentEntity,Integer> {

}
