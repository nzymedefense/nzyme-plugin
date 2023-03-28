package app.nzyme.plugin.distributed.tasksqueue;

import org.joda.time.DateTime;

import java.util.List;

public interface TasksQueue {

    void initialize();

    void onMessageReceived(TaskType type, TaskHandler taskHandler);

    void publish(Task task);
    void poll();
    void acknowledgeTaskFailure(long taskId);
    void acknowledgeAllTaskFailures();

    List<StoredTask> getAllFailedTasksSince(DateTime since);
    List<StoredTask> getAllStuckTasks(DateTime timeout);

    List<StoredTask> getAllTasks(int limit, int offset);
    long getTotalTaskCount();


}
