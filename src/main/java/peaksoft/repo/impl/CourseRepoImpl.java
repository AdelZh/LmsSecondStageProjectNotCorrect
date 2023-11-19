package peaksoft.repo.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Company;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.entity.Instructor;
import peaksoft.repo.CompanyRepo;
import peaksoft.repo.CourseRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository
public class CourseRepoImpl implements CourseRepo {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void saveCourse(Course course) {
        entityManager.persist(course);
    }

    @Override
    public void saveCourse(Long companyId, Course course) {
        Company company=entityManager.find(Company.class, companyId);
        course.setCompany(company);
        entityManager.persist(course);
    }

    @Override
    public void deleteCourse(Long id) {
       /* Course course=entityManager.find(Course.class, id);
        for(Instructor instructor:course.getInstructor()){
            instructor.setCourse(null);
        }
        for(Group group:course.getGroup()){
            group.setCourse(null);
        }

        Company company=course.getCompany();
        company.setCourse(null);
        entityManager.remove(course);

        */


    }

    @Override
    public void updateCourse(Long id, Course newCourse) {
        Course course=entityManager.find(Course.class, id);
        course.setCourseName(newCourse.getCourseName());
        course.setDescription(newCourse.getDescription());
        course.setDuration(newCourse.getDuration());
        entityManager.merge(course);
    }

    @Override
    public Course getCourseById(Long id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    public List<Course> getAll() {
        return entityManager.createQuery("select c from Course c", Course.class).getResultList();
    }

    @Override
    public List<Course> getAllCourseByCompanyId(Long companyId) {
        Company company=entityManager.find(Company.class, companyId);
        if(company != null && company.getCourse() != null){
            return new ArrayList<>(company.getCourse());
        }else {
            return Collections.emptyList();
        }
    }
}
