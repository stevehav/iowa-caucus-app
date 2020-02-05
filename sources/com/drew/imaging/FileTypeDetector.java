package com.drew.imaging;

import com.drew.lang.ByteTrie;
import com.drew.lang.annotations.NotNull;
import com.drew.metadata.avi.AviDirectory;
import com.drew.metadata.wav.WavDirectory;
import com.drew.metadata.webp.WebpDirectory;
import com.fasterxml.jackson.core.json.ByteSourceJsonBootstrapper;
import com.google.common.base.Ascii;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.util.HashMap;

public class FileTypeDetector {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final HashMap<String, FileType> _ftypMap = new HashMap<>();
    private static final ByteTrie<FileType> _root = new ByteTrie<>();

    static {
        _root.setDefaultValue(FileType.Unknown);
        _root.addPath(FileType.Jpeg, new byte[]{-1, -40});
        _root.addPath(FileType.Tiff, "II".getBytes(), new byte[]{42, 0});
        _root.addPath(FileType.Tiff, "MM".getBytes(), new byte[]{0, 42});
        _root.addPath(FileType.Psd, "8BPS".getBytes());
        _root.addPath(FileType.Png, new byte[]{-119, 80, 78, 71, Ascii.CR, 10, Ascii.SUB, 10, 0, 0, 0, Ascii.CR, 73, 72, 68, 82});
        _root.addPath(FileType.Bmp, "BM".getBytes());
        _root.addPath(FileType.Bmp, "BA".getBytes());
        _root.addPath(FileType.Bmp, "CI".getBytes());
        _root.addPath(FileType.Bmp, "CP".getBytes());
        _root.addPath(FileType.Bmp, "IC".getBytes());
        _root.addPath(FileType.Bmp, "PT".getBytes());
        _root.addPath(FileType.Gif, "GIF87a".getBytes());
        _root.addPath(FileType.Gif, "GIF89a".getBytes());
        _root.addPath(FileType.Ico, new byte[]{0, 0, 1, 0});
        _root.addPath(FileType.Pcx, new byte[]{10, 0, 1});
        _root.addPath(FileType.Pcx, new byte[]{10, 2, 1});
        _root.addPath(FileType.Pcx, new byte[]{10, 3, 1});
        _root.addPath(FileType.Pcx, new byte[]{10, 5, 1});
        _root.addPath(FileType.Riff, "RIFF".getBytes());
        _root.addPath(FileType.Arw, "II".getBytes(), new byte[]{42, 0, 8, 0});
        _root.addPath(FileType.Crw, "II".getBytes(), new byte[]{Ascii.SUB, 0, 0, 0}, "HEAPCCDR".getBytes());
        _root.addPath(FileType.Cr2, "II".getBytes(), new byte[]{42, 0, Ascii.DLE, 0, 0, 0, 67, 82});
        _root.addPath(FileType.Orf, "IIRO".getBytes(), new byte[]{8, 0});
        _root.addPath(FileType.Orf, "MMOR".getBytes(), new byte[]{0, 0});
        _root.addPath(FileType.Orf, "IIRS".getBytes(), new byte[]{8, 0});
        _root.addPath(FileType.Raf, "FUJIFILMCCD-RAW".getBytes());
        _root.addPath(FileType.Rw2, "II".getBytes(), new byte[]{85, 0});
        _root.addPath(FileType.Eps, "%!PS".getBytes());
        _root.addPath(FileType.Eps, new byte[]{-59, -48, -45, -58});
        _ftypMap.put("ftypmoov", FileType.Mov);
        _ftypMap.put("ftypwide", FileType.Mov);
        _ftypMap.put("ftypmdat", FileType.Mov);
        _ftypMap.put("ftypfree", FileType.Mov);
        _ftypMap.put("ftypqt  ", FileType.Mov);
        _ftypMap.put("ftypavc1", FileType.Mp4);
        _ftypMap.put("ftypiso2", FileType.Mp4);
        _ftypMap.put("ftypisom", FileType.Mp4);
        _ftypMap.put("ftypM4A ", FileType.Mp4);
        _ftypMap.put("ftypM4B ", FileType.Mp4);
        _ftypMap.put("ftypM4P ", FileType.Mp4);
        _ftypMap.put("ftypM4V ", FileType.Mp4);
        _ftypMap.put("ftypM4VH", FileType.Mp4);
        _ftypMap.put("ftypM4VP", FileType.Mp4);
        _ftypMap.put("ftypmmp4", FileType.Mp4);
        _ftypMap.put("ftypmp41", FileType.Mp4);
        _ftypMap.put("ftypmp42", FileType.Mp4);
        _ftypMap.put("ftypmp71", FileType.Mp4);
        _ftypMap.put("ftypMSNV", FileType.Mp4);
        _ftypMap.put("ftypNDAS", FileType.Mp4);
        _ftypMap.put("ftypNDSC", FileType.Mp4);
        _ftypMap.put("ftypNDSH", FileType.Mp4);
        _ftypMap.put("ftypNDSM", FileType.Mp4);
        _ftypMap.put("ftypNDSP", FileType.Mp4);
        _ftypMap.put("ftypNDSS", FileType.Mp4);
        _ftypMap.put("ftypNDXC", FileType.Mp4);
        _ftypMap.put("ftypNDXH", FileType.Mp4);
        _ftypMap.put("ftypNDXM", FileType.Mp4);
        _ftypMap.put("ftypNDXP", FileType.Mp4);
        _ftypMap.put("ftypNDXS", FileType.Mp4);
        _ftypMap.put("ftypmif1", FileType.Heif);
        _ftypMap.put("ftypmsf1", FileType.Heif);
        _ftypMap.put("ftypheic", FileType.Heif);
        _ftypMap.put("ftypheix", FileType.Heif);
        _ftypMap.put("ftyphevc", FileType.Heif);
        _ftypMap.put("ftyphevx", FileType.Heif);
        _root.addPath(FileType.Aac, new byte[]{-1, -15});
        _root.addPath(FileType.Aac, new byte[]{-1, -7});
        _root.addPath(FileType.Asf, new byte[]{48, 38, -78, 117, -114, 102, -49, 17, -90, -39, 0, -86, 0, 98, -50, 108});
        _root.addPath(FileType.Cfbf, new byte[]{-48, -49, 17, -32, -95, -79, Ascii.SUB, -31, 0});
        _root.addPath(FileType.Flv, new byte[]{70, 76, 86});
        _root.addPath(FileType.Indd, new byte[]{6, 6, -19, -11, -40, Ascii.GS, 70, -27, -67, 49, ByteSourceJsonBootstrapper.UTF8_BOM_1, -25, -2, 116, -73, Ascii.GS});
        _root.addPath(FileType.Mxf, new byte[]{6, Ascii.SO, 43, 52, 2, 5, 1, 1, Ascii.CR, 1, 2, 1, 1, 2});
        _root.addPath(FileType.Qxp, new byte[]{0, 0, 73, 73, 88, 80, 82, 51});
        _root.addPath(FileType.Qxp, new byte[]{0, 0, 77, 77, 88, 80, 82, 51});
        _root.addPath(FileType.Ram, new byte[]{114, 116, 115, 112, 58, 47, 47});
        _root.addPath(FileType.Rtf, new byte[]{123, 92, 114, 116, 102, 49});
        _root.addPath(FileType.Sit, new byte[]{83, 73, 84, 33, 0});
        _root.addPath(FileType.Sit, new byte[]{83, 116, 117, 102, 102, 73, 116, 32, 40, 99, 41, 49, 57, 57, 55, 45});
        _root.addPath(FileType.Sitx, new byte[]{83, 116, 117, 102, 102, 73, 116, 33});
        _root.addPath(FileType.Swf, "CWS".getBytes());
        _root.addPath(FileType.Swf, "FWS".getBytes());
        _root.addPath(FileType.Swf, "ZWS".getBytes());
        _root.addPath(FileType.Vob, new byte[]{0, 0, 1, -70});
        _root.addPath(FileType.Zip, "PK".getBytes());
    }

