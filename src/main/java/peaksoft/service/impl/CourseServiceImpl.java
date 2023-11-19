package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Course;
import peaksoft.repo.CourseRepo;
import peaksoft.service.CourseService;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;


    @Override
    public void saveCourse(Course course) {
        courseRepo.saveCourse(course);
    }

    @Override
    public void saveCourse(Long companyId, Course course) {
        courseRepo.saveCourse(companyId, course);
    }

    @Override
    public void deleteCourse(Long id) {
        courseRepo.deleteCourse(id);
    }

    @Override
    public void updateCourse(Long id, Course newCourse) {
        courseRepo.updateCourse(id, newCourse);
    }

    @Override
    public Course getCourseById(Long id) {
        return courseRepo.getCourseById(id);
    }

    @Override
    public List<Course> getAll() {
        return courseRepo.getAll();
    }

    @Override
    public List<Course> getAllCourseByCompanyId(Long companyId) {
        return courseRepo.getAllCourseByCompanyId(companyId);
    }
}
