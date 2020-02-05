package io.sentry.marshaller.json;

import com.fasterxml.jackson.core.JsonGenerator;
import io.sentry.event.interfaces.SentryStackTraceElement;
import io.sentry.event.interfaces.StackTraceInterface;
import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.regex.Pattern;

public class StackTraceInterfaceBinding implements InterfaceBinding<StackTraceInterface> {
    private static final String ABSOLUTE_PATH_PARAMETER = "abs_path";
    private static final String COL_NO_PARAMETER = "colno";
    private static final String CONTEXT_LINE_PARAMETER = "context_line";
    private static final String FILENAME_PARAMETER = "filename";
    private static final String FRAMES_PARAMETER = "frames";
    private static final String FUNCTION_PARAMETER = "function";
    private static final Pattern IN_APP_BLACKLIST = Pattern.compile("\\$+(?:(?:(?:FastClass|Enhancer)[a-zA-Z]*CGLIB)|(?:HibernateProxy))\\$+");
    private static final String IN_APP_PARAMETER = "in_app";
    private static final String LINE_NO_PARAMETER = "lineno";
    private static final String MODULE_PARAMETER = "module";
    private static final String PLATFORM_PARAMTER = "platform";
    private static final String POST_CONTEXT_PARAMETER = "post_context";
    private static final String PRE_CONTEXT_PARAMETER = "pre_context";
    private static final String VARIABLES_PARAMETER = "vars";
    private Collection<String> inAppFrames = Collections.emptyList();
    private boolean removeCommonFramesWithEnclosing = true;

    private void writeFrame(JsonGenerator jsonGenerator, SentryStackTraceElement sentryStackTraceElement, boolean z) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField(FILENAME_PARAMETER, sentryStackTraceElement.getFileName());
        jsonGenerator.writeStringField(MODULE_PARAMETER, sentryStackTraceElement.getModule());
        jsonGenerator.writeBooleanField(IN_APP_PARAMETER, (!this.removeCommonFramesWithEnclosing || !z) && isFrameInApp(sentryStackTraceElement));
        jsonGenerator.writeStringField(FUNCTION_PARAMETER, sentryStackTraceElement.getFunction());
        jsonGenerator.writeNumberField(LINE_NO_PARAMETER, sentryStackTraceElement.getLineno());
        if (sentryStackTraceElement.getColno() != null) {
            jsonGenerator.writeNumberField(COL_NO_PARAMETER, sentryStackTraceElement.getColno().intValue());
        }
        if (sentryStackTraceElement.getPlatform() != null) {
            jsonGenerator.writeStringField("platform", sentryStackTraceElement.getPlatform());
        }
        if (sentryStackTraceElement.getAbsPath() != null) {
            jsonGenerator.writeStringField(ABSOLUTE_PATH_PARAMETER, sentryStackTraceElement.getAbsPath());
        }
        if (sentryStackTraceElement.getLocals() != null && !sentryStackTraceElement.getLocals().isEmpty()) {
            jsonGenerator.writeObjectFieldStart(VARIABLES_PARAMETER);
            for (Map.Entry next : sentryStackTraceElement.getLocals().entrySet()) {
                jsonGenerator.writeFieldName((String) next.getKey());
                jsonGenerator.writeObject(next.getValue());
            }
            jsonGenerator.writeEndObject();
        }
        jsonGenerator.writeEndObject();
    }

    private boolean isFrameInApp(SentryStackTraceElement sentryStackTraceElement) {
        String module = sentryStackTraceElement.getModule();
        if (classIsBlacklisted(module)) {
            return false;
        }
        for (String startsWith : this.inAppFrames) {
            if (module.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    private boolean classIsBlacklisted(String str) {
        return (str.contains("CGLIB") || str.contains("Hibernate")) && IN_APP_BLACKLIST.matcher(str).find();
    }

    public void writeInterface(JsonGenerator jsonGenerator, StackTraceInterface stackTraceInterface) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeArrayFieldStart(FRAMES_PARAMETER);
        SentryStackTraceElement[] stackTrace = stackTraceInterface.getStackTrace();
        int framesCommonWithEnclosing = stackTraceInterface.getFramesCommonWithEnclosing();
        int length = stackTrace.length - 1;
        while (length >= 0) {
            int i = framesCommonWithEnclosing - 1;
            writeFrame(jsonGenerator, stackTrace[length], framesCommonWithEnclosing > 0);
            length--;
            framesCommonWithEnclosing = i;
        }
        jsonGenerator.writeEndArray();
        jsonGenerator.writeEndObject();
    }

    public void setRemoveCommonFramesWithEnclosing(boolean z) {
        this.removeCommonFramesWithEnclosing = z;
    }

    public void setInAppFrames(Collection<String> collection) {
        this.inAppFrames = collection;
    }
}
