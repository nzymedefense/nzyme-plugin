package app.nzyme.plugin.distributed.tasksqueue;


public interface TasksQueue {

    void initialize();

    void onMessageReceived(TaskType type, TaskHandler taskHandler);

    void publish(Task task);
    void poll();
    void retry(long taskId);

}
