package app.nzyme.plugin.retro.l4;

import app.nzyme.plugin.retro.l4.entries.L4RetroConnectionPairEntry;

import java.util.List;

public interface L4RetroService {

    void handleL4ConnectionPairReport(List<L4RetroConnectionPairEntry> report);

}
