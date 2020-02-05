package com.google.firebase;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.common.base.Preconditions;
import com.google.firebase.annotations.PublicApi;
import java.util.Date;

@PublicApi
/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class Timestamp implements Comparable<Timestamp>, Parcelable {
    @PublicApi
    @NonNull
    public static final Parcelable.Creator<Timestamp> CREATOR = new Parcelable.Creator<Timestamp>() {
        public Timestamp createFromParcel(Parcel parcel) {
            return new Timestamp(parcel);
        }

        public Timestamp[] newArray(int i) {
            return new Timestamp[i];
        }
    };
    private final int nanoseconds;
    private final long seconds;

    public int describeContents() {
        return 0;
    }

    @PublicApi
    public Timestamp(long j, int i) {
        validateRange(j, i);
        this.seconds = j;
        this.nanoseconds = i;
    }

    protected Timestamp(Parcel parcel) {
        this.seconds = parcel.readLong();
        this.nanoseconds = parcel.readInt();
    }

    @PublicApi
    public Timestamp(Date date) {
        long time = date.getTime();
        long j = time / 1000;
        int i = ((int) (time % 1000)) * 1000000;
        if (i < 0) {
            j--;
            i += 1000000000;
        }
        validateRange(j, i);
        this.seconds = j;
        this.nanoseconds = i;
    }

    @PublicApi
    @NonNull
    public static Timestamp now() {
        return new Timestamp(new Date());
    }

    @PublicApi
    public long getSeconds() {
        return this.seconds;
    }

    @PublicApi
    public int getNanoseconds() {
        return this.nanoseconds;
    }

    @PublicApi
    @NonNull
    public Date toDate() {
        return new Date((this.seconds * 1000) + ((long) (this.nanoseconds / 1000000)));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.seconds);
        parcel.writeInt(this.nanoseconds);
    }

    @PublicApi
    public int compareTo(Timestamp timestamp) {
        long j = this.seconds;
        long j2 = timestamp.seconds;
        if (j == j2) {
            return Integer.signum(this.nanoseconds - timestamp.nanoseconds);
        }
        return Long.signum(j - j2);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof Timestamp) && compareTo((Timestamp) obj) == 0) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        long j = this.seconds;
        return (((((int) j) * 37 * 37) + ((int) (j >> 32))) * 37) + this.nanoseconds;
    }

    public String toString() {
        return "Timestamp(seconds=" + this.seconds + ", nanoseconds=" + this.nanoseconds + ")";
    }

    private static void validateRange(long j, int i) {
        boolean z = true;
        Preconditions.checkArgument(i >= 0, "Timestamp nanoseconds out of range: %s", i);
        Preconditions.checkArgument(((double) i) < 1.0E9d, "Timestamp nanoseconds out of range: %s", i);
        Preconditions.checkArgument(j >= -62135596800L, "Timestamp seconds out of range: %s", j);
        if (j >= 253402300800L) {
            z = false;
        }
        Preconditions.checkArgument(z, "Timestamp seconds out of range: %s", j);
    }
}
