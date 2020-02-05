package com.drew.metadata.xmp;

import com.adobe.xmp.XMPException;
import com.adobe.xmp.XMPMetaFactory;
import com.adobe.xmp.options.SerializeOptions;
import com.drew.metadata.Metadata;
import java.io.OutputStream;

public class XmpWriter {
    public static boolean write(OutputStream outputStream, Metadata metadata) {
        XmpDirectory xmpDirectory = (XmpDirectory) metadata.getFirstDirectoryOfType(XmpDirectory.class);
        if (xmpDirectory == null) {
            return false;
        }
        try {
            XMPMetaFactory.serialize(xmpDirectory.getXMPMeta(), outputStream, new SerializeOptions().setOmitPacketWrapper(true));
            return true;
        } catch (XMPException e) {
            e.printStackTrace();
            return false;
        }
    }
}
