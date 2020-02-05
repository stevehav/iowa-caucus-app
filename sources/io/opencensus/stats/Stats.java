package io.opencensus.stats;

import io.opencensus.internal.Provider;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class Stats {
    private static final Logger logger = Logger.getLogger(Stats.class.getName());
    private static final StatsComponent statsComponent = loadStatsComponent(StatsComponent.class.getClassLoader());

    public static StatsRecorder getStatsRecorder() {
        return statsComponent.getStatsRecorder();
    }

    public static ViewManager getViewManager() {
        return statsComponent.getViewManager();
    }

    public static StatsCollectionState getState() {
        return statsComponent.getState();
    }

    @Deprecated
    public static void setState(StatsCollectionState statsCollectionState) {
        statsComponent.setState(statsCollectionState);
    }

    static StatsComponent loadStatsComponent(@Nullable ClassLoader classLoader) {
        try {
            return (StatsComponent) Provider.createInstance(Class.forName("io.opencensus.impl.stats.StatsComponentImpl", true, classLoader), StatsComponent.class);
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Couldn't load full implementation for StatsComponent, now trying to load lite implementation.", e);
            try {
                return (StatsComponent) Provider.createInstance(Class.forName("io.opencensus.impllite.stats.StatsComponentImplLite", true, classLoader), StatsComponent.class);
            } catch (ClassNotFoundException e2) {
                logger.log(Level.FINE, "Couldn't load lite implementation for StatsComponent, now using default implementation for StatsComponent.", e2);
                return NoopStats.newNoopStatsComponent();
            }
        }
    }

    private Stats() {
    }
}
