package peaksoft.repo;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseRepo {

    void saveCourse(Long companyId, Course course);
    void saveCourse( Course course);
    void deleteCourse(Long id);
    void updateCourse(Long id, Course newCourse);
    Course getCourseById(Long id);
    List<Course> getAll();
    List<Course> getAllCourseByCompanyId(Long companyId);

}
