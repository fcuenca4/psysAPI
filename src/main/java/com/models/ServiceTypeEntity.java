package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "PPS_SERVICE_TYPES")
public class ServiceTypeEntity {
    private long svtId;
    private String svtServiceType;
    private Timestamp svtLastUpdateUtc;
    @SequenceGenerator(
            allocationSize = 1,
            name="course_seq",
            sequenceName="SEQ_PPS_SVT_ID"
    )
    @GeneratedValue(generator = "course_seq")

    @Id
    @Column(name = "SVT_ID", nullable = false, precision = 0)
    public long getSvtId() {
        return svtId;
    }

    public void setSvtId(long svtId) {
        this.svtId = svtId;
    }

    @Basic
    @Column(name = "SVT_SERVICE_TYPE", nullable = true, length = 256)
    public String getSvtServiceType() {
        return svtServiceType;
    }

    public void setSvtServiceType(String svtServiceType) {
        this.svtServiceType = svtServiceType;
    }

    @Basic
    @Column(name = "SVT_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getSvtLastUpdateUtc() {
        return svtLastUpdateUtc;
    }

    public void setSvtLastUpdateUtc(Timestamp svtLastUpdateUtc) {
        this.svtLastUpdateUtc = svtLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceTypeEntity that = (ServiceTypeEntity) o;

        if (svtId != that.svtId) return false;
        if (svtServiceType != null ? !svtServiceType.equals(that.svtServiceType) : that.svtServiceType != null)
            return false;
        if (svtLastUpdateUtc != null ? !svtLastUpdateUtc.equals(that.svtLastUpdateUtc) : that.svtLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (svtId ^ (svtId >>> 32));
        result = 31 * result + (svtServiceType != null ? svtServiceType.hashCode() : 0);
        result = 31 * result + (svtLastUpdateUtc != null ? svtLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
