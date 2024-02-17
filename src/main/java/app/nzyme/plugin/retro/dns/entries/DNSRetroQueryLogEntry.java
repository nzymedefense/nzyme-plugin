package app.nzyme.plugin.retro.dns.entries;

import com.google.auto.value.AutoValue;
import java.time.ZonedDateTime;

@AutoValue
public abstract class DNSRetroQueryLogEntry {

    public abstract String tapName();
    public abstract String ip();
    public abstract String server();
    public abstract String sourceMac();
    public abstract String destinationMac();
    public abstract Long port();
    public abstract String queryValue();
    public abstract String dataType();
    public abstract ZonedDateTime timestamp();

    public static DNSRetroQueryLogEntry create(String tapName, String ip, String server, String sourceMac, String destinationMac, Long port, String queryValue, String dataType, ZonedDateTime timestamp) {
        return builder()
                .tapName(tapName)
                .ip(ip)
                .server(server)
                .sourceMac(sourceMac)
                .destinationMac(destinationMac)
                .port(port)
                .queryValue(queryValue)
                .dataType(dataType)
                .timestamp(timestamp)
                .build();
    }

    public static Builder builder() {
        return new AutoValue_DNSRetroQueryLogEntry.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder tapName(String tapName);

        public abstract Builder ip(String ip);

        public abstract Builder server(String server);

        public abstract Builder sourceMac(String sourceMac);

        public abstract Builder destinationMac(String destinationMac);

        public abstract Builder port(Long port);

        public abstract Builder queryValue(String queryValue);

        public abstract Builder dataType(String dataType);

        public abstract Builder timestamp(ZonedDateTime timestamp);

        public abstract DNSRetroQueryLogEntry build();
    }

}
