package app.nzyme.plugin.distributed.messaging;

public interface MessageHandler {

    MessageProcessingResult handle(ReceivedMessage message);
    String getName();

}
