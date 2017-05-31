package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "SERVICE_CLASS_ITEMS")
public class ServiceClassItemEntity {
    private long sciId;
    private Long sciSclassId;
    private Long sciSitemId;
    private Timestamp sciLastUpdateUtc;

    @SequenceGenerator(
            allocationSize = 1,
            name = "course_seq",
            sequenceName = "SEQ_PPS_SCI_ID"
    )
    @GeneratedValue(generator = "course_seq")

    @Id
    @Column(name = "SCI_ID", nullable = false, precision = 0)
    public long getSciId() {
        return sciId;
    }

    public void setSciId(long sciId) {
        this.sciId = sciId;
    }

    @Basic
    @Column(name = "SCI_SCLASS_ID", nullable = true, precision = 0)
    public Long getSciSclassId() {
        return sciSclassId;
    }

    public void setSciSclassId(Long sciSclassId) {
        this.sciSclassId = sciSclassId;
    }

    @Basic
    @Column(name = "SCI_SITEM_ID", nullable = true, precision = 0)
    public Long getSciSitemId() {
        return sciSitemId;
    }

    public void setSciSitemId(Long sciSitemId) {
        this.sciSitemId = sciSitemId;
    }

    @Basic
    @Column(name = "SCI_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getSciLastUpdateUtc() {
        return sciLastUpdateUtc;
    }

    public void setSciLastUpdateUtc(Timestamp sciLastUpdateUtc) {
        this.sciLastUpdateUtc = sciLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceClassItemEntity that = (ServiceClassItemEntity) o;

        if (sciId != that.sciId) return false;
        if (sciSclassId != null ? !sciSclassId.equals(that.sciSclassId) : that.sciSclassId != null) return false;
        if (sciSitemId != null ? !sciSitemId.equals(that.sciSitemId) : that.sciSitemId != null) return false;
        return sciLastUpdateUtc != null ? sciLastUpdateUtc.equals(that.sciLastUpdateUtc) : that.sciLastUpdateUtc == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (sciId ^ (sciId >>> 32));
        result = 31 * result + (sciSclassId != null ? sciSclassId.hashCode() : 0);
        result = 31 * result + (sciSitemId != null ? sciSitemId.hashCode() : 0);
        result = 31 * result + (sciLastUpdateUtc != null ? sciLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
