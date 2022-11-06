package app.nzyme.plugin.rest;

import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;

@AutoValue
public abstract class ConfigurationEntryResponse {

    public enum ValueType {
        STRING,
        NUMBER
    }

    public abstract String key();

    @Nullable
    public abstract Object value();

    @Nullable
    public abstract Object defaultValue();

    public abstract boolean requiresRestart();

    public static ConfigurationEntryResponse create(String key, Object value, Object defaultValue, boolean requiresRestart) {
        return builder()
                .key(key)
                .value(value)
                .defaultValue(defaultValue)
                .requiresRestart(requiresRestart)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_ConfigurationEntryResponse.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder key(String key);

        public abstract Builder value(Object value);

        public abstract Builder defaultValue(Object defaultValue);

        public abstract Builder requiresRestart(boolean requiresRestart);

        public abstract ConfigurationEntryResponse build();
    }
    
}
