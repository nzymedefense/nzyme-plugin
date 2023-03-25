package app.nzyme.plugin.distributed.messaging;

import com.google.auto.value.AutoValue;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.UUID;

@AutoValue
public abstract class StoredMessage {

    public abstract Long id();
    public abstract UUID sender();
    public abstract UUID receiver();
    public abstract MessageType type();
    public abstract Map<String, Object> parameters();
    public abstract MessageStatus status();
    public abstract DateTime createdAt();

    @Nullable
    public abstract Long cycleLimiter();

    @Nullable
    public abstract DateTime acknowledgedAt();

    public static StoredMessage create(long id, UUID sender, UUID receiver, MessageType type, Map<String, Object> parameters, MessageStatus status, Long cycleLimiter, DateTime createdAt, DateTime acknowledgedAt) {
        return builder()
                .id(id)
                .sender(sender)
                .receiver(receiver)
                .type(type)
                .parameters(parameters)
                .status(status)
                .cycleLimiter(cycleLimiter)
                .createdAt(createdAt)
                .acknowledgedAt(acknowledgedAt)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_StoredMessage.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(long id);

        public abstract Builder sender(UUID sender);

        public abstract Builder receiver(UUID receiver);

        public abstract Builder type(MessageType type);

        public abstract Builder parameters(Map<String, Object> parameters);

        public abstract Builder status(MessageStatus status);

        public abstract Builder cycleLimiter(Long cycleLimiter);

        public abstract Builder createdAt(DateTime createdAt);

        public abstract Builder acknowledgedAt(DateTime acknowledgedAt);

        public abstract StoredMessage build();
    }

}
