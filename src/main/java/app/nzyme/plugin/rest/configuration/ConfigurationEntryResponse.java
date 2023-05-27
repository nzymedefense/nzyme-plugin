package app.nzyme.plugin.rest.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;
import java.util.List;

@AutoValue
public abstract class ConfigurationEntryResponse {

    @JsonProperty("key")
    public abstract String key();

    @JsonProperty("key_human_readable")
    public abstract String keyHumanReadable();

    @JsonProperty("value")
    @Nullable
    public abstract Object value();

    @JsonProperty("value_type")
    @Nullable
    public abstract ConfigurationEntryValueType valueType();

    @JsonProperty("default_value")
    @Nullable
    public abstract Object defaultValue();

    @JsonProperty("enum_values")
    @Nullable
    public abstract List<Object> enumValues();

    @JsonProperty("requires_restart")
    public abstract Boolean requiresRestart();

    @JsonProperty("constraints")
    public abstract List<ConfigurationEntryConstraint> constraints();

    @JsonProperty("help_tag")
    @Nullable
    public abstract String helpTag();

    public static ConfigurationEntryResponse create(String key, String keyHumanReadable, Object value, ConfigurationEntryValueType valueType, Object defaultValue, List<Object> enumValues, Boolean requiresRestart, List<ConfigurationEntryConstraint> constraints, String helpTag) {
        return builder()
                .key(key)
                .keyHumanReadable(keyHumanReadable)
                .value(value)
                .valueType(valueType)
                .defaultValue(defaultValue)
                .enumValues(enumValues)
                .requiresRestart(requiresRestart)
                .constraints(constraints)
                .helpTag(helpTag)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_ConfigurationEntryResponse.Builder();
    }
    
    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder key(String key);

        public abstract Builder keyHumanReadable(String keyHumanReadable);

        public abstract Builder value(Object value);

        public abstract Builder valueType(ConfigurationEntryValueType valueType);

        public abstract Builder defaultValue(Object defaultValue);

        public abstract Builder enumValues(List<Object> enumValues);

        public abstract Builder requiresRestart(Boolean requiresRestart);

        public abstract Builder constraints(List<ConfigurationEntryConstraint> constraints);

        public abstract Builder helpTag(String helpTag);

        public abstract ConfigurationEntryResponse build();
    }
}
