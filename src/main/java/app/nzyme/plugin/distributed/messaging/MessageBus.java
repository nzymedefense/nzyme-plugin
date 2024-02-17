package app.nzyme.plugin.distributed.messaging;

import java.time.ZonedDateTime;
import java.util.List;

public interface MessageBus {

    void initialize();

    void send(Message message);
    void sendToAllOnlineNodes(ClusterMessage message);
    void onMessageReceived(MessageType type, MessageHandler messageHandler);

    void acknowledgeMessageFailure(long messageId);
    void acknowledgeAllMessageFailures();

    List<StoredMessage> getAllFailedMessagesSince(ZonedDateTime since);
    List<StoredMessage> getAllStuckMessages(ZonedDateTime timeout);

    List<StoredMessage> getAllMessages(int limit, int offset);
    long getTotalMessageCount();

}
