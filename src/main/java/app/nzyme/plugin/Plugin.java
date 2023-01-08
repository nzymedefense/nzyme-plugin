package app.nzyme.plugin;

public interface Plugin {

    void initialize(PluginEntryPoint pluginEntryPoint,
                    Registry registry,
                    NodeIdentificationProvider nodeIdentificationProvider,
                    MetricsRegistryProvider metricsRegistryProvider
    );

    String getId();

    String getName();

}
