package app.nzyme.plugin.retro.dns;

import app.nzyme.plugin.retro.dns.entries.DNSRetroQueryLogEntry;
import app.nzyme.plugin.retro.dns.entries.DNSRetroResponseLogEntry;

import java.util.List;

public interface DNSRetroService {

    void handleQueryLogReport(List<DNSRetroQueryLogEntry> report);
    void handleResponseLogReport(List<DNSRetroResponseLogEntry> report);

}
