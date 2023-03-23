package app.nzyme.plugin.distributed.tasksqueue;

public interface TaskHandler {

    TaskProcessingResult handle(ReceivedTask task);

    String getName();

}
