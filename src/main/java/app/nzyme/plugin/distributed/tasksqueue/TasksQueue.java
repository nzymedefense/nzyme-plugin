package app.nzyme.plugin.distributed.tasksqueue;

import java.time.ZonedDateTime;
import java.util.List;

public interface TasksQueue {

    void initialize();

    void onMessageReceived(TaskType type, TaskHandler taskHandler);

    void publish(Task task);
    void poll();
    void acknowledgeTaskFailure(long taskId);
    void acknowledgeAllTaskFailures();

    List<StoredTask> getAllFailedTasksSince(ZonedDateTime since);
    List<StoredTask> getAllStuckTasks(ZonedDateTime timeout);

    List<StoredTask> getAllTasks(int limit, int offset);
    long getTotalTaskCount();


}
