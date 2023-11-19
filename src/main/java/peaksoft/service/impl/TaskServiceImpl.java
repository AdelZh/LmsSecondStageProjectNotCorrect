package peaksoft.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.repo.TaskRepo;
import peaksoft.service.TaskService;

import java.util.List;

@Service

public class TaskServiceImpl implements TaskService {


    @Autowired
    private TaskRepo taskRepo;


    @Override
    public void saveTask(Long lessonId, Task task) {
        taskRepo.saveTask(lessonId, task);
    }

    @Override
    public void deleteTask(Long id) {
        taskRepo.deleteTask(id);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepo.getAllTask();
    }

    @Override
    public List<Task> getTaskByLessonId(Long taskId) {
        return taskRepo.getTaskByLessonId(taskId);
    }

    @Override
    public void updateTask(Long id, Task newTask) {
        taskRepo.updateTask(id, newTask);
    }

    @Override
    public Task getTaskById(Long taskId) {
        return taskRepo.getTaskById(taskId);
    }
}