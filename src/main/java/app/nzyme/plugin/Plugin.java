package app.nzyme.plugin;

public interface Plugin {

    void initialize(PluginEntryPoint pluginEntryPoint,
                    Registry registry,
                    NodeIdProvider nodeIdProvider,
                    MetricsRegistryProvider metricsRegistryProvider
    );

    String getId();

    String getName();

}
