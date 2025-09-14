package co.unicauca.apireststudent.services;

import co.unicauca.apireststudent.entities.Student;
import co.unicauca.apireststudent.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements BaseService<Student> {

    private StudentRepository repo;

    //inyeccion de dependencias
    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    @Transactional
    public List<Student> findAll() throws Exception {
        try{
            List<Student> students = repo.findAll();
            return students;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Student create(Student entity) throws Exception {
        try{
            entity = repo.save(entity);
            return entity;
        }catch(Exception e){
            throw  new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Student update(Long id, Student entity) throws Exception {
        try{
            Optional<Student> student = repo.findById(id);
            Student studentEntity = student.get();
            studentEntity = repo.save(entity);
            return studentEntity;
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Student findById(Long id) throws Exception {
        try {
            Optional<Student> optional = repo.findById(id);
            if (optional.isPresent()) {
                return optional.get();
            } else {
                throw new Exception("No se encontro el estudiante con id: " + id);
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean delete(Long id) throws Exception {
        try {
            if(repo.existsById(id)){
                repo.deleteById(id);
                return true;
            }else {
                throw  new Exception("No se encontro el estudiante con id: " + id);
            }
        }catch(Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
