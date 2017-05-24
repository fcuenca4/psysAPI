package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/24/17.
 */
@Entity
@Table(name = "PPS_LOCKED_NUMBERS", schema = "PREPAID_SCH", catalog = "")
public class LockedNumberEntity {
    private long lckId;
    private long lckScbId;
    private long lckDn;
    private long lckSvtId;
    private Timestamp lckLastUpdateUtc;

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
    @SequenceGenerator(
            name="course_seq",
            sequenceName="SEQ_PPS_LCK_ID",
            allocationSize=20
    )
    @Column(name = "LCK_ID", nullable = false, precision = 0)
    public long getLckId() {
        return lckId;
    }

    public void setLckId(long lckId) {
        this.lckId = lckId;
    }

    @Basic
    @Column(name = "LCK_SCB_ID", nullable = false, precision = 0)
    public long getLckScbId() {
        return lckScbId;
    }

    public void setLckScbId(long lckScbId) {
        this.lckScbId = lckScbId;
    }

    @Basic
    @Column(name = "LCK_DN", nullable = false, precision = 0)
    public long getLckDn() {
        return lckDn;
    }

    public void setLckDn(long lckDn) {
        this.lckDn = lckDn;
    }

    @Basic
    @Column(name = "LCK_SVT_ID", nullable = false, precision = 0)
    public long getLckSvtId() {
        return lckSvtId;
    }

    public void setLckSvtId(long lckSvtId) {
        this.lckSvtId = lckSvtId;
    }

    @Basic
    @Column(name = "LCK_LAST_UPDATE_UTC", nullable = true)
    public Timestamp getLckLastUpdateUtc() {
        return lckLastUpdateUtc;
    }

    public void setLckLastUpdateUtc(Timestamp lckLastUpdateUtc) {
        this.lckLastUpdateUtc = lckLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LockedNumberEntity that = (LockedNumberEntity) o;

        if (lckId != that.lckId) return false;
        if (lckScbId != that.lckScbId) return false;
        if (lckDn != that.lckDn) return false;
        if (lckSvtId != that.lckSvtId) return false;
        if (lckLastUpdateUtc != null ? !lckLastUpdateUtc.equals(that.lckLastUpdateUtc) : that.lckLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (lckId ^ (lckId >>> 32));
        result = 31 * result + (int) (lckScbId ^ (lckScbId >>> 32));
        result = 31 * result + (int) (lckDn ^ (lckDn >>> 32));
        result = 31 * result + (int) (lckSvtId ^ (lckSvtId >>> 32));
        result = 31 * result + (lckLastUpdateUtc != null ? lckLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
