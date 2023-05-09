package app.nzyme.plugin;

public interface RegistryChangeMonitor {

    void onChange(String namespace, String key, Runnable runnable);

}
