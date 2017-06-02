package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "PPS_LOCKED_NUMBERS")
public class LockedNumberEntity {
    private long lckId;
    private Long lckScbId;
    private String lckDn;
    private Long lckSvtId;
    private Timestamp lckLastUpdateUtc;
    @SequenceGenerator(
            allocationSize = 1,
            name="lockednumber_seq",
            sequenceName="SEQ_PPS_LCK_ID"
    )
    @Id
    @GeneratedValue(generator = "lockednumber_seq")

    @Column(name = "LCK_ID", nullable = false, precision = 0)
    public long getLckId() {
        return lckId;
    }

    public void setLckId(long lckId) {
        this.lckId = lckId;
    }

    @Basic
    @Column(name = "LCK_SCB_ID", nullable = true, precision = 0)
    public Long getLckScbId() {
        return lckScbId;
    }

    public void setLckScbId(Long lckScbId) {
        this.lckScbId = lckScbId;
    }

    @Basic
    @Column(name = "LCK_DN", nullable = true, length = 64)
    public String getLckDn() {
        return lckDn;
    }

    public void setLckDn(String bwlDn) {
        this.lckDn = bwlDn;
    }

    @Basic
    @Column(name = "LCK_SVT_ID", nullable = true, precision = 0)
    public Long getLckSvtId() {
        return lckSvtId;
    }

    public void setLckSvtId(Long lckSvtId) {
        this.lckSvtId = lckSvtId;
    }

    @Basic
    @Column(name = "LCK_LAST_UPDATE_UTC", nullable = false)
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
        if (lckScbId != null ? !lckScbId.equals(that.lckScbId) : that.lckScbId != null) return false;
        if (lckDn != null ? !lckDn.equals(that.lckDn) : that.lckDn != null) return false;
        if (lckSvtId != null ? !lckSvtId.equals(that.lckSvtId) : that.lckSvtId != null) return false;
        if (lckLastUpdateUtc != null ? !lckLastUpdateUtc.equals(that.lckLastUpdateUtc) : that.lckLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (lckId ^ (lckId >>> 32));
        result = 31 * result + (lckScbId != null ? lckScbId.hashCode() : 0);
        result = 31 * result + (lckDn != null ? lckDn.hashCode() : 0);
        result = 31 * result + (lckSvtId != null ? lckSvtId.hashCode() : 0);
        result = 31 * result + (lckLastUpdateUtc != null ? lckLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
