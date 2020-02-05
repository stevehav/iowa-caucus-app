package io.opencensus.stats;

import io.opencensus.stats.View;
import io.opencensus.tags.TagKey;
import java.util.List;
import javax.annotation.concurrent.Immutable;

@Immutable
final class AutoValue_View extends View {
    private final Aggregation aggregation;
    private final List<TagKey> columns;
    private final String description;
    private final Measure measure;
    private final View.Name name;
    private final View.AggregationWindow window;

    AutoValue_View(View.Name name2, String str, Measure measure2, Aggregation aggregation2, List<TagKey> list, View.AggregationWindow aggregationWindow) {
        if (name2 != null) {
            this.name = name2;
            if (str != null) {
                this.description = str;
                if (measure2 != null) {
                    this.measure = measure2;
                    if (aggregation2 != null) {
                        this.aggregation = aggregation2;
                        if (list != null) {
                            this.columns = list;
                            if (aggregationWindow != null) {
                                this.window = aggregationWindow;
                                return;
                            }
                            throw new NullPointerException("Null window");
                        }
                        throw new NullPointerException("Null columns");
                    }
                    throw new NullPointerException("Null aggregation");
                }
                throw new NullPointerException("Null measure");
            }
            throw new NullPointerException("Null description");
        }
        throw new NullPointerException("Null name");
    }

    public View.Name getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Measure getMeasure() {
        return this.measure;
    }

    public Aggregation getAggregation() {
        return this.aggregation;
    }

    public List<TagKey> getColumns() {
        return this.columns;
    }

    @Deprecated
    public View.AggregationWindow getWindow() {
        return this.window;
    }

    public String toString() {
        return "View{name=" + this.name + ", description=" + this.description + ", measure=" + this.measure + ", aggregation=" + this.aggregation + ", columns=" + this.columns + ", window=" + this.window + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof View)) {
            return false;
        }
        View view = (View) obj;
        if (!this.name.equals(view.getName()) || !this.description.equals(view.getDescription()) || !this.measure.equals(view.getMeasure()) || !this.aggregation.equals(view.getAggregation()) || !this.columns.equals(view.getColumns()) || !this.window.equals(view.getWindow())) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((((((this.name.hashCode() ^ 1000003) * 1000003) ^ this.description.hashCode()) * 1000003) ^ this.measure.hashCode()) * 1000003) ^ this.aggregation.hashCode()) * 1000003) ^ this.columns.hashCode()) * 1000003) ^ this.window.hashCode();
    }
}
