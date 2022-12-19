package app.nzyme.plugin;

import javax.annotation.Nullable;
import java.util.Optional;

public interface Registry {

    Optional<String> getValue(String key);

    @Nullable
    String getValueOrNull(String key);

    Optional<String> getEncryptedValue(String key) throws RegistryCryptoException;

    @Nullable
    String getEncryptedValueOrNull(String key) throws RegistryCryptoException;

    void setValue(String key, String value);

    void setEncryptedValue(String key, String value);

}
