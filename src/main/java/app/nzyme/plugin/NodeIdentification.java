package app.nzyme.plugin;

import com.google.auto.value.AutoValue;

import java.util.UUID;

@AutoValue
public abstract class NodeIdentification {

    public abstract UUID id();
    public abstract String name();

    public static NodeIdentification create(UUID id, String name) {
        return builder()
                .id(id)
                .name(name)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_NodeIdentification.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder id(UUID id);

        public abstract Builder name(String name);

        public abstract NodeIdentification build();
    }

}
