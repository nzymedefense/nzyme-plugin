package app.nzyme.plugin.retro.l4.entries;

import com.google.auto.value.AutoValue;
import org.joda.time.DateTime;

@AutoValue
public abstract class L4RetroConnectionPairEntry {

    public abstract String tapName();
    public abstract String l4Type();
    public abstract String sourceMac();
    public abstract String destinationMac();
    public abstract String sourceAddress();
    public abstract String destinationAddress();
    public abstract String sourcePort();
    public abstract String destinationPort();
    public abstract Long connectionCount();
    public abstract Long size();
    public abstract DateTime timestamp();

    public static L4RetroConnectionPairEntry create(String tapName, String l4Type, String sourceMac, String destinationMac, String sourceAddress, String destinationAddress, String sourcePort, String destinationPort, Long connectionCount, Long size, DateTime timestamp) {
        return builder()
                .tapName(tapName)
                .l4Type(l4Type)
                .sourceMac(sourceMac)
                .destinationMac(destinationMac)
                .sourceAddress(sourceAddress)
                .destinationAddress(destinationAddress)
                .sourcePort(sourcePort)
                .destinationPort(destinationPort)
                .connectionCount(connectionCount)
                .size(size)
                .timestamp(timestamp)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_L4RetroConnectionPairEntry.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder tapName(String tapName);

        public abstract Builder l4Type(String l4Type);

        public abstract Builder sourceMac(String sourceMac);

        public abstract Builder destinationMac(String destinationMac);

        public abstract Builder sourceAddress(String sourceAddress);

        public abstract Builder destinationAddress(String destinationAddress);

        public abstract Builder sourcePort(String sourcePort);

        public abstract Builder destinationPort(String destinationPort);

        public abstract Builder connectionCount(Long connectionCount);

        public abstract Builder size(Long size);

        public abstract Builder timestamp(DateTime timestamp);

        public abstract L4RetroConnectionPairEntry build();
    }

}
