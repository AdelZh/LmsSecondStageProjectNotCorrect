package peaksoft.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Lesson;
import peaksoft.repo.LessonRepo;
import peaksoft.service.LessonService;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private LessonRepo lessonRepo;

    @Override
    public void saveLesson(Long courseId, Lesson lesson) {
        lessonRepo.saveLesson(courseId, lesson);
    }

    @Override
    public Lesson getLessonById(Long id) {
        return lessonRepo.getLessonById(id);
    }

    @Override
    public List<Lesson> getAllLesson() {
        return lessonRepo.getAllLesson();
    }

    @Override
    public List<Lesson> getLessonByCourseId(Long courseId) {
        return lessonRepo.getLessonByCourseId(courseId);
    }

    @Override
    public void deleteLesson(Long id) {
        lessonRepo.deleteLesson(id);
    }

    @Override
    public void updateLesson(Long id, Lesson newLesson) {
        lessonRepo.updateLesson(id, newLesson);
    }
}