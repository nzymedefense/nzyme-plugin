package app.nzyme.plugin;

import app.nzyme.plugin.rest.configuration.ConfigurationEntryConstraint;
import com.google.auto.value.AutoValue;

import java.util.List;
import java.util.Optional;

@AutoValue
public abstract class RegistryKey {

    public abstract String key();
    public abstract Optional<List<ConfigurationEntryConstraint>> constraints();
    public abstract Optional<String> defaultValue();
    public abstract boolean requiresRestart();

    public static RegistryKey create(String key, Optional<List<ConfigurationEntryConstraint>> constraints, Optional<String> defaultValue, boolean requiresRestart) {
        return builder()
                .key(key)
                .constraints(constraints)
                .defaultValue(defaultValue)
                .requiresRestart(requiresRestart)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_RegistryKey.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder key(String key);

        public abstract Builder constraints(Optional<List<ConfigurationEntryConstraint>> constraints);

        public abstract Builder defaultValue(Optional<String> defaultValue);

        public abstract Builder requiresRestart(boolean requiresRestart);

        public abstract RegistryKey build();
    }
    
}
