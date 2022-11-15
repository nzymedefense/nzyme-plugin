package app.nzyme.plugin.rest;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ConfigurationEntryConstraint {

    enum ConstraintType {
        STRING_LENGTH,
        NUMBER_RANGE
    }

    public abstract ConstraintType type();
    public abstract Object data();

    public static ConfigurationEntryConstraint create(ConstraintType type, Object data) {
        return builder()
                .type(type)
                .data(data)
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
