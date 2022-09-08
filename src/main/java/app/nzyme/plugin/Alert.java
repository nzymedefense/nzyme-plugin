package app.nzyme.plugin;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.joda.time.DateTime;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public abstract class Alert {

    public enum TYPE_WIDE {
        UNEXPECTED_BSSID,
        UNEXPECTED_SSID,
        CRYPTO_CHANGE,
        UNEXPECTED_CHANNEL,
        UNEXPECTED_FINGERPRINT,
        BEACON_RATE_ANOMALY,
        PROBE_RESPONSE_TRAP_1,
        MULTIPLE_SIGNAL_TRACKS,
        PWNAGOTCHI_ADVERTISEMENT,
        BANDIT_CONTACT,
        BEACON_TRAP_1,
        UNKNOWN_SSID,
        DEAUTH_FLOOD,
        PROBE_FAILURE
    }

    public enum TYPE {
        UNEXPECTED_BSSID_BEACON,
        UNEXPECTED_BSSID_PROBERESP,
        UNEXPECTED_SSID_BEACON,
        UNEXPECTED_SSID_PROBERESP,
        CRYPTO_CHANGE_BEACON,
        CRYPTO_CHANGE_PROBERESP,
        UNEXPECTED_CHANNEL_BEACON,
        UNEXPECTED_CHANNEL_PROBERESP,
        UNEXPECTED_FINGERPRINT_BEACON,
        UNEXPECTED_FINGERPRINT_PROBERESP,
        BEACON_RATE_ANOMALY,
        PROBE_RESPONSE_TRAP_1,
        MULTIPLE_SIGNAL_TRACKS,
        PWNAGOTCHI_ADVERTISEMENT,
        BANDIT_CONTACT,
        BEACON_TRAP_1,
        UNKNOWN_SSID,
        DEAUTH_FLOOD,
        PROBE_FAILURE
    }

    public static final List<TYPE_WIDE> HIDDEN_IN_UI = ImmutableList.of(
            TYPE_WIDE.PROBE_RESPONSE_TRAP_1,
            TYPE_WIDE.BEACON_TRAP_1,
            TYPE_WIDE.PROBE_FAILURE
    );

    private final Subsystem subsystem;
    private final Map<String, Object> fields;
    private final DateTime firstSeen;
    private final AtomicReference<DateTime> lastSeen;
    private final AtomicLong frameCount;
    private final boolean useFrameCount;
    private final ObjectMapper objectMapper;

    private final String description;
    private final String documentationLink;
    private final List<String> falsePositives;

    public abstract String getMessage();
    public abstract TYPE getType();
    public abstract boolean sameAs(Alert alert);

    protected UUID uuid;

    protected Alert(DateTime timestamp,
                    Subsystem subsystem,
                    Map<String, Object> fields,
                    String description,
                    String documentationLink,
                    List<String> falsePositives,
                    boolean useFrameCount,
                    long frameCount) {
        this.firstSeen = timestamp;
        this.lastSeen = new AtomicReference<>(timestamp);
        this.subsystem = subsystem;
        this.fields = ImmutableMap.copyOf(fields);
        this.description = description;
        this.documentationLink = documentationLink;
        this.falsePositives = falsePositives;
        this.useFrameCount = useFrameCount;

        this.frameCount = new AtomicLong(frameCount);

        this.objectMapper = new ObjectMapper();
    }

    public DateTime getFirstSeen() {
        return firstSeen;
    }

    public DateTime getLastSeen() {
        return lastSeen.get();
    }

    public void setLastSeen(DateTime timestamp) {
        this.lastSeen.set(timestamp);
    }

    public void incrementFrameCount() {
        this.frameCount.incrementAndGet();
    }

    @Nullable
    public Long getFrameCount() {
        return this.useFrameCount ? this.frameCount.get() : null;
    }

    public boolean isUseFrameCount() {
        return this.useFrameCount;
    }

    public Subsystem getSubsystem() {
        return subsystem;
    }

    public Map<String, Object> getFields() {
        return fields;
    }

    public String getDescription() {
        return description;
    }

    public String getDocumentationLink() {
        return documentationLink;
    }

    public List<String> getFalsePositives() {
        return falsePositives;
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public String toJSONString() throws JsonProcessingException {
        Map<String, Object> payload = Maps.newHashMap();

        payload.put("first_seen", getFirstSeen().toString());
        payload.put("last_seen", getLastSeen().toString());
        payload.put("frame_count", getFrameCount());
        payload.put("is_use_frame_count", isUseFrameCount());
        payload.put("message", getMessage());
        payload.put("type", getType());
        payload.put("subsystem", getSubsystem());
        payload.put("documentation_link", getDocumentationLink());
        payload.put("description", getDescription());
        payload.put("fields", getFields());
        payload.put("false_positives", getFalsePositives());

        return objectMapper.writeValueAsString(payload);
    }

}
