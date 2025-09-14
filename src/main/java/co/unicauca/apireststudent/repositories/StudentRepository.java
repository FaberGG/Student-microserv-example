package co.unicauca.apireststudent.repositories;
import co.unicauca.apireststudent.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
