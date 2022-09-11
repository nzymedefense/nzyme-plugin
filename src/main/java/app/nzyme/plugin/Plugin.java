package app.nzyme.plugin;

public interface Plugin {

    void initialize(PluginEntryPoint pluginEntryPoint, RegistryProvider registryProvider);

    String getName();

}
