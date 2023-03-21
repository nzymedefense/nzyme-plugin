package app.nzyme.plugin.distributed.messaging;

import com.google.auto.value.AutoValue;

import java.util.Map;
import java.util.UUID;

@AutoValue
public abstract class ReceivedMessage {

    public abstract UUID receiver();
    public abstract UUID sender();
    public abstract MessageType type();
    public abstract Map<String, Object> parametersMap();
    public abstract String parametersString();
    public abstract boolean limitToCurrentCycle();

    public static ReceivedMessage create(UUID receiver, UUID sender, MessageType type, Map<String, Object> parametersMap, String parametersString, boolean limitToCurrentCycle) {
        return builder()
                .receiver(receiver)
                .sender(sender)
                .type(type)
                .parametersMap(parametersMap)
                .parametersString(parametersString)
                .limitToCurrentCycle(limitToCurrentCycle)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_ReceivedMessage.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder receiver(UUID receiver);

        public abstract Builder sender(UUID sender);

        public abstract Builder type(MessageType type);

        public abstract Builder parametersMap(Map<String, Object> parametersMap);

        public abstract Builder parametersString(String parametersString);

        public abstract Builder limitToCurrentCycle(boolean limitToCurrentCycle);

        public abstract ReceivedMessage build();
    }
}
