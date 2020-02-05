package io.opencensus.stats;

import io.opencensus.stats.View;
import java.util.Set;
import javax.annotation.Nullable;

public abstract class ViewManager {
    public abstract Set<View> getAllExportedViews();

    @Nullable
    public abstract ViewData getView(View.Name name);

    public abstract void registerView(View view);
}
