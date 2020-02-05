package io.grpc;

import com.google.common.base.Preconditions;

@ExperimentalApi("https://github.com/grpc/grpc-java/issues/1771")
public final class ConnectivityStateInfo {
    private final ConnectivityState state;
    private final Status status;

    public static ConnectivityStateInfo forNonError(ConnectivityState connectivityState) {
        Preconditions.checkArgument(connectivityState != ConnectivityState.TRANSIENT_FAILURE, "state is TRANSIENT_ERROR. Use forError() instead");
        return new ConnectivityStateInfo(connectivityState, Status.OK);
    }

    public static ConnectivityStateInfo forTransientFailure(Status status2) {
        Preconditions.checkArgument(!status2.isOk(), "The error status must not be OK");
        return new ConnectivityStateInfo(ConnectivityState.TRANSIENT_FAILURE, status2);
    }

    public ConnectivityState getState() {
        return this.state;
    }

    public Status getStatus() {
        return this.status;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectivityStateInfo)) {
            return false;
        }
        ConnectivityStateInfo connectivityStateInfo = (ConnectivityStateInfo) obj;
        if (!this.state.equals(connectivityStateInfo.state) || !this.status.equals(connectivityStateInfo.status)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return this.state.hashCode() ^ this.status.hashCode();
    }

    public String toString() {
        if (this.status.isOk()) {
            return this.state.toString();
        }
        return this.state + "(" + this.status + ")";
    }

    private ConnectivityStateInfo(ConnectivityState connectivityState, Status status2) {
        this.state = (ConnectivityState) Preconditions.checkNotNull(connectivityState, "state is null");
        this.status = (Status) Preconditions.checkNotNull(status2, "status is null");
    }
}
