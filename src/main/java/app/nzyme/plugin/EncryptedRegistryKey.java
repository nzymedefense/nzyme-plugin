package app.nzyme.plugin;

import app.nzyme.plugin.rest.configuration.ConfigurationEntryConstraint;
import com.google.auto.value.AutoValue;

import java.util.List;
import java.util.Optional;

@AutoValue
public abstract class EncryptedRegistryKey {

    public abstract String key();
    public abstract Optional<List<ConfigurationEntryConstraint>> constraints();
    public abstract boolean requiresRestart();

    public static EncryptedRegistryKey create(String key, Optional<List<ConfigurationEntryConstraint>> constraints, boolean requiresRestart) {
        return builder()
                .key(key)
                .constraints(constraints)
                .requiresRestart(requiresRestart)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_EncryptedRegistryKey.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder key(String key);

        public abstract Builder constraints(Optional<List<ConfigurationEntryConstraint>> constraints);

        public abstract Builder requiresRestart(boolean requiresRestart);

        public abstract EncryptedRegistryKey build();
    }

}
