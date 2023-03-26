package app.nzyme.plugin.distributed.tasksqueue;

public enum TaskStatus {

    NEW, NEW_RETRY, ACK, PROCESSED_SUCCESS, PROCESSED_FAILURE, CANCELED

}
