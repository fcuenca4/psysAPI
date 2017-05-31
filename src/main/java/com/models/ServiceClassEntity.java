package com.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by fcuenca on 5/30/17.
 */
@Entity
@Table(name = "SERVICE_CLASS")
public class ServiceClassEntity {
    private long sclassId;
    private String sclassName;
    private String sclassDescription;
    private Timestamp sclassLastUpdateUtc;
    @SequenceGenerator(
            allocationSize = 1,
            name="course_seq",
            sequenceName="SEQ_PPS_SCLASS_ID"
    )
    @GeneratedValue(generator = "course_seq")
    @Id
    @Column(name = "SCLASS_ID", nullable = false, precision = 0)
    public long getSclassId() {
        return sclassId;
    }

    public void setSclassId(long sclassId) {
        this.sclassId = sclassId;
    }

    @Basic
    @Column(name = "SCLASS_NAME", nullable = true, length = 128)
    public String getSclassName() {
        return sclassName;
    }

    public void setSclassName(String sclassName) {
        this.sclassName = sclassName;
    }

    @Basic
    @Column(name = "SCLASS_DESCRIPTION", nullable = true, length = 1024)
    public String getSclassDescription() {
        return sclassDescription;
    }

    public void setSclassDescription(String sclassDescription) {
        this.sclassDescription = sclassDescription;
    }

    @Basic
    @Column(name = "SCLASS_LAST_UPDATE_UTC", nullable = false)
    public Timestamp getSclassLastUpdateUtc() {
        return sclassLastUpdateUtc;
    }

    public void setSclassLastUpdateUtc(Timestamp sclassLastUpdateUtc) {
        this.sclassLastUpdateUtc = sclassLastUpdateUtc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ServiceClassEntity that = (ServiceClassEntity) o;

        if (sclassId != that.sclassId) return false;
        if (sclassName != null ? !sclassName.equals(that.sclassName) : that.sclassName != null) return false;
        if (sclassDescription != null ? !sclassDescription.equals(that.sclassDescription) : that.sclassDescription != null)
            return false;
        if (sclassLastUpdateUtc != null ? !sclassLastUpdateUtc.equals(that.sclassLastUpdateUtc) : that.sclassLastUpdateUtc != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (sclassId ^ (sclassId >>> 32));
        result = 31 * result + (sclassName != null ? sclassName.hashCode() : 0);
        result = 31 * result + (sclassDescription != null ? sclassDescription.hashCode() : 0);
        result = 31 * result + (sclassLastUpdateUtc != null ? sclassLastUpdateUtc.hashCode() : 0);
        return result;
    }
}
