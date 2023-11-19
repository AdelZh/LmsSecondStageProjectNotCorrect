package peaksoft.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Student;
import peaksoft.repo.StudentRepo;
import peaksoft.service.StudentService;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public void saveStudent(Long companyId, Student student) {
        studentRepo.saveStudent(companyId, student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepo.getStudentById(id);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.getAllStudent();
    }

    @Override
    public List<Student> getAllStudentByCompanyId(Long id) {
        return studentRepo.getAllStudentByCompanyId(id);
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepo.deleteStudent(id);
    }

    @Override
    public void updateStudent(Long id, Student newStudent) {
        studentRepo.updateStudent(id, newStudent);
    }


    @Override
    public void saveStudent(Student student) {
        studentRepo.saveStudent(student);
    }
}
