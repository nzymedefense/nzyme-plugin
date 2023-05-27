package app.nzyme.plugin.rest.configuration;

import app.nzyme.plugin.EncryptedRegistryKey;
import app.nzyme.plugin.RegistryKey;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ConfigurationEntryConstraintValidator {

    public static boolean checkConstraints(RegistryKey key, Map.Entry<String, Object> variable) {
        return checkConstraints(key.constraints(), variable);
    }

    public static boolean checkConstraints(EncryptedRegistryKey key, Map.Entry<String, Object> variable) {
        return checkConstraints(key.constraints(), variable);
    }

    private static boolean checkConstraints(Optional<List<ConfigurationEntryConstraint>> constraints, Map.Entry<String, Object> variable) {
        if (constraints.isPresent()) {
            for (ConfigurationEntryConstraint constraint : constraints.get()) {
                ConstraintValidationResult check = ConstraintValidator.validate(variable.getValue(), constraint);
                if (!check.isOk()) {
                    return false;
                }
            }
        }

        return true;
    }

}
