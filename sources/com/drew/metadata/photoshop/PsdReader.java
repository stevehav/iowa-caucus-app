package com.drew.metadata.photoshop;

public class PsdReader {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void extract(@com.drew.lang.annotations.NotNull com.drew.lang.SequentialReader r7, @com.drew.lang.annotations.NotNull com.drew.metadata.Metadata r8) {
        /*
            r6 = this;
            com.drew.metadata.photoshop.PsdHeaderDirectory r0 = new com.drew.metadata.photoshop.PsdHeaderDirectory
            r0.<init>()
            r8.addDirectory(r0)
            int r1 = r7.getInt32()     // Catch:{ IOException -> 0x0067 }
            r2 = 943870035(0x38425053, float:4.6328012E-5)
            if (r1 == r2) goto L_0x0017
            java.lang.String r7 = "Invalid PSD file signature"
            r0.addError(r7)     // Catch:{ IOException -> 0x0067 }
            return
        L_0x0017:
            int r1 = r7.getUInt16()     // Catch:{ IOException -> 0x0067 }
            r2 = 2
            r3 = 1
            if (r1 == r3) goto L_0x0027
            if (r1 == r2) goto L_0x0027
            java.lang.String r7 = "Invalid PSD file version (must be 1 or 2)"
            r0.addError(r7)     // Catch:{ IOException -> 0x0067 }
            return
        L_0x0027:
            r4 = 6
            r7.skip(r4)     // Catch:{ IOException -> 0x0067 }
            int r1 = r7.getUInt16()     // Catch:{ IOException -> 0x0067 }
            r0.setInt(r3, r1)     // Catch:{ IOException -> 0x0067 }
            int r1 = r7.getInt32()     // Catch:{ IOException -> 0x0067 }
            r0.setInt(r2, r1)     // Catch:{ IOException -> 0x0067 }
            int r1 = r7.getInt32()     // Catch:{ IOException -> 0x0067 }
            r2 = 3
            r0.setInt(r2, r1)     // Catch:{ IOException -> 0x0067 }
            int r1 = r7.getUInt16()     // Catch:{ IOException -> 0x0067 }
            r2 = 4
            r0.setInt(r2, r1)     // Catch:{ IOException -> 0x0067 }
            int r1 = r7.getUInt16()     // Catch:{ IOException -> 0x0067 }
            r2 = 5
            r0.setInt(r2, r1)     // Catch:{ IOException -> 0x0067 }
            long r0 = r7.getUInt32()     // Catch:{ IOException -> 0x0066 }
            r7.skip(r0)     // Catch:{ IOException -> 0x0066 }
            long r0 = r7.getUInt32()     // Catch:{  }
            com.drew.metadata.photoshop.PhotoshopReader r2 = new com.drew.metadata.photoshop.PhotoshopReader     // Catch:{  }
            r2.<init>()     // Catch:{  }
            int r1 = (int) r0     // Catch:{  }
            r2.extract(r7, r1, r8)     // Catch:{  }
        L_0x0066:
            return
        L_0x0067:
            java.lang.String r7 = "Unable to read PSD header"
            r0.addError(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.drew.metadata.photoshop.PsdReader.extract(com.drew.lang.SequentialReader, com.drew.metadata.Metadata):void");
    }
}
