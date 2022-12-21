package mumsched.services;

import mumsched.domain.Student;
import mumsched.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public boolean Save(Student student){
        boolean blnResult = false;
        try {
            studentRepository.save(student);
            blnResult = true;
        }
        catch (Exception ex){
            throw ex;
        }
        return blnResult;
    }

    public Student getStudent(Long studentId){
        return studentRepository.findStudentById(studentId);
    }

    public void delete(Long studentId){
        Student student = getStudent(studentId);
        studentRepository.delete(student);
    }

    public Iterable<Student> getAll(){
        return studentRepository.findAll();
    }


}
