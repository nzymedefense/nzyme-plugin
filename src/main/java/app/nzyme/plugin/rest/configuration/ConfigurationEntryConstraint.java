package app.nzyme.plugin.rest.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import javax.annotation.Nullable;
import java.util.List;

@AutoValue
public abstract class ConfigurationEntryConstraint {

    enum ConstraintType {
        STRING_LENGTH,
        NUMBER_RANGE,
        SIMPLE_BOOLEAN,
        ENUM_STRINGS,
        URI
    }

    @JsonProperty("type")
    public abstract ConstraintType type();

    @JsonProperty("data")
    @Nullable
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

    public static ConfigurationEntryConstraint createSimpleBooleanConstraint() {
        return builder()
                .type(ConstraintType.SIMPLE_BOOLEAN)
                .data(null)
                .build();
    }

    public static ConfigurationEntryConstraint createEnumStringsConstraint(List<String> enums) {
        return builder()
                .type(ConstraintType.ENUM_STRINGS)
                .data(EnumStringsConstraint.create(enums))
                .build();
    }


    public static ConfigurationEntryConstraint createHttpUrlConstraint() {
        return builder()
                .type(ConstraintType.URI)
                .data(null)
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
