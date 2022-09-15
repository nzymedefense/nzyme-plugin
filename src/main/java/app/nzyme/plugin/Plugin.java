package app.nzyme.plugin;

public interface Plugin {

    void initialize(PluginEntryPoint pluginEntryPoint, Registry registry);

    String getId();

    String getName();

}
