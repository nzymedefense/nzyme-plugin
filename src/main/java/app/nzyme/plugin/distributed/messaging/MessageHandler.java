package app.nzyme.plugin.distributed.messaging;

public interface MessageHandler {

    MessageProcessingResult handle(Message message);
    String getName();

}
