package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "PPS_CALL_HUNTING", schema = "PREPAID_SCH", catalog = "")
public class CallHuntingEntity {
    private long chtId;
    private Long chtScbId;
    private Long chtPriority;
    private Long chtDn;
    private Timestamp chtLastUpdateUtc;
    @SequenceGenerator(
            allocationSize = 1,
            name="course_seq",
            sequenceName="SEQ_PPS_CHT_ID")
    @GeneratedValue(generator = "course_seq")
    @Id
    @Column(name = "CHT_ID", nullable = false, precision = 0)
    public long getChtId() {
        return chtId;
    }

    public void setChtId(long chtId) {
        this.chtId = chtId;
    }

    @Basic
    @Column(name = "CHT_SCB_ID", nullable = true, precision = 0)
    public Long getChtScbId() {
        return chtScbId;
    }

    public void setChtScbId(Long chtScbId) {
        this.chtScbId = chtScbId;
    }

    @Basic
    @Column(name = "CHT_PRIORITY", nullable = true, precision = 0)
    public Long getChtPriority() {
        return chtPriority;
    }

    public void setChtPriority(Long chtPriority) {
        this.chtPriority = chtPriority;
    }

    @Basic
    @Column(name = "CHT_DN", nullable = true, precision = 0)
    public Long getChtDn() {
        return chtDn;
    }

    public void setChtDn(Long chtDn) {
        this.chtDn = chtDn;
    }

    @Basic
    @Column(name = "CHT_LAST_UPDATE_UTC", nullable = false)
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
        if (chtScbId != null ? !chtScbId.equals(that.chtScbId) : that.chtScbId != null) return false;
        if (chtPriority != null ? !chtPriority.equals(that.chtPriority) : that.chtPriority != null) return false;
        if (chtDn != null ? !chtDn.equals(that.chtDn) : that.chtDn != null) return false;
        if (chtLastUpdateUtc != null ? !chtLastUpdateUtc.equals(that.chtLastUpdateUtc) : that.chtLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (chtId ^ (chtId >>> 32));
        result = 31 * result + (chtScbId != null ? chtScbId.hashCode() : 0);
        result = 31 * result + (chtPriority != null ? chtPriority.hashCode() : 0);
        result = 31 * result + (chtDn != null ? chtDn.hashCode() : 0);
        result = 31 * result + (chtLastUpdateUtc != null ? chtLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
