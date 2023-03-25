package app.nzyme.plugin.distributed.messaging;

import java.util.List;

public interface MessageBus {

    void initialize();

    void send(Message message);
    void sendToAllOnlineNodes(ClusterMessage message);
    void onMessageReceived(MessageType type, MessageHandler messageHandler);

    List<ReceivedMessage> getAllMessages(int limit, int offset);

}
