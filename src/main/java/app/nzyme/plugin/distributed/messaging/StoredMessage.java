package app.nzyme.plugin.distributed.messaging;

import com.google.auto.value.AutoValue;

import java.time.ZonedDateTime;
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
    public abstract ZonedDateTime createdAt();

    @Nullable
    public abstract Long cycleLimiter();

    @Nullable
    public abstract ZonedDateTime acknowledgedAt();

    @Nullable
    public abstract Integer processingTimeMs();

    public static StoredMessage create(Long id, UUID sender, UUID receiver, MessageType type, Map<String, Object> parameters, MessageStatus status, ZonedDateTime createdAt, Long cycleLimiter, ZonedDateTime acknowledgedAt, Integer processingTimeMs) {
        return builder()
                .id(id)
                .sender(sender)
                .receiver(receiver)
                .type(type)
                .parameters(parameters)
                .status(status)
                .createdAt(createdAt)
                .cycleLimiter(cycleLimiter)
                .acknowledgedAt(acknowledgedAt)
                .processingTimeMs(processingTimeMs)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_StoredMessage.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(Long id);

        public abstract Builder sender(UUID sender);

        public abstract Builder receiver(UUID receiver);

        public abstract Builder type(MessageType type);

        public abstract Builder parameters(Map<String, Object> parameters);

        public abstract Builder status(MessageStatus status);

        public abstract Builder createdAt(ZonedDateTime createdAt);

        public abstract Builder cycleLimiter(Long cycleLimiter);

        public abstract Builder acknowledgedAt(ZonedDateTime acknowledgedAt);

        public abstract Builder processingTimeMs(Integer processingTimeMs);

        public abstract StoredMessage build();
    }
    
}
