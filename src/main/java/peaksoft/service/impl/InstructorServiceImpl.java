package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.repo.InstructorRepo;
import peaksoft.service.InstructorService;

import java.util.List;


@Service
public class InstructorServiceImpl implements InstructorService {

    @Autowired
    private InstructorRepo instructorRepo;

    @Override
    public void saveInstructor(Long companyId, Instructor instructor) {
        instructorRepo.saveInstructor(companyId, instructor);
    }

    @Override
    public List<Instructor> getAllInstructor() {
        return instructorRepo.getAllInstructor();
    }

    @Override
    public Instructor getInstructorById(Long id) {
        return instructorRepo.getInstructorById(id);
    }

    @Override
    public List<Instructor> getAllInstructorByCompany(Long companyId) {
        return instructorRepo.getAllInstructorByCompany(companyId);
    }

    @Override
    public void deleteInstructor(Long id) {
        instructorRepo.deleteInstructor(id);
    }

    @Override
    public void updateInstructor(Long id, Instructor newInstructor) {
        instructorRepo.updateInstructor(id, newInstructor);
    }


    @Override
    public void bookCourse(Long courseId, List<Long> instructorIds) {
       instructorRepo.bookCourse(courseId, instructorIds);
    }

    @Override
    public void saveInstructor1(Instructor instructor) {
        instructorRepo.saveInstructor1(instructor);
    }
}
