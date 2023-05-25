package app.nzyme.plugin.rest.configuration;

import com.google.auto.value.AutoValue;

import java.util.List;

@AutoValue
public abstract class EnumStringConstraint {

    public abstract List<String> strings();

    public static EnumStringConstraint create(List<String> strings) {
        return builder()
                .strings(strings)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_EnumStringConstraint.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder strings(List<String> strings);

        public abstract EnumStringConstraint build();
    }

}