    private FileTypeDetector() throws Exception {
        throw new Exception("Not intended for instantiation");
    }

    @NotNull
    public static FileType detectFileType(@NotNull BufferedInputStream bufferedInputStream) throws IOException {
        if (bufferedInputStream.markSupported()) {
            int max = Math.max(16, _root.getMaxDepth());
            bufferedInputStream.mark(max);
            byte[] bArr = new byte[max];
            if (bufferedInputStream.read(bArr) != -1) {
                bufferedInputStream.reset();
                FileType find = _root.find(bArr);
                if (find == FileType.Unknown) {
                    FileType fileType = _ftypMap.get(new String(bArr, 4, 8));
                    if (fileType != null) {
                        return fileType;
                    }
                    return find;
                } else if (find != FileType.Riff) {
                    return find;
                } else {
                    String str = new String(bArr, 8, 4);
                    if (str.equals(WavDirectory.FORMAT)) {
                        return FileType.Wav;
                    }
                    if (str.equals(AviDirectory.FORMAT)) {
                        return FileType.Avi;
                    }
                    if (str.equals(WebpDirectory.FORMAT)) {
                        return FileType.WebP;
                    }
                    return find;
                }
            } else {
                throw new IOException("Stream ended before file's magic number could be determined.");
            }
        } else {
            throw new IOException("Stream must support mark/reset");
        }
    }
}
