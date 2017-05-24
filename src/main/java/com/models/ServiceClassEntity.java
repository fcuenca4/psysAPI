package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/24/17.
 */
@Entity
@Table(name = "PPS_SERVICE_CLASSES", schema = "PREPAID_SCH", catalog = "")
public class ServiceClassEntity {
    private long sclId;
    private String sclServiceClass;
    private Timestamp sclLastUpdateUtc;


    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
    @SequenceGenerator(
            name="course_seq",
            sequenceName="SEQ_PPS_SCL_ID",
            allocationSize=20
    )
    @Column(name = "SCL_ID", nullable = false, precision = 0)
    public long getSclId() {
        return sclId;
    }

    public void setSclId(long sclId) {
        this.sclId = sclId;
    }

    @Basic
    @Column(name = "SCL_SERVICE_CLASS", nullable = false, length = 256)
    public String getSclServiceClass() {
        return sclServiceClass;
    }

    public void setSclServiceClass(String sclServiceClass) {
        this.sclServiceClass = sclServiceClass;
    }

    @Basic
    @Column(name = "SCL_LAST_UPDATE_UTC", nullable = true)
    public Timestamp getSclLastUpdateUtc() {
        return sclLastUpdateUtc;
    }

    public void setSclLastUpdateUtc(Timestamp sclLastUpdateUtc) {
        this.sclLastUpdateUtc = sclLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceClassEntity that = (ServiceClassEntity) o;

        if (sclId != that.sclId) return false;
        if (sclServiceClass != null ? !sclServiceClass.equals(that.sclServiceClass) : that.sclServiceClass != null)
            return false;
        if (sclLastUpdateUtc != null ? !sclLastUpdateUtc.equals(that.sclLastUpdateUtc) : that.sclLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (sclId ^ (sclId >>> 32));
        result = 31 * result + (sclServiceClass != null ? sclServiceClass.hashCode() : 0);
        result = 31 * result + (sclLastUpdateUtc != null ? sclLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
