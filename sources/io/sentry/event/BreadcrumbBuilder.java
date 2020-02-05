package io.sentry.event;

import io.sentry.event.Breadcrumb;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BreadcrumbBuilder {
    private String category;
    private Map<String, String> data;
    private Breadcrumb.Level level;
    private String message;
    private Date timestamp;
    private Breadcrumb.Type type;

    public BreadcrumbBuilder setType(Breadcrumb.Type type2) {
        this.type = type2;
        return this;
    }

    public BreadcrumbBuilder setTimestamp(Date date) {
        this.timestamp = new Date(date.getTime());
        return this;
    }

    public BreadcrumbBuilder setLevel(Breadcrumb.Level level2) {
        this.level = level2;
        return this;
    }

    public BreadcrumbBuilder setMessage(String str) {
        this.message = str;
        return this;
    }

    public BreadcrumbBuilder setCategory(String str) {
        this.category = str;
        return this;
    }

    public BreadcrumbBuilder setData(Map<String, String> map) {
        this.data = map;
        return this;
    }

    public BreadcrumbBuilder withData(String str, String str2) {
        if (this.data == null) {
            this.data = new HashMap();
        }
        this.data.put(str, str2);
        return this;
    }

    public Breadcrumb build() {
        return new Breadcrumb(this.type, this.timestamp, this.level, this.message, this.category, this.data);
    }
}
