package app.nzyme.plugin.rest.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class EnumStringsConstraint {

    @JsonProperty("strings")
    public abstract List<String> strings();

    public static EnumStringsConstraint create(List<String> strings) {
        return builder()
                .strings(strings)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_EnumStringsConstraint.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder strings(List<String> strings);

        public abstract EnumStringsConstraint build();
    }
}
