package com.drew.metadata.exif;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.tiff.TiffProcessingException;
import com.drew.imaging.tiff.TiffReader;
import com.drew.lang.BufferBoundsException;
import com.drew.lang.Charsets;
import com.drew.lang.RandomAccessReader;
import com.drew.lang.SequentialByteArrayReader;
import com.drew.lang.annotations.NotNull;
import com.drew.lang.annotations.Nullable;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import com.drew.metadata.exif.makernotes.AppleMakernoteDirectory;
import com.drew.metadata.exif.makernotes.CanonMakernoteDirectory;
import com.drew.metadata.exif.makernotes.CasioType1MakernoteDirectory;
import com.drew.metadata.exif.makernotes.CasioType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.FujifilmMakernoteDirectory;
import com.drew.metadata.exif.makernotes.KodakMakernoteDirectory;
import com.drew.metadata.exif.makernotes.KyoceraMakernoteDirectory;
import com.drew.metadata.exif.makernotes.LeicaMakernoteDirectory;
import com.drew.metadata.exif.makernotes.LeicaType5MakernoteDirectory;
import com.drew.metadata.exif.makernotes.NikonType1MakernoteDirectory;
import com.drew.metadata.exif.makernotes.NikonType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusCameraSettingsMakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusEquipmentMakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusFocusInfoMakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusImageProcessingMakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusMakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusRawDevelopment2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusRawDevelopmentMakernoteDirectory;
import com.drew.metadata.exif.makernotes.OlympusRawInfoMakernoteDirectory;
import com.drew.metadata.exif.makernotes.PanasonicMakernoteDirectory;
import com.drew.metadata.exif.makernotes.PentaxMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxHyperFireMakernoteDirectory;
import com.drew.metadata.exif.makernotes.ReconyxUltraFireMakernoteDirectory;
import com.drew.metadata.exif.makernotes.RicohMakernoteDirectory;
import com.drew.metadata.exif.makernotes.SamsungType2MakernoteDirectory;
import com.drew.metadata.exif.makernotes.SanyoMakernoteDirectory;
import com.drew.metadata.exif.makernotes.SigmaMakernoteDirectory;
import com.drew.metadata.exif.makernotes.SonyType1MakernoteDirectory;
import com.drew.metadata.exif.makernotes.SonyType6MakernoteDirectory;
import com.drew.metadata.iptc.IptcReader;
import com.drew.metadata.tiff.DirectoryTiffHandler;
import com.drew.metadata.xmp.XmpReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Set;

public class ExifTiffHandler extends DirectoryTiffHandler {
    static final /* synthetic */ boolean $assertionsDisabled = false;

    public ExifTiffHandler(@NotNull Metadata metadata, @Nullable Directory directory) {
        super(metadata, directory);
    }

    public void setTiffMarker(int i) throws TiffProcessingException {
        if (i != 42) {
            if (i == 85) {
                pushDirectory(PanasonicRawIFD0Directory.class);
                return;
            } else if (!(i == 20306 || i == 21330)) {
                throw new TiffProcessingException(String.format("Unexpected TIFF marker: 0x%X", new Object[]{Integer.valueOf(i)}));
            }
        }
        pushDirectory(ExifIFD0Directory.class);
    }

    public boolean tryEnterSubIfd(int i) {
        if (i == 330) {
            pushDirectory(ExifSubIFDDirectory.class);
            return true;
        }
        if ((this._currentDirectory instanceof ExifIFD0Directory) || (this._currentDirectory instanceof PanasonicRawIFD0Directory)) {
            if (i == 34665) {
                pushDirectory(ExifSubIFDDirectory.class);
                return true;
            } else if (i == 34853) {
                pushDirectory(GpsDirectory.class);
                return true;
            }
        }
        if ((this._currentDirectory instanceof ExifSubIFDDirectory) && i == 40965) {
            pushDirectory(ExifInteropDirectory.class);
            return true;
        } else if (!(this._currentDirectory instanceof OlympusMakernoteDirectory)) {
            return false;
        } else {
            if (i == 8208) {
                pushDirectory(OlympusEquipmentMakernoteDirectory.class);
                return true;
            } else if (i == 8224) {
                pushDirectory(OlympusCameraSettingsMakernoteDirectory.class);
                return true;
            } else if (i == 8256) {
                pushDirectory(OlympusImageProcessingMakernoteDirectory.class);
                return true;
            } else if (i == 8272) {
                pushDirectory(OlympusFocusInfoMakernoteDirectory.class);
                return true;
            } else if (i == 12288) {
                pushDirectory(OlympusRawInfoMakernoteDirectory.class);
                return true;
            } else if (i == 16384) {
                pushDirectory(OlympusMakernoteDirectory.class);
                return true;
            } else if (i == 8240) {
                pushDirectory(OlympusRawDevelopmentMakernoteDirectory.class);
                return true;
            } else if (i != 8241) {
                return false;
            } else {
                pushDirectory(OlympusRawDevelopment2MakernoteDirectory.class);
                return true;
            }
        }
    }

