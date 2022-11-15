package app.nzyme.plugin.rest.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ConfigurationEntryConstraint {

    enum ConstraintType {
        STRING_LENGTH,
        NUMBER_RANGE
    }

    @JsonProperty("type")
    public abstract ConstraintType type();

    @JsonProperty("data")
    public abstract Object data();

    public static ConfigurationEntryConstraint createStringLengthConstraint(int min, int max) {
        return builder()
                .type(ConstraintType.STRING_LENGTH)
                .data(StringLengthConstraint.create(min, max))
                .build();
    }

    public static ConfigurationEntryConstraint createNumberRangeConstraint(int min, int max) {
        return builder()
                .type(ConstraintType.NUMBER_RANGE)
                .data(NumberRangeConstraint.create(min, max))
                .build();
    }

    public static Builder builder() {
        return new AutoValue_ConfigurationEntryConstraint.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder type(ConstraintType type);

        public abstract Builder data(Object data);

        public abstract ConfigurationEntryConstraint build();
    }

}
