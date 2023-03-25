package app.nzyme.plugin.distributed.tasksqueue;

import org.joda.time.DateTime;

import java.util.List;

public interface TasksQueue {

    void initialize();

    void onMessageReceived(TaskType type, TaskHandler taskHandler);

    void publish(Task task);
    void poll();
    void retry(long taskId);

    List<ReceivedTask> getAllFailedTasksSince(DateTime since);
    List<ReceivedTask> getAllStuckTasks(DateTime timeout);

    List<ReceivedTask> getAllTasks(int limit, int offset);

}
