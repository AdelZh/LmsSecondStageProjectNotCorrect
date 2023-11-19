package peaksoft.repo.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.api.CompanyApi;
import peaksoft.entity.Company;
import peaksoft.entity.Group;
import peaksoft.entity.Student;
import peaksoft.repo.StudentRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository
public class StudentRepoImpl implements StudentRepo {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveStudent(Long groupId, Student student) {
        Group group=entityManager.find(Group.class, groupId);
        student.setGroup(group);
        entityManager.persist(student);
    }


    @Override
    public Student getStudentById(Long id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> getAllStudent() {
        return entityManager.createQuery("select s from Student s", Student.class).getResultList();
    }

    @Override
    public List<Student> getAllStudentByCompanyId(Long id) {
        Company company=entityManager.find(Company.class, id);
        if(company != null && company.getStudents() != null){
            return new ArrayList<>(company.getStudents());
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public void deleteStudent(Long id) {

    }

    @Override
    public void updateStudent(Long id, Student newStudent) {
        Student student=entityManager.find(Student.class, id);
        student.setFirstName(newStudent.getFirstName());
        student.setLastName(newStudent.getLastName());
        student.setPhoneNumber(newStudent.getPhoneNumber());
        student.setEmail(newStudent.getEmail());
        entityManager.merge(student);
    }

    @Override
    public void saveStudent(Student student) {
        entityManager.persist(student);
    }
}
