package app.nzyme.plugin;

import app.nzyme.plugin.retro.RetroService;

public interface PluginEntryPoint {

    void registerRetroService(RetroService retroService);
    void registerRestResource(Object resource);

}
