package peaksoft.repo;

import peaksoft.entity.Course;
import peaksoft.entity.Instructor;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

public interface InstructorRepo {

    void saveInstructor(Long companyId, Instructor instructor);
    void saveInstructor1( Instructor instructor);
    List<Instructor> getAllInstructor();
    Instructor getInstructorById(Long id);
    List<Instructor> getAllInstructorByCompany(Long companyId);
    void deleteInstructor(Long id);
    void updateInstructor(Long id, Instructor newInstructor);
    void bookCourse(Long courseId, List<Long> instructorIds);
}
