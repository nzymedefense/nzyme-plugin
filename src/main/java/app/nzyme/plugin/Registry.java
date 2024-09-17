package app.nzyme.plugin;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.UUID;

public interface Registry {

    Optional<String> getValue(String key);

    Optional<String> getValue(String key, UUID organizationId, UUID tenantId);

    @Nullable
    String getValueOrNull(String key);

    @Nullable
    String getValueOrNull(String key, UUID organizationId, UUID tenantId);

    Optional<String> getEncryptedValue(String key) throws RegistryCryptoException;

    Optional<String> getEncryptedValue(String key, UUID organizationId, UUID tenantId) throws RegistryCryptoException;

    @Nullable
    String getEncryptedValueOrNull(String key) throws RegistryCryptoException;

    @Nullable
    String getEncryptedValueOrNull(String key, UUID organizationId, UUID tenantId) throws RegistryCryptoException;

    void setValue(String key, String value);

    void setValue(String key, String value, UUID organizationId, UUID tenantId);

    void setEncryptedValue(String key, String value) throws RegistryCryptoException;

    void setEncryptedValue(String key, String value, UUID organizationId, UUID tenantId) throws RegistryCryptoException;

    void deleteValue(String key);

    void deleteValue(String key, UUID organizationId, UUID tenantId);

}
