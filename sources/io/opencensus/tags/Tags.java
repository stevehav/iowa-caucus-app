package io.opencensus.tags;

import io.opencensus.internal.Provider;
import io.opencensus.tags.propagation.TagPropagationComponent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;

public final class Tags {
    private static final Logger logger = Logger.getLogger(Tags.class.getName());
    private static final TagsComponent tagsComponent = loadTagsComponent(TagsComponent.class.getClassLoader());

    private Tags() {
    }

    public static Tagger getTagger() {
        return tagsComponent.getTagger();
    }

    public static TagPropagationComponent getTagPropagationComponent() {
        return tagsComponent.getTagPropagationComponent();
    }

    public static TaggingState getState() {
        return tagsComponent.getState();
    }

    @Deprecated
    public static void setState(TaggingState taggingState) {
        tagsComponent.setState(taggingState);
    }

    static TagsComponent loadTagsComponent(@Nullable ClassLoader classLoader) {
        try {
            return (TagsComponent) Provider.createInstance(Class.forName("io.opencensus.impl.tags.TagsComponentImpl", true, classLoader), TagsComponent.class);
        } catch (ClassNotFoundException e) {
            logger.log(Level.FINE, "Couldn't load full implementation for TagsComponent, now trying to load lite implementation.", e);
            try {
                return (TagsComponent) Provider.createInstance(Class.forName("io.opencensus.impllite.tags.TagsComponentImplLite", true, classLoader), TagsComponent.class);
            } catch (ClassNotFoundException e2) {
                logger.log(Level.FINE, "Couldn't load lite implementation for TagsComponent, now using default implementation for TagsComponent.", e2);
                return NoopTags.newNoopTagsComponent();
            }
        }
    }
}
