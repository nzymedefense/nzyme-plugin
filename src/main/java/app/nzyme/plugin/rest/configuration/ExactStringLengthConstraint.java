package app.nzyme.plugin.rest.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

@AutoValue
public abstract class ExactStringLengthConstraint {

    @JsonProperty("length")
    public abstract int length();

    public static ExactStringLengthConstraint create(int length) {
        return builder()
                .length(length)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_ExactStringLengthConstraint.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder length(int length);

        public abstract ExactStringLengthConstraint build();
    }

}