    public boolean hasFollowerIfd() {
        if ((this._currentDirectory instanceof ExifIFD0Directory) || (this._currentDirectory instanceof ExifImageDirectory)) {
            if (this._currentDirectory.containsTag(ExifDirectoryBase.TAG_PAGE_NUMBER)) {
                pushDirectory(ExifImageDirectory.class);
            } else {
                pushDirectory(ExifThumbnailDirectory.class);
            }
            return true;
        } else if (this._currentDirectory instanceof ExifThumbnailDirectory) {
            return true;
        } else {
            return false;
        }
    }

    @Nullable
    public Long tryCustomProcessFormat(int i, int i2, long j) {
        if (i2 == 13) {
            return Long.valueOf(j * 4);
        }
        return i2 == 0 ? 0L : null;
    }

    public boolean customProcessTag(int i, @NotNull Set<Integer> set, int i2, @NotNull RandomAccessReader randomAccessReader, int i3, int i4) throws IOException {
        int i5 = i;
        Set<Integer> set2 = set;
        int i6 = i2;
        RandomAccessReader randomAccessReader2 = randomAccessReader;
        int i7 = i3;
        int i8 = i4;
        if (i7 == 0) {
            if (this._currentDirectory.containsTag(i3)) {
                return false;
            }
            if (i8 == 0) {
                return true;
            }
        }
        if (i7 == 37500 && (this._currentDirectory instanceof ExifSubIFDDirectory)) {
            return processMakernote(i, set, i2, randomAccessReader);
        }
        if (i7 != 33723 || !(this._currentDirectory instanceof ExifIFD0Directory)) {
            if (i7 == 700 && (this._currentDirectory instanceof ExifIFD0Directory)) {
                new XmpReader().extract(randomAccessReader.getNullTerminatedBytes(i, i8), this._metadata, this._currentDirectory);
                return true;
            } else if (handlePrintIM(this._currentDirectory, i3)) {
                PrintIMDirectory printIMDirectory = new PrintIMDirectory();
                printIMDirectory.setParent(this._currentDirectory);
                this._metadata.addDirectory(printIMDirectory);
                processPrintIM(printIMDirectory, i, randomAccessReader, i8);
                return true;
            } else {
                if (this._currentDirectory instanceof OlympusMakernoteDirectory) {
                    if (i7 == 8208) {
                        pushDirectory(OlympusEquipmentMakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader, set, i, i2);
                        return true;
                    } else if (i7 == 8224) {
                        pushDirectory(OlympusCameraSettingsMakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader, set, i, i2);
                        return true;
                    } else if (i7 == 8256) {
                        pushDirectory(OlympusImageProcessingMakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader, set, i, i2);
                        return true;
                    } else if (i7 == 8272) {
                        pushDirectory(OlympusFocusInfoMakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader, set, i, i2);
                        return true;
                    } else if (i7 == 12288) {
                        pushDirectory(OlympusRawInfoMakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader, set, i, i2);
                        return true;
                    } else if (i7 == 16384) {
                        pushDirectory(OlympusMakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader, set, i, i2);
                        return true;
                    } else if (i7 == 8240) {
                        pushDirectory(OlympusRawDevelopmentMakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader, set, i, i2);
                        return true;
                    } else if (i7 == 8241) {
                        pushDirectory(OlympusRawDevelopment2MakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader, set, i, i2);
                        return true;
                    }
                }
                if (this._currentDirectory instanceof PanasonicRawIFD0Directory) {
                    if (i7 == 19) {
                        PanasonicRawWbInfoDirectory panasonicRawWbInfoDirectory = new PanasonicRawWbInfoDirectory();
                        panasonicRawWbInfoDirectory.setParent(this._currentDirectory);
                        this._metadata.addDirectory(panasonicRawWbInfoDirectory);
                        processBinary(panasonicRawWbInfoDirectory, i, randomAccessReader, i4, (Boolean) null, 2);
                        return true;
                    } else if (i7 == 39) {
                        PanasonicRawWbInfo2Directory panasonicRawWbInfo2Directory = new PanasonicRawWbInfo2Directory();
                        panasonicRawWbInfo2Directory.setParent(this._currentDirectory);
                        this._metadata.addDirectory(panasonicRawWbInfo2Directory);
                        processBinary(panasonicRawWbInfo2Directory, i, randomAccessReader, i4, (Boolean) null, 3);
                        return true;
                    } else if (i7 == 281) {
                        PanasonicRawDistortionDirectory panasonicRawDistortionDirectory = new PanasonicRawDistortionDirectory();
                        panasonicRawDistortionDirectory.setParent(this._currentDirectory);
                        this._metadata.addDirectory(panasonicRawDistortionDirectory);
                        processBinary(panasonicRawDistortionDirectory, i, randomAccessReader, i4, 1, 1);
                        return true;
                    }
                }
                if (i7 == 46 && (this._currentDirectory instanceof PanasonicRawIFD0Directory)) {
                    try {
                        for (Directory next : JpegMetadataReader.readMetadata((InputStream) new ByteArrayInputStream(randomAccessReader.getBytes(i, i8))).getDirectories()) {
                            next.setParent(this._currentDirectory);
                            this._metadata.addDirectory(next);
                        }
                        return true;
                    } catch (JpegProcessingException e) {
                        Directory directory = this._currentDirectory;
                        directory.addError("Error processing JpgFromRaw: " + e.getMessage());
                    } catch (IOException e2) {
                        Directory directory2 = this._currentDirectory;
                        directory2.addError("Error reading JpgFromRaw: " + e2.getMessage());
                    }
                }
                return false;
            }
        } else if (randomAccessReader.getInt8(i) != 28) {
            return false;
        } else {
            byte[] bytes = randomAccessReader.getBytes(i, i8);
            new IptcReader().extract(new SequentialByteArrayReader(bytes), this._metadata, (long) bytes.length, this._currentDirectory);
            return true;
        }
    }

