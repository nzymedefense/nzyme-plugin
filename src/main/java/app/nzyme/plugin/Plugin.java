package app.nzyme.plugin;

public interface Plugin {

    void initialize(PluginEntryPoint pluginEntryPoint, Registry registry, NodeIdProvider nodeIdProvider);

    String getId();

    String getName();

}
