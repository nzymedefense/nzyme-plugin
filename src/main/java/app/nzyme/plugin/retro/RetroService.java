package app.nzyme.plugin.retro;

import app.nzyme.plugin.retro.dns.DNSRetroService;
import app.nzyme.plugin.retro.l4.L4RetroService;

public interface RetroService {

    DNSRetroService dns();

    L4RetroService l4();

}
