package app.nzyme.plugin;

import com.codahale.metrics.MetricRegistry;

public interface MetricsRegistryProvider {

    MetricRegistry getMetrics();

}
