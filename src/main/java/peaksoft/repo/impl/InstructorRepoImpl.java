package peaksoft.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;

import peaksoft.repo.InstructorRepo;
import peaksoft.service.CourseService;
import peaksoft.service.InstructorService;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Repository
@Transactional
public class InstructorRepoImpl implements InstructorRepo {

    @PersistenceContext
    private EntityManager entityManager;
    @Autowired
    private CourseService courseService;
    @Autowired
    private InstructorService instructorService;





    @Override
    public void saveInstructor(Long companyId, Instructor instructor) {
        Company company = entityManager.find(Company.class, companyId);
        instructor.setCompany(company);
        entityManager.persist(instructor);
    }


    @Override
    public List<Instructor> getAllInstructor() {
        return entityManager.createQuery("select i from Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public List<Instructor> getAllInstructorByCompany(Long companyId) {
        Company company = entityManager.find(Company.class, companyId);
        if (company != null && company.getCourse() != null) {
            return new ArrayList<>(company.getInstructors());
        } else {
            return Collections.emptyList();
        }
    }


    @Override
    public void deleteInstructor(Long id) {
        entityManager.remove(entityManager.find(Instructor.class, id));
    }

    @Override
    public void updateInstructor(Long id, Instructor newInstructor) {
        Instructor instructor = entityManager.find(Instructor.class, id);
        instructor.setFirstName(newInstructor.getFirstName());
        instructor.setLastName(newInstructor.getLastName());
        instructor.setSpecialization(newInstructor.getSpecialization());
        instructor.setEmail(newInstructor.getEmail());
        instructor.setPhoneNumber(newInstructor.getPhoneNumber());
        entityManager.merge(instructor);
    }

    @Override
    public void saveInstructor1(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public void bookCourse(Long courseId, List<Long> instructorIds) {

        Course course = courseService.getCourseById(courseId);
        if (course != null) {
            for (Long instructorId : instructorIds) {
                Instructor instructor = instructorService.getInstructorById(instructorId);

                if (instructor != null) {
                    instructor.setCourse(course);

                    instructorService.saveInstructor1(instructor);
                }
            }
        }
    }
}

