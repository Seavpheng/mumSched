package mumsched.services;

import mumsched.domain.Faculty;
import mumsched.repositories.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyService {

    @Autowired
    private FacultyRepository  facultyRepository;

    public boolean Save(Faculty faculty){
        boolean blnResult = false;
        try {
            facultyRepository.save(faculty);
            blnResult = true;
        }
        catch (Exception ex){
            throw ex;
        }
        return blnResult;
    }

    public Faculty getFaculty(Long id){
        return facultyRepository.findFacultyById(id);
    }

    public void delete(Long studentId){
        Faculty faculty = getFaculty(studentId);
        facultyRepository.delete(faculty);
    }

    public Iterable<Faculty> getAll(){
        return facultyRepository.findAll();
    }


}
