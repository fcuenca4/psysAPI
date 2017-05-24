package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/24/17.
 */
@Entity
@Table(name = "PPS_CALL_HUNTING", schema = "PREPAID_SCH", catalog = "")
public class CallHuntingEntity {
    private long chtId;
    private long chtScbId;
    private long chtPriority;
    private long chtDn;
    private Timestamp chtLastUpdateUtc;

    @Id
    @Column(name = "CHT_ID", nullable = false, precision = 0)
    public long getChtId() {
        return chtId;
    }

    public void setChtId(long chtId) {
        this.chtId = chtId;
    }

    @Basic
    @Column(name = "CHT_SCB_ID", nullable = false, precision = 0)
    public long getChtScbId() {
        return chtScbId;
    }

    public void setChtScbId(long chtScbId) {
        this.chtScbId = chtScbId;
    }

    @Basic
    @Column(name = "CHT_PRIORITY", nullable = false, precision = 0)
    public long getChtPriority() {
        return chtPriority;
    }

    public void setChtPriority(long chtPriority) {
        this.chtPriority = chtPriority;
    }

    @Basic
    @Column(name = "CHT_DN", nullable = false, precision = 0)
    public long getChtDn() {
        return chtDn;
    }

    public void setChtDn(long chtDn) {
        this.chtDn = chtDn;
    }

    @Basic
    @Column(name = "CHT_LAST_UPDATE_UTC", nullable = true)
    public Timestamp getChtLastUpdateUtc() {
        return chtLastUpdateUtc;
    }

    public void setChtLastUpdateUtc(Timestamp chtLastUpdateUtc) {
        this.chtLastUpdateUtc = chtLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallHuntingEntity that = (CallHuntingEntity) o;

        if (chtId != that.chtId) return false;
        if (chtScbId != that.chtScbId) return false;
        if (chtPriority != that.chtPriority) return false;
        if (chtDn != that.chtDn) return false;
        if (chtLastUpdateUtc != null ? !chtLastUpdateUtc.equals(that.chtLastUpdateUtc) : that.chtLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (chtId ^ (chtId >>> 32));
        result = 31 * result + (int) (chtScbId ^ (chtScbId >>> 32));
        result = 31 * result + (int) (chtPriority ^ (chtPriority >>> 32));
        result = 31 * result + (int) (chtDn ^ (chtDn >>> 32));
        result = 31 * result + (chtLastUpdateUtc != null ? chtLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
