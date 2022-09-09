package app.nzyme.plugin;

import java.util.Optional;

public interface Registry {

    Optional<String> getValue(String key);
    void setValue(String key, String value);

}
