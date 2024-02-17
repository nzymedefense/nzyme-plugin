package app.nzyme.plugin.retro.l4.entries;

import com.google.auto.value.AutoValue;
import java.time.ZonedDateTime;

@AutoValue
public abstract class L4RetroConnectionPairEntry {

    public abstract String tapName();
    public abstract String l4Type();
    public abstract String sourceMac();
    public abstract String destinationMac();
    public abstract String sourceAddress();
    public abstract String destinationAddress();
    public abstract Integer sourcePort();
    public abstract Integer destinationPort();
    public abstract Long connectionCount();
    public abstract Long size();
    public abstract ZonedDateTime timestamp();

    public static L4RetroConnectionPairEntry create(String tapName, String l4Type, String sourceMac, String destinationMac, String sourceAddress, String destinationAddress, Integer sourcePort, Integer destinationPort, Long connectionCount, Long size, ZonedDateTime timestamp) {
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

        public abstract Builder sourcePort(Integer sourcePort);

        public abstract Builder destinationPort(Integer destinationPort);

        public abstract Builder connectionCount(Long connectionCount);

        public abstract Builder size(Long size);

        public abstract Builder timestamp(ZonedDateTime timestamp);

        public abstract L4RetroConnectionPairEntry build();
    }
    
}
