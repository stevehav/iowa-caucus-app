package io.sentry.event.helper;

import io.sentry.SentryClient;
import io.sentry.context.Context;
import io.sentry.event.Breadcrumb;
import io.sentry.event.EventBuilder;
import io.sentry.event.User;
import io.sentry.event.interfaces.UserInterface;
import java.util.List;
import java.util.Map;

public class ContextBuilderHelper implements EventBuilderHelper {
    private SentryClient sentryClient;

    public ContextBuilderHelper(SentryClient sentryClient2) {
        this.sentryClient = sentryClient2;
    }

    public void helpBuildingEvent(EventBuilder eventBuilder) {
        Context context = this.sentryClient.getContext();
        List<Breadcrumb> breadcrumbs = context.getBreadcrumbs();
        if (!breadcrumbs.isEmpty()) {
            eventBuilder.withBreadcrumbs(breadcrumbs);
        }
        if (context.getHttp() != null) {
            eventBuilder.withSentryInterface(context.getHttp());
        }
        if (context.getUser() != null) {
            eventBuilder.withSentryInterface(fromUser(context.getUser()));
        }
        Map<String, String> tags = context.getTags();
        if (!tags.isEmpty()) {
            for (Map.Entry next : tags.entrySet()) {
                eventBuilder.withTag((String) next.getKey(), (String) next.getValue());
            }
        }
        Map<String, Object> extra = context.getExtra();
        if (!extra.isEmpty()) {
            for (Map.Entry next2 : extra.entrySet()) {
                eventBuilder.withExtra((String) next2.getKey(), next2.getValue());
            }
        }
    }

    private UserInterface fromUser(User user) {
        return new UserInterface(user.getId(), user.getUsername(), user.getIpAddress(), user.getEmail(), user.getData());
    }
}
