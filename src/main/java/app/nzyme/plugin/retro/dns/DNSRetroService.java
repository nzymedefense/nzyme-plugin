package app.nzyme.plugin.retro.dns;

import app.nzyme.plugin.retro.dns.rest.DNSRetroQueryLogReport;
import app.nzyme.plugin.retro.dns.rest.DNSRetroResponseLogReport;

import java.util.List;

public interface DNSRetroService {

    void handleQueryLogReport(List<DNSRetroQueryLogReport> report);
    void handleResponseLogReport(List<DNSRetroResponseLogReport> report);

}
