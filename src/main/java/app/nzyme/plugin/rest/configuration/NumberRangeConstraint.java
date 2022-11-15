package app.nzyme.plugin.rest.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class NumberRangeConstraint {

    @JsonProperty("min")
    public abstract int min();

    @JsonProperty("max")
    public abstract int max();

    public static NumberRangeConstraint create(int min, int max) {
        return builder()
                .min(min)
                .max(max)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_NumberRangeConstraint.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder min(int min);

        public abstract Builder max(int max);

        public abstract NumberRangeConstraint build();
    }

}