    private static void processBinary(@NotNull Directory directory, int i, @NotNull RandomAccessReader randomAccessReader, int i2, Boolean bool, int i3) throws IOException {
        int i4 = 0;
        while (i4 < i2) {
            if (directory.hasTagName(i4)) {
                if (i4 >= i2 - 1 || !directory.hasTagName(i4 + 1)) {
                    if (bool.booleanValue()) {
                        short[] sArr = new short[i3];
                        for (int i5 = 0; i5 < sArr.length; i5++) {
                            sArr[i5] = randomAccessReader.getInt16(((i4 + i5) * 2) + i);
                        }
                        directory.setObjectArray(i4, sArr);
                    } else {
                        int[] iArr = new int[i3];
                        for (int i6 = 0; i6 < iArr.length; i6++) {
                            iArr[i6] = randomAccessReader.getUInt16(((i4 + i6) * 2) + i);
                        }
                        directory.setObjectArray(i4, iArr);
                    }
                    i4 += i3 - 1;
                } else if (bool.booleanValue()) {
                    directory.setObject(i4, Short.valueOf(randomAccessReader.getInt16((i4 * 2) + i)));
                } else {
                    directory.setObject(i4, Integer.valueOf(randomAccessReader.getUInt16((i4 * 2) + i)));
                }
            }
            i4++;
        }
    }

    @NotNull
    private static String getReaderString(@NotNull RandomAccessReader randomAccessReader, int i, int i2) throws IOException {
        try {
            return randomAccessReader.getString(i, i2, Charsets.UTF_8);
        } catch (BufferBoundsException unused) {
            return "";
        }
    }

