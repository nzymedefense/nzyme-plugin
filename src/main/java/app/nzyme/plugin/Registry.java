package app.nzyme.plugin;

import javax.annotation.Nullable;
import java.util.Optional;

public interface Registry {

    Optional<String> getValue(String key);

    @Nullable
    String getValueOrNull(String key);

    void setValue(String key, String value);

}
