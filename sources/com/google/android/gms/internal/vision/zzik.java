package com.google.android.gms.internal.vision;

final class zzik {
    static String zzd(zzeo zzeo) {
        zzil zzil = new zzil(zzeo);
        StringBuilder sb = new StringBuilder(zzil.size());
        for (int i = 0; i < zzil.size(); i++) {
            byte zzai = zzil.zzai(i);
            if (zzai == 34) {
                sb.append("\\\"");
            } else if (zzai == 39) {
                sb.append("\\'");
            } else if (zzai != 92) {
                switch (zzai) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (zzai >= 32 && zzai <= 126) {
                            sb.append((char) zzai);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((zzai >>> 6) & 3) + 48));
                            sb.append((char) (((zzai >>> 3) & 7) + 48));
                            sb.append((char) ((zzai & 7) + 48));
                            break;
                        }
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }
}
