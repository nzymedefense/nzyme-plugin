package app.nzyme.plugin.retro.dns.rest;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.auto.value.AutoValue;
import org.joda.time.DateTime;

@AutoValue
public abstract class DNSRetroResponseLogReport {

    public abstract String ip();
    public abstract String server();
    public abstract String sourceMac();
    public abstract String destinationMac();
    public abstract String responseValue();
    public abstract String dataType();
    public abstract DateTime timestamp();

    @JsonCreator
    public static DNSRetroResponseLogReport create(@JsonProperty("ip") String ip,
                                             @JsonProperty("server") String server,
                                             @JsonProperty("source_mac") String sourceMac,
                                             @JsonProperty("destination_mac") String destinationMac,
                                             @JsonProperty("response_value") String responseValue,
                                             @JsonProperty("data_type") String dataType,
                                             @JsonProperty("timestamp") DateTime timestamp) {
        return builder()
                .ip(ip)
                .server(server)
                .sourceMac(sourceMac)
                .destinationMac(destinationMac)
                .responseValue(responseValue)
                .dataType(dataType)
                .timestamp(timestamp)
                .build();
    }
    public static Builder builder() {
        return new AutoValue_DNSRetroResponseLogReport.Builder();
    }

    @AutoValue.Builder
    public abstract static class Builder {
        public abstract Builder ip(String ip);

        public abstract Builder server(String server);

        public abstract Builder sourceMac(String sourceMac);

        public abstract Builder destinationMac(String destinationMac);

        public abstract Builder responseValue(String responseValue);

        public abstract Builder dataType(String dataType);

        public abstract Builder timestamp(DateTime timestamp);

        public abstract DNSRetroResponseLogReport build();
    }
}
