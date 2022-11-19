package app.nzyme.plugin.rest.configuration;

import javax.annotation.Nullable;

public class ConstraintValidationResult {

    enum Result {
        OK, FAIL
    }

    private final Result result;

    @Nullable
    private final String reason;

    private ConstraintValidationResult(Result result, @Nullable String reason) {
        this.result = result;
        this.reason = reason;
    }

    public static ConstraintValidationResult ok() {
        return new ConstraintValidationResult(Result.OK, null);
    }

    public static ConstraintValidationResult fail(String reason) {
        return new ConstraintValidationResult(Result.FAIL, reason);
    }

    @Nullable
    public String getReason() {
        return reason;
    }

    public boolean isOk() {
        return this.result.equals(Result.OK);
    }

}
