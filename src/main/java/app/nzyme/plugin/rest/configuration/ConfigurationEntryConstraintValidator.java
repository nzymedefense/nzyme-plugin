package app.nzyme.plugin.rest.configuration;

import app.nzyme.plugin.RegistryKey;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ConfigurationEntryConstraintValidator {

    public static boolean checkConstraints(RegistryKey key, Map.Entry<String, Object> variable) {
        Optional<List<ConfigurationEntryConstraint>> constraints = key.constraints();
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
