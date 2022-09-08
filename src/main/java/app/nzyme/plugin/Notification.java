package app.nzyme.plugin;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;

import java.util.Map;

public class Notification {

    private final ImmutableMap.Builder<String, Object> fields;
    private final String message;

    public Notification(String message, int channel) {
        this.fields = new ImmutableMap.Builder<>();
        this.message = message;

        addField("channel", channel);
    }

    public Notification addField(String key, Object value) {
        if(value == null) {
            return this;
        }

        fields.put(key, value);

        return this;
    }

    public Notification addFields(Map<String, Object> x) {
        if (x == null) {
            return this;
        }

        fields.putAll(x);

        return this;
    }

    public Map<String, Object> getAdditionalFields() {
        return fields.build();
    }

    public String getMessage() {
        return message;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("802.11 frame: ").append(message)
                .append(" - Details: ")
                .append(Joiner.on(", ").join(getAdditionalFields().entrySet()));

        return sb.toString();
    }

}

