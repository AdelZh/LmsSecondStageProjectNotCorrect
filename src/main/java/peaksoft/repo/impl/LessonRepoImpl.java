package peaksoft.repo.impl;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Course;
import peaksoft.entity.Group;
import peaksoft.entity.Lesson;
import peaksoft.repo.LessonRepo;
import peaksoft.service.LessonService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Transactional
@Repository
public class LessonRepoImpl implements LessonRepo {


   @PersistenceContext
   private EntityManager entityManager;

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        Course course=entityManager.find(Course.class, courseId);
        lesson.setCourse(course);
        entityManager.persist(lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return entityManager.find(Lesson.class, id);
    }

    @Override
    public List<Lesson> getAllLesson() {
        return entityManager.createQuery("select l from Lesson l", Lesson.class).getResultList();
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long courseId) {
        Course course=entityManager.find(Course.class,courseId );
        if(course!=null && course.getLesson()!=null){
            return  new ArrayList<>(course.getLesson());
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public void deleteLesson(Long id) {

    }

    @Override
    public void updateLesson(Long id, Lesson newLesson) {
        Lesson lesson=entityManager.find(Lesson.class, id);
        lesson.setLessonName(newLesson.getLessonName());
        entityManager.merge(lesson);
    }
}
