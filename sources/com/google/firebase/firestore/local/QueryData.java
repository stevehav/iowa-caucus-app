package com.google.firebase.firestore.local;

import com.google.common.base.Preconditions;
import com.google.firebase.firestore.core.Query;
import com.google.firebase.firestore.model.SnapshotVersion;
import com.google.firebase.firestore.remote.WatchStream;
import com.google.protobuf.ByteString;

/* compiled from: com.google.firebase:firebase-firestore@@20.2.0 */
public final class QueryData {
    private final QueryPurpose purpose;
    private final Query query;
    private final ByteString resumeToken;
    private final long sequenceNumber;
    private final SnapshotVersion snapshotVersion;
    private final int targetId;

    public QueryData(Query query2, int i, long j, QueryPurpose queryPurpose, SnapshotVersion snapshotVersion2, ByteString byteString) {
        this.query = (Query) Preconditions.checkNotNull(query2);
        this.targetId = i;
        this.sequenceNumber = j;
        this.purpose = queryPurpose;
        this.snapshotVersion = (SnapshotVersion) Preconditions.checkNotNull(snapshotVersion2);
        this.resumeToken = (ByteString) Preconditions.checkNotNull(byteString);
    }

    public QueryData(Query query2, int i, long j, QueryPurpose queryPurpose) {
        this(query2, i, j, queryPurpose, SnapshotVersion.NONE, WatchStream.EMPTY_RESUME_TOKEN);
    }

    public Query getQuery() {
        return this.query;
    }

    public int getTargetId() {
        return this.targetId;
    }

    public long getSequenceNumber() {
        return this.sequenceNumber;
    }

    public QueryPurpose getPurpose() {
        return this.purpose;
    }

    public SnapshotVersion getSnapshotVersion() {
        return this.snapshotVersion;
    }

    public ByteString getResumeToken() {
        return this.resumeToken;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        QueryData queryData = (QueryData) obj;
        if (!this.query.equals(queryData.query) || this.targetId != queryData.targetId || this.sequenceNumber != queryData.sequenceNumber || !this.purpose.equals(queryData.purpose) || !this.snapshotVersion.equals(queryData.snapshotVersion) || !this.resumeToken.equals(queryData.resumeToken)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return (((((((((this.query.hashCode() * 31) + this.targetId) * 31) + ((int) this.sequenceNumber)) * 31) + this.purpose.hashCode()) * 31) + this.snapshotVersion.hashCode()) * 31) + this.resumeToken.hashCode();
    }

    public String toString() {
        return "QueryData{query=" + this.query + ", targetId=" + this.targetId + ", sequenceNumber=" + this.sequenceNumber + ", purpose=" + this.purpose + ", snapshotVersion=" + this.snapshotVersion + ", resumeToken=" + this.resumeToken + '}';
    }

    public QueryData copy(SnapshotVersion snapshotVersion2, ByteString byteString, long j) {
        return new QueryData(this.query, this.targetId, j, this.purpose, snapshotVersion2, byteString);
    }
}