    private boolean processMakernote(int i, @NotNull Set<Integer> set, int i2, @NotNull RandomAccessReader randomAccessReader) throws IOException {
        String str;
        int i3 = i;
        Set<Integer> set2 = set;
        int i4 = i2;
        RandomAccessReader randomAccessReader2 = randomAccessReader;
        Directory firstDirectoryOfType = this._metadata.getFirstDirectoryOfType(ExifIFD0Directory.class);
        if (firstDirectoryOfType == null) {
            str = null;
        } else {
            str = firstDirectoryOfType.getString(271);
        }
        String readerString = getReaderString(randomAccessReader2, i3, 2);
        String readerString2 = getReaderString(randomAccessReader2, i3, 3);
        String readerString3 = getReaderString(randomAccessReader2, i3, 4);
        String readerString4 = getReaderString(randomAccessReader2, i3, 5);
        String readerString5 = getReaderString(randomAccessReader2, i3, 6);
        String readerString6 = getReaderString(randomAccessReader2, i3, 7);
        String readerString7 = getReaderString(randomAccessReader2, i3, 8);
        String readerString8 = getReaderString(randomAccessReader2, i3, 9);
        String readerString9 = getReaderString(randomAccessReader2, i3, 10);
        String str2 = readerString8;
        String readerString10 = getReaderString(randomAccessReader2, i3, 12);
        boolean isMotorolaByteOrder = randomAccessReader.isMotorolaByteOrder();
        String str3 = readerString;
        if ("OLYMP\u0000".equals(readerString5) || "EPSON".equals(readerString4) || "AGFA".equals(readerString3)) {
            pushDirectory(OlympusMakernoteDirectory.class);
            TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 8, i4);
        } else if ("OLYMPUS\u0000II".equals(readerString9)) {
            pushDirectory(OlympusMakernoteDirectory.class);
            TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 12, i3);
        } else if (str != null && str.toUpperCase().startsWith("MINOLTA")) {
            pushDirectory(OlympusMakernoteDirectory.class);
            TiffReader.processIfd(this, randomAccessReader2, set2, i3, i4);
        } else if (str == null || !str.trim().toUpperCase().startsWith("NIKON")) {
            if ("SONY CAM".equals(readerString7) || "SONY DSC".equals(readerString7)) {
                pushDirectory(SonyType1MakernoteDirectory.class);
                TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 12, i4);
            } else if (str != null && str.startsWith("SONY") && !Arrays.equals(randomAccessReader2.getBytes(i3, 2), new byte[]{1, 0})) {
                pushDirectory(SonyType1MakernoteDirectory.class);
                TiffReader.processIfd(this, randomAccessReader2, set2, i3, i4);
            } else if ("SEMC MS\u0000\u0000\u0000\u0000\u0000".equals(readerString10)) {
                randomAccessReader2.setMotorolaByteOrder(true);
                pushDirectory(SonyType6MakernoteDirectory.class);
                TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 20, i4);
            } else if ("SIGMA\u0000\u0000\u0000".equals(readerString7) || "FOVEON\u0000\u0000".equals(readerString7)) {
                pushDirectory(SigmaMakernoteDirectory.class);
                TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 10, i4);
            } else if ("KDK".equals(readerString2)) {
                randomAccessReader2.setMotorolaByteOrder(readerString6.equals("KDK INFO"));
                KodakMakernoteDirectory kodakMakernoteDirectory = new KodakMakernoteDirectory();
                this._metadata.addDirectory(kodakMakernoteDirectory);
                processKodakMakernote(kodakMakernoteDirectory, i3, randomAccessReader2);
            } else if ("Canon".equalsIgnoreCase(str)) {
                pushDirectory(CanonMakernoteDirectory.class);
                TiffReader.processIfd(this, randomAccessReader2, set2, i3, i4);
            } else if (str == null || !str.toUpperCase().startsWith("CASIO")) {
                if ("FUJIFILM".equals(readerString7) || "Fujifilm".equalsIgnoreCase(str)) {
                    randomAccessReader2.setMotorolaByteOrder(false);
                    pushDirectory(FujifilmMakernoteDirectory.class);
                    TiffReader.processIfd(this, randomAccessReader2, set2, randomAccessReader2.getInt32(i3 + 8) + i3, i3);
                } else if ("KYOCERA".equals(readerString6)) {
                    pushDirectory(KyoceraMakernoteDirectory.class);
                    TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 22, i4);
                } else if ("LEICA".equals(readerString4)) {
                    randomAccessReader2.setMotorolaByteOrder(false);
                    if ("LEICA\u0000\u0001\u0000".equals(readerString7) || "LEICA\u0000\u0004\u0000".equals(readerString7) || "LEICA\u0000\u0005\u0000".equals(readerString7) || "LEICA\u0000\u0006\u0000".equals(readerString7) || "LEICA\u0000\u0007\u0000".equals(readerString7)) {
                        pushDirectory(LeicaType5MakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 8, i3);
                    } else if ("Leica Camera AG".equals(str)) {
                        pushDirectory(LeicaMakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 8, i4);
                    } else if (!"LEICA".equals(str)) {
                        return false;
                    } else {
                        pushDirectory(PanasonicMakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 8, i4);
                    }
                } else if ("Panasonic\u0000\u0000\u0000".equals(readerString10)) {
                    pushDirectory(PanasonicMakernoteDirectory.class);
                    TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 12, i4);
                } else if ("AOC\u0000".equals(readerString3)) {
                    pushDirectory(CasioType2MakernoteDirectory.class);
                    TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 6, i3);
                } else if (str != null && (str.toUpperCase().startsWith("PENTAX") || str.toUpperCase().startsWith("ASAHI"))) {
                    pushDirectory(PentaxMakernoteDirectory.class);
                    TiffReader.processIfd(this, randomAccessReader2, set2, i3, i3);
                } else if ("SANYO\u0000\u0001\u0000".equals(readerString7)) {
                    pushDirectory(SanyoMakernoteDirectory.class);
                    TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 8, i3);
                } else if (str == null || !str.toLowerCase().startsWith("ricoh")) {
                    if (readerString9.equals("Apple iOS\u0000")) {
                        boolean isMotorolaByteOrder2 = randomAccessReader.isMotorolaByteOrder();
                        randomAccessReader2.setMotorolaByteOrder(true);
                        pushDirectory(AppleMakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 14, i3);
                        randomAccessReader2.setMotorolaByteOrder(isMotorolaByteOrder2);
                    } else if (randomAccessReader2.getUInt16(i3) == 61697) {
                        ReconyxHyperFireMakernoteDirectory reconyxHyperFireMakernoteDirectory = new ReconyxHyperFireMakernoteDirectory();
                        this._metadata.addDirectory(reconyxHyperFireMakernoteDirectory);
                        processReconyxHyperFireMakernote(reconyxHyperFireMakernoteDirectory, i3, randomAccessReader2);
                    } else if (str2.equalsIgnoreCase("RECONYXUF")) {
                        ReconyxUltraFireMakernoteDirectory reconyxUltraFireMakernoteDirectory = new ReconyxUltraFireMakernoteDirectory();
                        this._metadata.addDirectory(reconyxUltraFireMakernoteDirectory);
                        processReconyxUltraFireMakernote(reconyxUltraFireMakernoteDirectory, i3, randomAccessReader2);
                    } else if (!"SAMSUNG".equals(str)) {
                        return false;
                    } else {
                        pushDirectory(SamsungType2MakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader2, set2, i3, i4);
                    }
                } else if (str3.equals("Rv") || readerString2.equals("Rev")) {
                    return false;
                } else {
                    if (readerString4.equalsIgnoreCase("Ricoh")) {
                        randomAccessReader2.setMotorolaByteOrder(true);
                        pushDirectory(RicohMakernoteDirectory.class);
                        TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 8, i3);
                    }
                }
            } else if ("QVC\u0000\u0000\u0000".equals(readerString5)) {
                pushDirectory(CasioType2MakernoteDirectory.class);
                TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 6, i4);
            } else {
                pushDirectory(CasioType1MakernoteDirectory.class);
                TiffReader.processIfd(this, randomAccessReader2, set2, i3, i4);
            }
        } else if ("Nikon".equals(readerString4)) {
            short uInt8 = randomAccessReader2.getUInt8(i3 + 6);
            if (uInt8 == 1) {
                pushDirectory(NikonType1MakernoteDirectory.class);
                TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 8, i4);
            } else if (uInt8 != 2) {
                this._currentDirectory.addError("Unsupported Nikon makernote data ignored.");
            } else {
                pushDirectory(NikonType2MakernoteDirectory.class);
                TiffReader.processIfd(this, randomAccessReader2, set2, i3 + 18, i3 + 10);
            }
        } else {
            pushDirectory(NikonType2MakernoteDirectory.class);
            TiffReader.processIfd(this, randomAccessReader2, set2, i3, i4);
        }
        randomAccessReader2.setMotorolaByteOrder(isMotorolaByteOrder);
        return true;
    }

    private static boolean handlePrintIM(@NotNull Directory directory, int i) {
        if (i == 50341) {
            return true;
        }
        if (i == 3584) {
            return (directory instanceof CasioType2MakernoteDirectory) || (directory instanceof KyoceraMakernoteDirectory) || (directory instanceof NikonType2MakernoteDirectory) || (directory instanceof OlympusMakernoteDirectory) || (directory instanceof PanasonicMakernoteDirectory) || (directory instanceof PentaxMakernoteDirectory) || (directory instanceof RicohMakernoteDirectory) || (directory instanceof SanyoMakernoteDirectory) || (directory instanceof SonyType1MakernoteDirectory);
        }
        return false;
    }

    private static void processPrintIM(@NotNull PrintIMDirectory printIMDirectory, int i, @NotNull RandomAccessReader randomAccessReader, int i2) throws IOException {
        Boolean bool;
        int i3;
        if (i2 == 0) {
            printIMDirectory.addError("Empty PrintIM data");
        } else if (i2 <= 15) {
            printIMDirectory.addError("Bad PrintIM data");
        } else {
            String string = randomAccessReader.getString(i, 12, Charsets.UTF_8);
            if (!string.startsWith("PrintIM")) {
                printIMDirectory.addError("Invalid PrintIM header");
                return;
            }
            int i4 = i + 14;
            int uInt16 = randomAccessReader.getUInt16(i4);
            if (i2 < (uInt16 * 6) + 16) {
                Boolean valueOf = Boolean.valueOf(randomAccessReader.isMotorolaByteOrder());
                randomAccessReader.setMotorolaByteOrder(!randomAccessReader.isMotorolaByteOrder());
                i3 = randomAccessReader.getUInt16(i4);
                if (i2 < (i3 * 6) + 16) {
                    printIMDirectory.addError("Bad PrintIM size");
                    return;
                }
                bool = valueOf;
            } else {
                bool = null;
                i3 = uInt16;
            }
            printIMDirectory.setObject(0, string.substring(8, 12));
            for (int i5 = 0; i5 < i3; i5++) {
                int i6 = i + 16 + (i5 * 6);
                printIMDirectory.setObject(randomAccessReader.getUInt16(i6), Long.valueOf(randomAccessReader.getUInt32(i6 + 2)));
            }
            if (bool != null) {
                randomAccessReader.setMotorolaByteOrder(bool.booleanValue());
            }
        }
    }

    private static void processKodakMakernote(@NotNull KodakMakernoteDirectory kodakMakernoteDirectory, int i, @NotNull RandomAccessReader randomAccessReader) {
        int i2 = i + 8;
        try {
            kodakMakernoteDirectory.setStringValue(0, randomAccessReader.getStringValue(i2, 8, Charsets.UTF_8));
            kodakMakernoteDirectory.setInt(9, randomAccessReader.getUInt8(i2 + 9));
            kodakMakernoteDirectory.setInt(10, randomAccessReader.getUInt8(i2 + 10));
            kodakMakernoteDirectory.setInt(12, randomAccessReader.getUInt16(i2 + 12));
            kodakMakernoteDirectory.setInt(14, randomAccessReader.getUInt16(i2 + 14));
            kodakMakernoteDirectory.setInt(16, randomAccessReader.getUInt16(i2 + 16));
            kodakMakernoteDirectory.setByteArray(18, randomAccessReader.getBytes(i2 + 18, 2));
            kodakMakernoteDirectory.setByteArray(20, randomAccessReader.getBytes(i2 + 20, 4));
            kodakMakernoteDirectory.setInt(24, randomAccessReader.getUInt16(i2 + 24));
            kodakMakernoteDirectory.setInt(27, randomAccessReader.getUInt8(i2 + 27));
            kodakMakernoteDirectory.setInt(28, randomAccessReader.getUInt8(i2 + 28));
            kodakMakernoteDirectory.setInt(29, randomAccessReader.getUInt8(i2 + 29));
            kodakMakernoteDirectory.setInt(30, randomAccessReader.getUInt16(i2 + 30));
            kodakMakernoteDirectory.setLong(32, randomAccessReader.getUInt32(i2 + 32));
            kodakMakernoteDirectory.setInt(36, randomAccessReader.getInt16(i2 + 36));
            kodakMakernoteDirectory.setInt(56, randomAccessReader.getUInt8(i2 + 56));
            kodakMakernoteDirectory.setInt(64, randomAccessReader.getUInt8(i2 + 64));
            kodakMakernoteDirectory.setInt(92, randomAccessReader.getUInt8(i2 + 92));
            kodakMakernoteDirectory.setInt(93, randomAccessReader.getUInt8(i2 + 93));
            kodakMakernoteDirectory.setInt(94, randomAccessReader.getUInt16(i2 + 94));
            kodakMakernoteDirectory.setInt(96, randomAccessReader.getUInt16(i2 + 96));
            kodakMakernoteDirectory.setInt(98, randomAccessReader.getUInt16(i2 + 98));
            kodakMakernoteDirectory.setInt(100, randomAccessReader.getUInt16(i2 + 100));
            kodakMakernoteDirectory.setInt(102, randomAccessReader.getUInt16(i2 + 102));
            kodakMakernoteDirectory.setInt(104, randomAccessReader.getUInt16(i2 + 104));
            kodakMakernoteDirectory.setInt(107, randomAccessReader.getInt8(i2 + 107));
        } catch (IOException e) {
            kodakMakernoteDirectory.addError("Error processing Kodak makernote data: " + e.getMessage());
        }
    }

    private static void processReconyxHyperFireMakernote(@NotNull ReconyxHyperFireMakernoteDirectory reconyxHyperFireMakernoteDirectory, int i, @NotNull RandomAccessReader randomAccessReader) throws IOException {
        Integer num;
        reconyxHyperFireMakernoteDirectory.setObject(0, Integer.valueOf(randomAccessReader.getUInt16(i)));
        int i2 = i + 2;
        int uInt16 = randomAccessReader.getUInt16(i2);
        int uInt162 = randomAccessReader.getUInt16(i2 + 2);
        int uInt163 = randomAccessReader.getUInt16(i2 + 4);
        String str = String.format("%04X", new Object[]{Integer.valueOf(randomAccessReader.getUInt16(i2 + 6))}) + String.format("%04X", new Object[]{Integer.valueOf(randomAccessReader.getUInt16(i2 + 8))});
        try {
            num = Integer.valueOf(Integer.parseInt(str));
        } catch (NumberFormatException unused) {
            num = null;
        }
        if (num != null) {
            reconyxHyperFireMakernoteDirectory.setString(2, String.format("%d.%d.%d.%s", new Object[]{Integer.valueOf(uInt16), Integer.valueOf(uInt162), Integer.valueOf(uInt163), num}));
        } else {
            reconyxHyperFireMakernoteDirectory.setString(2, String.format("%d.%d.%d", new Object[]{Integer.valueOf(uInt16), Integer.valueOf(uInt162), Integer.valueOf(uInt163)}));
            reconyxHyperFireMakernoteDirectory.addError("Error processing Reconyx HyperFire makernote data: build '" + str + "' is not in the expected format and will be omitted from Firmware Version.");
        }
        reconyxHyperFireMakernoteDirectory.setString(12, String.valueOf((char) randomAccessReader.getUInt16(i + 12)));
        int i3 = i + 14;
        reconyxHyperFireMakernoteDirectory.setIntArray(14, new int[]{randomAccessReader.getUInt16(i3), randomAccessReader.getUInt16(i3 + 2)});
        int i4 = i + 18;
        reconyxHyperFireMakernoteDirectory.setInt(18, (randomAccessReader.getUInt16(i4) << 16) + randomAccessReader.getUInt16(i4 + 2));
        int i5 = i + 22;
        int uInt164 = randomAccessReader.getUInt16(i5);
        int uInt165 = randomAccessReader.getUInt16(i5 + 2);
        int uInt166 = randomAccessReader.getUInt16(i5 + 4);
        int uInt167 = randomAccessReader.getUInt16(i5 + 6);
        int uInt168 = randomAccessReader.getUInt16(i5 + 8);
        int uInt169 = randomAccessReader.getUInt16(i5 + 10);
        if (uInt164 < 0 || uInt164 >= 60 || uInt165 < 0 || uInt165 >= 60 || uInt166 < 0 || uInt166 >= 24 || uInt167 < 1 || uInt167 >= 13 || uInt168 < 1 || uInt168 >= 32 || uInt169 < 1 || uInt169 > 9999) {
            reconyxHyperFireMakernoteDirectory.addError("Error processing Reconyx HyperFire makernote data: Date/Time Original " + uInt169 + "-" + uInt167 + "-" + uInt168 + " " + uInt166 + ":" + uInt165 + ":" + uInt164 + " is not a valid date/time.");
        } else {
            reconyxHyperFireMakernoteDirectory.setString(22, String.format("%4d:%2d:%2d %2d:%2d:%2d", new Object[]{Integer.valueOf(uInt169), Integer.valueOf(uInt167), Integer.valueOf(uInt168), Integer.valueOf(uInt166), Integer.valueOf(uInt165), Integer.valueOf(uInt164)}));
        }
        reconyxHyperFireMakernoteDirectory.setInt(36, randomAccessReader.getUInt16(i + 36));
        reconyxHyperFireMakernoteDirectory.setInt(38, randomAccessReader.getInt16(i + 38));
        reconyxHyperFireMakernoteDirectory.setInt(40, randomAccessReader.getInt16(i + 40));
        reconyxHyperFireMakernoteDirectory.setStringValue(42, new StringValue(randomAccessReader.getBytes(i + 42, 28), Charsets.UTF_16LE));
        reconyxHyperFireMakernoteDirectory.setInt(72, randomAccessReader.getUInt16(i + 72));
        reconyxHyperFireMakernoteDirectory.setInt(74, randomAccessReader.getUInt16(i + 74));
        reconyxHyperFireMakernoteDirectory.setInt(76, randomAccessReader.getUInt16(i + 76));
        reconyxHyperFireMakernoteDirectory.setInt(78, randomAccessReader.getUInt16(i + 78));
        reconyxHyperFireMakernoteDirectory.setInt(80, randomAccessReader.getUInt16(i + 80));
        reconyxHyperFireMakernoteDirectory.setInt(82, randomAccessReader.getUInt16(i + 82));
        double uInt1610 = (double) randomAccessReader.getUInt16(i + 84);
        Double.isNaN(uInt1610);
        reconyxHyperFireMakernoteDirectory.setDouble(84, uInt1610 / 1000.0d);
        reconyxHyperFireMakernoteDirectory.setString(86, randomAccessReader.getNullTerminatedString(i + 86, 44, Charsets.UTF_8));
    }

    private static void processReconyxUltraFireMakernote(@NotNull ReconyxUltraFireMakernoteDirectory reconyxUltraFireMakernoteDirectory, int i, @NotNull RandomAccessReader randomAccessReader) throws IOException {
        reconyxUltraFireMakernoteDirectory.setString(0, randomAccessReader.getString(i, 9, Charsets.UTF_8));
        reconyxUltraFireMakernoteDirectory.setString(52, randomAccessReader.getString(i + 52, 1, Charsets.UTF_8));
        int i2 = i + 53;
        reconyxUltraFireMakernoteDirectory.setIntArray(53, new int[]{randomAccessReader.getByte(i2), randomAccessReader.getByte(i2 + 1)});
        int i3 = i + 59;
        randomAccessReader.getByte(i3);
        randomAccessReader.getByte(i3 + 1);
        randomAccessReader.getByte(i3 + 2);
        randomAccessReader.getByte(i3 + 3);
        randomAccessReader.getByte(i3 + 4);
        reconyxUltraFireMakernoteDirectory.setInt(67, randomAccessReader.getByte(i + 67));
        reconyxUltraFireMakernoteDirectory.setInt(72, randomAccessReader.getByte(i + 72));
        reconyxUltraFireMakernoteDirectory.setStringValue(75, new StringValue(randomAccessReader.getBytes(i + 75, 14), Charsets.UTF_8));
        reconyxUltraFireMakernoteDirectory.setString(80, randomAccessReader.getNullTerminatedString(i + 80, 20, Charsets.UTF_8));
    }
}
