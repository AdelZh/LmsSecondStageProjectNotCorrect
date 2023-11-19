package peaksoft.repo.impl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.repo.TaskRepo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
@Transactional
public class TaskRepoImpl implements TaskRepo {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveTask(Long lessonId, Task task) {
        Lesson lesson=entityManager.find(Lesson.class, lessonId);
        task.setLesson(lesson);
        entityManager.persist(task);
    }


    @Override
    public void deleteTask(Long id) {

    }

    @Override
    public List<Task> getAllTask() {
        return entityManager.createQuery("select t from Task t", Task.class).getResultList();
    }

    @Override
    public List<Task> getTaskByLessonId(Long lessonId) {
        Lesson lesson=entityManager.find(Lesson.class, lessonId);
        if(lesson != null && lesson.getTask() != null){
            return new ArrayList<>(lesson.getTask());
        }else {
            return Collections.emptyList();
        }
    }

    @Override
    public void updateTask(Long id, Task newTask) {
        Task task=entityManager.find(Task.class, id);
        task.setTaskName(newTask.getTaskName());
        task.setTaskText(newTask.getTaskText());
        task.setDeadline(newTask.getDeadline());
        entityManager.merge(task);

    }

    @Override
    public Task getTaskById(Long taskId) {
        return entityManager.find(Task.class, taskId);
    }
}

