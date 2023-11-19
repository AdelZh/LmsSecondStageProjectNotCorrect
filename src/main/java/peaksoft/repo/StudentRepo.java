package peaksoft.repo;

import peaksoft.entity.Student;

import java.util.List;

public interface StudentRepo {

    void saveStudent(Long companyId, Student student);
    void saveStudent( Student student);
    Student getStudentById(Long id);
    List<Student> getAllStudent();
    List<Student> getAllStudentByCompanyId(Long id);
    void deleteStudent(Long id);
    void updateStudent(Long id, Student newStudent);

}
