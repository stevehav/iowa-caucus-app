package com.drew.metadata.xmp;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPIterator;
import com.adobe.xmp.XMPMeta;
import com.adobe.xmp.impl.XMPMetaImpl;
import com.adobe.xmp.properties.XMPPropertyInfo;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Directory;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class XmpDirectory extends Directory {
    public static final int TAG_XMP_VALUE_COUNT = 65535;
    @NotNull
    protected static final HashMap<Integer, String> _tagNameMap = new HashMap<>();
    @Nullable
    private XMPMeta _xmpMeta;

    @NotNull
    public String getName() {
        return "XMP";
    }

    static {
        _tagNameMap.put(65535, "XMP Value Count");
    }

    public XmpDirectory() {
        setDescriptor(new XmpDescriptor(this));
    }

    /* access modifiers changed from: protected */
    @NotNull
    public HashMap<Integer, String> getTagNameMap() {
        return _tagNameMap;
    }

    @NotNull
    public Map<String, String> getXmpProperties() {
        HashMap hashMap = new HashMap();
        XMPMeta xMPMeta = this._xmpMeta;
        if (xMPMeta != null) {
            try {
                XMPIterator it = xMPMeta.iterator();
                while (it.hasNext()) {
                    XMPPropertyInfo xMPPropertyInfo = (XMPPropertyInfo) it.next();
                    String path = xMPPropertyInfo.getPath();
                    String value = xMPPropertyInfo.getValue();
                    if (!(path == null || value == null)) {
                        hashMap.put(path, value);
                    }
                }
            } catch (XMPException unused) {
            }
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public void setXMPMeta(@NotNull XMPMeta xMPMeta) {
        this._xmpMeta = xMPMeta;
        int i = 0;
        try {
            XMPIterator it = this._xmpMeta.iterator();
            while (it.hasNext()) {
                if (((XMPPropertyInfo) it.next()).getPath() != null) {
                    i++;
                }
            }
            setInt(65535, i);
        } catch (XMPException unused) {
        }
    }

    @NotNull
    public XMPMeta getXMPMeta() {
        if (this._xmpMeta == null) {
            this._xmpMeta = new XMPMetaImpl();
        }
        return this._xmpMeta;
    }
}
