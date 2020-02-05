package okio;

import com.google.common.primitives.UnsignedBytes;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    public static Options of(ByteString... byteStringArr) {
        if (byteStringArr.length == 0) {
            return new Options(new ByteString[0], new int[]{0, -1});
        }
        ArrayList arrayList = new ArrayList(Arrays.asList(byteStringArr));
        Collections.sort(arrayList);
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < arrayList.size(); i++) {
            arrayList2.add(-1);
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            arrayList2.set(Collections.binarySearch(arrayList, byteStringArr[i2]), Integer.valueOf(i2));
        }
        if (((ByteString) arrayList.get(0)).size() != 0) {
            int i3 = 0;
            while (i3 < arrayList.size()) {
                ByteString byteString = (ByteString) arrayList.get(i3);
                int i4 = i3 + 1;
                int i5 = i4;
                while (i5 < arrayList.size()) {
                    ByteString byteString2 = (ByteString) arrayList.get(i5);
                    if (!byteString2.startsWith(byteString)) {
                        continue;
                        break;
                    } else if (byteString2.size() == byteString.size()) {
                        throw new IllegalArgumentException("duplicate option: " + byteString2);
                    } else if (((Integer) arrayList2.get(i5)).intValue() > ((Integer) arrayList2.get(i3)).intValue()) {
                        arrayList.remove(i5);
                        arrayList2.remove(i5);
                    } else {
                        i5++;
                    }
                }
                i3 = i4;
            }
            Buffer buffer = new Buffer();
            buildTrieRecursive(0, buffer, 0, arrayList, 0, arrayList.size(), arrayList2);
            int[] iArr = new int[intCount(buffer)];
            for (int i6 = 0; i6 < iArr.length; i6++) {
                iArr[i6] = buffer.readInt();
            }
            if (buffer.exhausted()) {
                return new Options((ByteString[]) byteStringArr.clone(), iArr);
            }
            throw new AssertionError();
        }
        throw new IllegalArgumentException("the empty byte string is not a supported option");
    }

    private static void buildTrieRecursive(long j, Buffer buffer, int i, List<ByteString> list, int i2, int i3, List<Integer> list2) {
        int i4;
        int i5;
        Buffer buffer2;
        int i6;
        Buffer buffer3 = buffer;
        int i7 = i;
        List<ByteString> list3 = list;
        int i8 = i2;
        int i9 = i3;
        List<Integer> list4 = list2;
        if (i8 < i9) {
            int i10 = i8;
            while (i10 < i9) {
                if (list3.get(i10).size() >= i7) {
                    i10++;
                } else {
                    throw new AssertionError();
                }
            }
            ByteString byteString = list.get(i2);
            ByteString byteString2 = list3.get(i9 - 1);
            int i11 = -1;
            if (i7 == byteString.size()) {
                i11 = list4.get(i8).intValue();
                i8++;
                byteString = list3.get(i8);
            }
            int i12 = i8;
            if (byteString.getByte(i7) != byteString2.getByte(i7)) {
                int i13 = 1;
                for (int i14 = i12 + 1; i14 < i9; i14++) {
                    if (list3.get(i14 - 1).getByte(i7) != list3.get(i14).getByte(i7)) {
                        i13++;
                    }
                }
                long intCount = j + ((long) intCount(buffer)) + 2 + ((long) (i13 * 2));
                buffer3.writeInt(i13);
                buffer3.writeInt(i11);
                for (int i15 = i12; i15 < i9; i15++) {
                    byte b = list3.get(i15).getByte(i7);
                    if (i15 == i12 || b != list3.get(i15 - 1).getByte(i7)) {
                        buffer3.writeInt((int) b & UnsignedBytes.MAX_VALUE);
                    }
                }
                Buffer buffer4 = new Buffer();
                int i16 = i12;
                while (i16 < i9) {
                    byte b2 = list3.get(i16).getByte(i7);
                    int i17 = i16 + 1;
                    int i18 = i17;
                    while (true) {
                        if (i18 >= i9) {
                            i5 = i9;
                            break;
                        } else if (b2 != list3.get(i18).getByte(i7)) {
                            i5 = i18;
                            break;
                        } else {
                            i18++;
                        }
                    }
                    if (i17 == i5 && i7 + 1 == list3.get(i16).size()) {
                        buffer3.writeInt(list4.get(i16).intValue());
                        i6 = i5;
                        buffer2 = buffer4;
                    } else {
                        buffer3.writeInt((int) ((((long) intCount(buffer4)) + intCount) * -1));
                        i6 = i5;
                        buffer2 = buffer4;
                        buildTrieRecursive(intCount, buffer4, i7 + 1, list, i16, i5, list2);
                    }
                    buffer4 = buffer2;
                    i16 = i6;
                }
                Buffer buffer5 = buffer4;
                buffer3.write(buffer5, buffer5.size());
                return;
            }
            int min = Math.min(byteString.size(), byteString2.size());
            int i19 = i7;
            int i20 = 0;
            while (i19 < min && byteString.getByte(i19) == byteString2.getByte(i19)) {
                i20++;
                i19++;
            }
            long intCount2 = 1 + j + ((long) intCount(buffer)) + 2 + ((long) i20);
            buffer3.writeInt(-i20);
            buffer3.writeInt(i11);
            int i21 = i7;
            while (true) {
                i4 = i7 + i20;
                if (i21 >= i4) {
                    break;
                }
                buffer3.writeInt((int) byteString.getByte(i21) & UnsignedBytes.MAX_VALUE);
                i21++;
            }
            if (i12 + 1 != i9) {
                Buffer buffer6 = new Buffer();
                buffer3.writeInt((int) ((((long) intCount(buffer6)) + intCount2) * -1));
                buildTrieRecursive(intCount2, buffer6, i4, list, i12, i3, list2);
                buffer3.write(buffer6, buffer6.size());
            } else if (i4 == list3.get(i12).size()) {
                buffer3.writeInt(list4.get(i12).intValue());
            } else {
                throw new AssertionError();
            }
        } else {
            throw new AssertionError();
        }
    }

    public ByteString get(int i) {
        return this.byteStrings[i];
    }

    public final int size() {
        return this.byteStrings.length;
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }
}
