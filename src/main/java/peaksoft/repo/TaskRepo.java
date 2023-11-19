package peaksoft.repo;

import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.service.impl.TaskServiceImpl;

import java.util.List;

public interface TaskRepo {

    void saveTask(Long lessonId, Task task);
    void deleteTask(Long id);
    List<Task> getAllTask();
    List<Task> getTaskByLessonId(Long taskId);
    void updateTask(Long id, Task newTask);
    Task getTaskById(Long taskId);

}
