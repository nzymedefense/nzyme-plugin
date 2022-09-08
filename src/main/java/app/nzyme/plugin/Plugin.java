package app.nzyme.plugin;

public interface Plugin {

    void initialize(PluginEntryPoint pluginEntryPoint);

    String getName();

}
