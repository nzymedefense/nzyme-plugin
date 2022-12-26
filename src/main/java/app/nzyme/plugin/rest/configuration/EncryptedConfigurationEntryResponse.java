package app.nzyme.plugin.rest.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;
import java.util.List;

@AutoValue
public abstract class EncryptedConfigurationEntryResponse {

    @JsonProperty("key")
    public abstract String key();

    @JsonProperty("key_human_readable")
    public abstract String keyHumanReadable();

    @JsonProperty("value_is_set")
    @Nullable
    public abstract Boolean valueIsSet();

    @JsonProperty("value_type")
    @Nullable
    public abstract ConfigurationEntryValueType valueType();

    @JsonProperty("requires_restart")
    public abstract Boolean requiresRestart();

    @JsonProperty("constraints")
    public abstract List<ConfigurationEntryConstraint> constraints();

    @JsonProperty("help_tag")
    @Nullable
    public abstract String helpTag();

    public static EncryptedConfigurationEntryResponse create(String key, String keyHumanReadable, Boolean valueIsSet, ConfigurationEntryValueType valueType, Boolean requiresRestart, List<ConfigurationEntryConstraint> constraints, String helpTag) {
        return builder()
                .key(key)
                .keyHumanReadable(keyHumanReadable)
                .valueIsSet(valueIsSet)
                .valueType(valueType)
                .requiresRestart(requiresRestart)
                .constraints(constraints)
                .helpTag(helpTag)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_EncryptedConfigurationEntryResponse.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder key(String key);

        public abstract Builder keyHumanReadable(String keyHumanReadable);

        public abstract Builder valueIsSet(Boolean valueIsSet);

        public abstract Builder valueType(ConfigurationEntryValueType valueType);

        public abstract Builder requiresRestart(Boolean requiresRestart);

        public abstract Builder constraints(List<ConfigurationEntryConstraint> constraints);

        public abstract Builder helpTag(String helpTag);

        public abstract EncryptedConfigurationEntryResponse build();
    }

}
